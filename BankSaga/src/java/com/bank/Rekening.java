/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bank;

/**
 *
 * @author Fahmi
 */

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Rekening", propOrder = {"rek_number", "pemilik", "saldo"})
public class Rekening {
    @XmlElement(name = "rek_number", required = true)
    String rek_number;
    @XmlElement(name = "pemilik", required = true)
    String pemilik;
    @XmlElement(name = "saldo", required = true)
    double saldo;

    public Rekening(){
        
    }
    
    public Rekening(String rek_number, String pemilik, double saldo) {
        this.rek_number = rek_number;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    public String getRek_number() {
        return rek_number;
    }

    public String getPemilik() {
        return pemilik;
    }

    public double getSaldo() {
        return saldo;
    }
    
}
