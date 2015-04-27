/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saga;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author Hansel
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Client", propOrder = {"gameId","gameName","adminUsername","sale"})
public class Client {
    @XmlElement(name = "gameId", required = true)
    String gameId;
    @XmlElement(name = "gameName", required = true)
    String gameName;
    @XmlElement(name = "adminUsername", required = true)
    String adminUsername;
    @XmlElement(name = "sale", required = true)
    Double sale;

    public Client(String gameId, String gameName, String adminUsername, Double sale) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.adminUsername = adminUsername;
        this.sale = sale;
    }

    public Client(String gameName,Double sale) {
        this.gameName = gameName;
        this.sale = sale;
    }
    
    public Client() {
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }
    
}
