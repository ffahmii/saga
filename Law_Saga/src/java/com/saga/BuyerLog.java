/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saga;

import java.util.Date;

/**
 *
 * @author Fahmi
 */
public class BuyerLog {
    String username;
    int buyerLogId;
    Date time;
    String gameName;
    String itemName;
    double harga;

    public BuyerLog() {
    }

    public BuyerLog(String username, int buyerLogId, Date time, String gameName, String itemName, double harga) {
        this.username = username;
        this.buyerLogId = buyerLogId;
        this.gameName = gameName;
        this.itemName = itemName;
        this.harga = harga;
        this.time = time;
    }

    public String getUsername() {
        return username;
    }

    public int getBuyerLogId() {
        return buyerLogId;
    }

    public Date getTime() {
        return time;
    }

    public String getGameName() {
        return gameName;
    }

    public String getItemName() {
        return itemName;
    }

    public double getHarga() {
        return harga;
    }

    
}
