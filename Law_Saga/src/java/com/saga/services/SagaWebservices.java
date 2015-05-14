/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.saga.services;

import com.saga.DBSaga_Client;
import com.saga.DBSaga_User;
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
    public boolean charge(@WebParam(name = "gameId") String gameId, @WebParam(name = "username") String username, @WebParam(name = "amount") double amount) {
        DBSaga_Client db = new DBSaga_Client();
        return db.chargeCard(gameId, username, amount);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAmount")
    public Double getAmount(@WebParam(name = "username") String username) {
        DBSaga_User db = new DBSaga_User();
        return db.getAmount(username);
    }
    
}
