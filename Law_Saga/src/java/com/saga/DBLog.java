/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saga;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fahmi
 */
public class DBLog {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/law";
    static final String USER = "root";
    static final String PASS = "";
    static final String table_name = "log";
    private Connection conn = null;
    private Statement stmt = null;
    static final String cId = "id";
    static final String cUsername = "username";
    static final String cTime = "time";
    static final String cItem = "item";
    static final String cHarga = "harga";
    static final String cGameId = "game_id";

    public Connection getConnection() {
        return conn;
    }

    public Statement getStatement() {
        return stmt;
    }

    private void openConnection() {
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

    private void closeConnection() {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public boolean addLog(String user, String gameId, String date, String item, double value) {
        String query = String.format("INSERT INTO `"+table_name+"` (`username`, `time`, `item`, `harga`, `game_id`) "
                + "VALUES (%s,'%s','%s',%f,%s)", user, date, item, value, gameId);
        int res = 0;
        try {
            res = getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res == 1;
    }
    
    public ArrayList<BuyerLog> getLogBuyerList(String username){
        String query = "SELECT * from `"+table_name+"` where username='"+username+"'";
        ArrayList<BuyerLog> arr = new ArrayList<BuyerLog>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                BuyerLog cc = new BuyerLog(res.getString(cUsername), res.getInt(cId), 
                        res.getDate(cTime), res.getString(cGameId), res.getString(cItem) , res.getDouble(cHarga)) ;
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
    /*
    Mendapatkan kumpulan id game yang dimainkan seorang user
    */
    public ArrayList<String> getGameIdPlayedByBuyer(String username){
        ArrayList<BuyerLog> total = getLogBuyerList(username);
        ArrayList<String> gameId = new ArrayList<String>();
        for(BuyerLog log : total){
            String idGame = log.getGameName();
            if(!gameId.contains(idGame)){
                gameId.add(idGame);
            }
        }
        return gameId;
    }
    
    /*
    Mendapatkan kumpulan log ditiap game yang dimainkan oleh seorang user
    */
    public ArrayList<ArrayList<BuyerLog>> getSeparatedLogBuyer(String username){
        ArrayList<BuyerLog> total = getLogBuyerList(username);
        ArrayList<String> gameId = getGameIdPlayedByBuyer(username);
        ArrayList<ArrayList<BuyerLog>> result = new ArrayList<ArrayList<BuyerLog>>();
        for (String gameId1 : gameId) {
            result.add(new ArrayList<BuyerLog>());
        }
        for(BuyerLog log : total){
            String idGame = log.getGameName();
            int index = gameId.indexOf(idGame);
            ArrayList<BuyerLog> temp = result.get(index);
            temp.add(log);
            result.set(index, temp);
        }
        return result;
    }
    
    /*
    Mendapatkan sebuah objek user log
    */
    public ArrayList<ClientLog> getLogClientList(String gameId){
        String query = "SELECT * from `"+table_name+"` where game_id='"+gameId+"'";
        ArrayList<ClientLog> arr = new ArrayList<ClientLog>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                BuyerLog cc = new BuyerLog(res.getString(cUsername), res.getInt(cId), res.getDate(cTime), gameId, res.getString(cItem), res.getDouble(cHarga));
                ClientLog cl = new ClientLog(res.getString("game_id"), res.getInt("client_log_id"), cc);
                arr.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

}
