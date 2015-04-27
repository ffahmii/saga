package com.saga.handler;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.saga.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Hansel
 */
@WebServlet(urlPatterns = {"/RegisterHandler"})
public class RegisterHandler extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Database db = new Database();
        if(db.addNewUser(request.getParameter("username"), request.getParameter("password"), request.getParameter("ccn")
                ,request.getParameter("email"),request.getParameter("tlp"), request.getParameter("alamat"))){
            response.sendRedirect("login.jsp");
            return;    
        }
        
        response.sendRedirect("registerRedirect.jsp");
        return;
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    

}
