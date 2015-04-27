/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank.services;

import com.bank.CreditCard;
import com.bank.ToDatabase;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fahmi
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllCreditCard")
    public List<CreditCard> getAllCreditCard() {
        ToDatabase db = new ToDatabase();
        return db.getAllCreditCard();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isValid")
    public Boolean isValid(@WebParam(name = "cardNumber") String cardNumber) {
        ToDatabase db = new ToDatabase();
        return db.isValid(cardNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isExists")
    public Boolean isExists(@WebParam(name = "cardNumber") String cardNumber) {
        ToDatabase db = new ToDatabase();
        return db.isExist(cardNumber);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "charge")
    public int charge(@WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "amount") double amount) {
        ToDatabase db = new ToDatabase();
        return db.charge(cardNumber, amount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAmount")
    public double getAmount(@WebParam(name = "cardNumber") String cardNumber) {
        ToDatabase db = new ToDatabase();
        return db.getAmount(cardNumber);
    }
}
