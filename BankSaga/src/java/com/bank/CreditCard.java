package com.bank;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fahmi
 */
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CreditCard", propOrder = {"numCard", "isActive","amount","grade"})
public class CreditCard {
    @XmlElement(name = "numCard", required = true)
    String numCard;
    @XmlElement(name = "isActive", required = true)
    boolean isActive;
    @XmlElement(name = "amount", required = true)
    double amount;
    @XmlElement(name = "grade", required = true)
    String grade;

    public CreditCard(){
        
    }
    public CreditCard(String numCard, boolean isActive, double amount, String grade) {
        this.numCard = numCard;
        this.isActive = isActive;
        this.amount = amount;
        this.grade = grade;
    }

    public String getNumCard() {
        return numCard;
    }

    public void setNumCard(String numCard) {
        this.numCard = numCard;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
