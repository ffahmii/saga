package com.saga;


//import com.sun.crypto.provider.DESCipher;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fahmi
 */
public class Pembelian {
    String creditCardNumber;
    double amount;

    public Pembelian() {
    }

    public Pembelian(String creditCardNumber, double amount) {
        this.creditCardNumber = creditCardNumber;
        this.amount = amount;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public double getAmount() {
        return amount;
    }
//    
//    DESCipher a = new DESCipher();
    
}
