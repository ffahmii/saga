/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saga;

import static com.saga.Database.JDBC_DRIVER;
import static com.saga.Database.table_name;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hansel
 */
public class DBSaga_User {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/law";
    static final String USER = "root";
    static final String PASS = "";
    static final String table_name = "saga_user";
    String col_label_username ="username";
    String col_label_password ="password";
    String col_label_ccn ="CCN";
    String col_label_alamat ="alamat";
    String col_label_email ="email";
    String col_label_tlp ="tlp";
    String col_label_pengeluaran ="pengeluaran";
    String col_label_role ="role";
    
    private Connection conn = null;
    private Statement stmt = null;

    public DBSaga_User() {
    }
    
     private void openConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeConnection(){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public String getCreditCard(String username){
        String query = "SELECT CCN from saga_user where username='"+username+"'";
        String result = "";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                result = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public String getUsername(String creditCard){
        String query = "SELECT username from saga_user where CCN='"+creditCard+"'";
        String result = "";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                result = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    // For webservices
    public double getAmount(String username){
        String query = "SELECT pengeluaran from saga_user where username='"+username+"'";
        double result = 0;
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                result = res.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
     // Set amount for users
    private boolean setAmount(String username, String cardNumber, double add){
        double amountNow = getAmount(username) + add;
        String query = "UPDATE saga_user SET pengeluaran=" + amountNow + " WHERE CCN='" + cardNumber + "'";
        int success = 0;
        try {
            success = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success == 1;
    }
    
    public ArrayList<User> getAllUser(){
        String query = "SELECT * from saga_user";
        ArrayList<User> arr = new ArrayList<User>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                User cc = new User(res.getString("username"), res.getString("role"),res.getString("CCN"), res.getString("email"), res.getString("tlp"), res.getString("alamat"), res.getDouble("pengeluaran"));
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<User> getUserDetails(String username){
        String query = String.format("SELECT * from saga_user where username='%s'", username);
        ArrayList<User> arr = new ArrayList<User>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                User cc = new User(res.getString("username"), res.getString("role"),res.getString("CCN"), res.getString("email"), res.getString("tlp"), res.getString("alamat"), res.getDouble("pengeluaran"));
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public User getUserDetail(String username){
        String query=String.format("SELECT * FROM %s WHERE username='%s'",table_name,username);
        User user = new User();
        try{
            openConnection();
            ResultSet res = getStatement().executeQuery(query);
            while(res.next()){
                user.setAlamat(res.getString(col_label_alamat));
                user.setCCN(res.getString(col_label_ccn));
                user.setPassword(res.getString(col_label_password));
                user.setEmail(res.getString(col_label_email));
                user.setPengeluaran(res.getDouble(col_label_pengeluaran));
                user.setTelp(res.getString(col_label_tlp));
                user.setRole(res.getString(col_label_role));
                user.setUsername(res.getString(col_label_username));
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);
        }return user;
    }
    
    public boolean updateProfile(User newUser){
        
        boolean state = false;
        String query = String.format("UPDATE %s SET %s='%s',%s='%s',%s='%s',%s='%s',%s='%s' WHERE username='%s'"
                ,table_name,col_label_alamat,newUser.getAlamat(),col_label_ccn,newUser.getCCN()
                ,col_label_email,newUser.getEmail(),col_label_password,newUser.getPassword()
                ,col_label_tlp,newUser.getTelp(),newUser.getUsername());
        try{
            openConnection();
            getStatement().executeUpdate(query);
            state = true;
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);
        }return state;
    }
    
    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return stmt;
    }
}
