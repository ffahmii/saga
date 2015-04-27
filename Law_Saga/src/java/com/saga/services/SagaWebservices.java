/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saga.services;

import com.saga.Database;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Fahmi
 */
@WebService(serviceName = "SagaWebservices")
public class SagaWebservices {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "charge")
    public boolean charge(@WebParam(name = "gameId") String gameId, @WebParam(name = "cardNumber") String cardNumber, @WebParam(name = "amount") double amount) {
        Database db = new Database();
        return db.chargeCard(gameId, cardNumber, amount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAmount")
    public Double getAmount(@WebParam(name = "username") String username) {
        Database db = new Database();
        return db.getAmount(username);
    }
    
}
