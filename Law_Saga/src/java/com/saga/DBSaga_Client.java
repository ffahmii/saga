/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saga;

import static com.saga.Database.JDBC_DRIVER;
import static com.saga.Database.table_client_name;
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
public class DBSaga_Client {
 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/law";
    static final String USER = "root";
    static final String PASS = "";
    static final String table_name = "saga_client";
    
    private Connection conn = null;
    private Statement stmt = null;   

    public DBSaga_Client() {
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
    
    public String getGameName(String idGame){
        String query = "SELECT game_name from saga_client where game_id='"+idGame+"'";
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
    
    // Game
    public double getAmountForGame(String gameId){
        String query = "SELECT sale from saga_client where game_id='"+gameId+"'";
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
    
    // Set amount for admin Game
    private boolean setAmountForGame(String gameId, double add){
        double amountNow = getAmountForGame(gameId) + add;
        String query = "UPDATE saga_client SET sale=" + amountNow + " WHERE game_id='" + gameId + "'";
        int success = 0;
        try {
            success = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success == 1;
    }
    
    public ArrayList<Client> getClientDetails(String gameId){
        String query = String.format("SELECT * from saga_client where game_id='%s'", gameId);
        ArrayList<Client> arr = new ArrayList<Client>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                Client cc = new Client(res.getString("game_id"), res.getString("game_name"),
                        res.getString("admin_username"), res.getDouble("sale"));
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public ArrayList<Client> getSortedClientBySale(){
        String query=String.format("SELECT game_name,sale FROM %s ORDER BY sale DESC",table_name);
        ArrayList<Client> sortedClient = new ArrayList<Client>();
        try{
            openConnection();
            ResultSet res = getStatement().executeQuery(query);
            while(res.next()){
                Client client = new Client(res.getString("game_name"), res.getDouble("sale"));
                sortedClient.add(client);
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE,null,ex);
        }return sortedClient;
    }
    
     public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return stmt;
    }
}


