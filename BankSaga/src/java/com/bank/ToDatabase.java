package com.bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Fahmi
 */
public class ToDatabase {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/bank";
    static final String USER = "root";
    static final String PASS = "";
    private Connection conn = null;
    private Statement stmt = null;
    
    private void openConnection(){
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void closeConnection(){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public ArrayList<CreditCard> getAllCreditCard(){
        String query = "SELECT * from kredit_card";
        ArrayList<CreditCard> arr = new ArrayList<CreditCard>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                CreditCard cc = new CreditCard(res.getString("cardNumber"), res.getBoolean("Status"),res.getDouble("Amount"), res.getString("Grade"));
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    public boolean isValid (String card){
        return card.length()==16;
    }
    
    public boolean isExist(String card){
        boolean exist = false;
        String query = "SELECT COUNT(*) from kredit_card where cardNumber='"+card+"'";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                exist = res.getInt(1) == 1 ? true : false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return exist;
    }
    
    public String isActive(String card){
        String active = "";
        String query = "SELECT status from kredit_card where cardNumber='"+card+"'";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                active = res.getBoolean("status") ? "Ya" : "Tidak";
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return active;
    }
    
    public double getLimit(String card){
        double limit = 0;
        String query = "SELECT `limit` from card_grade where grade='"+getGrade(card)+"'";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                limit = res.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return limit;
    }
    public String getGrade(String card){
        String grade = "";
        String query = "SELECT grade from kredit_card where cardNumber='"+card+"'";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                grade = res.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grade;
    }
    
    public double getAmount(String card){
        double amount = 0;
        String query = "SELECT amount from kredit_card where cardNumber='"+card+"'";
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                amount = res.getDouble(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
    
    public int charge(String cardNumber, double amount){
        if (amount < 0){
            return -1;
        }
        double amountNow = amount+getAmount(cardNumber);
        double limit = getLimit(cardNumber);
        if (amountNow > limit){
            return -2;
        }
        String query = "UPDATE kredit_card SET amount=" + amountNow + " WHERE cardNumber='" + cardNumber + "'";
        int success = 0;
        try {
            success = stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ToDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
}
