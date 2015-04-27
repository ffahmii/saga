package com.saga;

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
@XmlType(name = "User", propOrder = {"username","password", "role","CCN","email", "telp", "alamat", "pengeluaran"})
public class User {
    @XmlElement(name = "username", required = true)
    String username;
    @XmlElement(name = "password", required = true)
    String password;
    @XmlElement(name = "role", required = true)
    String role;
    @XmlElement(name = "CCN", required = true)
    String CCN;
    @XmlElement(name = "email", required = true)
    String email;
    @XmlElement(name = "telp", required = true)
    String telp;
    @XmlElement(name = "alamat", required = true)
    String alamat;
    @XmlElement(name = "pengeluaran", required = true)
    double pengeluaran; 
    
    public User(){
        
    }
    
    //full argument
    public User(String username,String password, String role, String CCN, String email, String telp, String alamat, double pengeluaran) {
        this.username = username;
        this.password= password;
        this.role = role;
        this.CCN = CCN;
        this.email = email;
        this.telp = telp;
        this.alamat = alamat;
        this.pengeluaran = pengeluaran;
    }

    public User(String username, String role, String CCN, String email, String telp, String alamat, double pengeluaran) {
        this.username = username;
        this.role = role;
        this.CCN = CCN;
        this.email = email;
        this.telp = telp;
        this.alamat = alamat;
        this.pengeluaran = pengeluaran;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCCN() {
        return CCN;
    }

    public void setCCN(String CCN) {
        this.CCN = CCN;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public double getPengeluaran() {
        return pengeluaran;
    }

    public void setPengeluaran(double pengeluaran) {
        this.pengeluaran = pengeluaran;
    }
    
            
}
