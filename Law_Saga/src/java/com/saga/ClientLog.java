/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saga;

/**
 *
 * @author Fahmi
 */
public class ClientLog {
    String gameId;
    int logId;
    BuyerLog ul;

    public ClientLog() {
    }

    public ClientLog(String gameId, int logId, BuyerLog ul) {
        this.gameId = gameId;
        this.logId = logId;
        this.ul = ul;
    }

    public String getGameId() {
        return gameId;
    }

    public int getLogId() {
        return logId;
    }

    public BuyerLog getUl() {
        return ul;
    }
    
    
}
