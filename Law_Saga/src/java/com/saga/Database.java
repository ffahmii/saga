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

public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/law";
    static final String USER = "root";
    static final String PASS = "";
    static final String table_name = "saga_user";
    static final String table_client_name = "saga_client";
    private Connection conn = null;
    private Statement stmt = null;
    String col_label_username ="username";
    String col_label_password ="password";
    String col_label_ccn ="CCN";
    String col_label_alamat ="alamat";
    String col_label_email ="email";
    String col_label_tlp ="tlp";
    String col_label_pengeluaran ="pengeluaran";
    String col_label_role ="role";
    
    public Database(){
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
    
    // For webservices
    public boolean chargeCard(String gameId, String username, double amount){
        String cardNumber = getCreditCard(username);
        int hasil = charge(cardNumber, amount);
        if (hasil == -1 || hasil == -2 || hasil == 0){
            return true;
        } 
        return setAmount(getUsername(cardNumber), cardNumber, amount) && setAmountForGame(gameId, amount);
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

    private static int charge(java.lang.String cardNumber, double amount) {
        com.bank.services.NewWebService_Service service = new com.bank.services.NewWebService_Service();
        com.bank.services.NewWebService port = service.getNewWebServicePort();
        return port.charge(cardNumber, amount);
    }
    
    public boolean addToLogBuyer(String user, String gameId, String date, String item, double value){
        int logId = countLogIdUser(user) + 1;
        String keterangan = gameId+"#"+item;
        String query = String.format("INSERT INTO `buyer_log`(`username`, `buyer_log_id`, `time`, `item`, `harga`) "
                + "VALUES ('%s',%d,'%s','%s',%f)", user, logId, date, keterangan, value);
        int res = 0;
        try {
            res = getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res == 1;
    }
    
    public int countLogIdUser(String username){
        String query = "SELECT * from buyer_log where username='"+username+"'";
        int sum = 0;
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                sum++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
    
    public ArrayList<BuyerLog> getLogBuyerList(String username){
        String query = "SELECT * from buyer_log where username='"+username+"'";
        ArrayList<BuyerLog> arr = new ArrayList<BuyerLog>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                String [] game = res.getString("item").split("#");
                BuyerLog cc = new BuyerLog(res.getString("username"), res.getInt("buyer_log_id"), 
                        res.getDate("time"),game[0], game[1] , res.getDouble("harga")) ;
                arr.add(cc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
    
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
//        return total;
    }
    
    // mendapatkan sebuah objek user log
    public BuyerLog getLogBuyer(String username, int log_id){
        String query = "SELECT * from buyer_log where username='"+username+"' AND buyer_log_id='"+log_id+"'";
        BuyerLog cc = null;
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                String [] game = res.getString("item").split("#");
                cc = new BuyerLog(res.getString("username"), res.getInt("buyer_log_id"), 
                        res.getDate("time"),game[0], game[1] , res.getDouble("harga")) ;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cc;
    }
    
    // menambahkan transaksi ke log game
    public boolean addToLogClient(String gameId, String username){
        int logIdClient = countLogIdClient(gameId) + 1;
        int logIdUser = countLogIdUser(username);
        String query = String.format("INSERT INTO `client_log`(`game_id`, `client_log_id`, `buyer_username`, `buyer_log_id`)"
                + "VALUES ('%s', %d, '%s', %d)", gameId, logIdClient, username, logIdUser);
        int res = 0;
        try {
            res = getStatement().executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res == 1;
    }
    
    // menghitung jumlah log suatu game
    public int countLogIdClient(String gameId){
        String query = "SELECT * from client_log where game_id='"+gameId+"'";
        int sum = 0;
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                sum++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sum;
    }
    
     public ArrayList<ClientLog> getLogClientList(String gameId){
        String query = "SELECT * from client_log where game_id='"+gameId+"'";
        ArrayList<ClientLog> arr = new ArrayList<ClientLog>();
        openConnection();
        try {
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                BuyerLog cc = getLogBuyer(res.getString("buyer_username"), res.getInt("buyer_log_id"));
                ClientLog cl = new ClientLog(res.getString("game_id"), res.getInt("client_log_id"), cc);
                arr.add(cl);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }
     
    public boolean isUserValid(String username,String pass){
        boolean exist = false;
        try{
            openConnection();
            String query = String.format("SELECT COUNT(*) from %s where username='%s' and password='%s'",table_name,username,pass);
            ResultSet res = getStatement().executeQuery(query);
            while(res.next()){
                exist = res.getInt(1) == 1 ? true : false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }closeConnection();
        return exist;
    }

    public boolean addNewUser(String username,String password,String ccn,String email,String tlp,String alamat){
        boolean state = false;
        try{
            openConnection();
            if(isUsernameExist(username)){
                return state;
            }
            String query = String.format("INSERT INTO %s (%s,%s,%s,%s,%s,%s) "
                    + " VALUES('%s','%s','%s','%s','%s','%s')"
                    ,table_name,col_label_username,col_label_password,col_label_ccn
                    ,col_label_email,col_label_tlp,col_label_alamat
                    ,username,password,ccn,email,tlp,alamat);
            getStatement().executeUpdate(query);
            state = true;
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }return state;
    }

    public boolean isUsernameExist(String username){
        boolean exist = true;
        try{
            openConnection();
            String query = String.format("SELECT count(*) FROM %s WHERE username='%s'",table_name, username);
            ResultSet res = getStatement().executeQuery(query);
            while(res.next()){
                exist = res.getInt(1) == 1 ? true : false;
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }return exist;
    }
    
    public String getRole(String username){
        String role="not found";
        try{
            openConnection();
            String query=String.format("SELECT role from %s WHERE username='%s'",table_name,username);
            ResultSet res = getStatement().executeQuery(query);
            while(res.next()){
                role = res.getString(1);
            }
        }catch(SQLException ex){
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }return role;
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
    
    public ArrayList<Client> getSortedClientBySale(){
        String query=String.format("SELECT game_name,sale FROM %s ORDER BY sale DESC",table_client_name);
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
