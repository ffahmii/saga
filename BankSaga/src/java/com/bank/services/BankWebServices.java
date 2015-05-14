/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.CreditCard;
import com.bank.BankDatabase;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fahmi
 */
@WebService(serviceName = "BankWebServices")
public class BankWebServices {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllCreditCard")
    public List<CreditCard> getAllCreditCard() {
        BankDatabase db = new BankDatabase();
        return db.getAllCreditCard();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isValid")
    public Boolean isValid(@WebParam(name = "cardNumber") String cardNumber) {
        BankDatabase db = new BankDatabase();
        return db.isValid(cardNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isExists")
    public Boolean isExists(@WebParam(name = "cardNumber") String cardNumber) {
        BankDatabase db = new BankDatabase();
        return db.isExist(cardNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "charge")
    public int charge(@WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "amount") double amount) {
        BankDatabase db = new BankDatabase();
        return db.charge(cardNumber, amount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAmount")
    public double getAmount(@WebParam(name = "cardNumber") String cardNumber) {
        BankDatabase db = new BankDatabase();
        return db.getAmount(cardNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deposit")
    public Boolean deposit(@WebParam(name = "rek_number") String rek_number, @WebParam(name = "amount") double amount) {
        BankDatabase db = new BankDatabase();
        return db.deposit(rek_number, amount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "witdraw")
    public Boolean witdraw(@WebParam(name = "rek_number") String rek_number, @WebParam(name = "amount") double amount) {
        BankDatabase db = new BankDatabase();
        return db.witdraw(rek_number, amount);
    }
}
