/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saga.handler;

<<<<<<< HEAD
=======

>>>>>>> origin/master
import com.saga.DBSaga_User;
import com.saga.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Hansel
 */
@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet{
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	DBSaga_User db = new DBSaga_User();
        User newUser = new User();
        newUser.setUsername(request.getParameter("username"));
        newUser.setAlamat(request.getParameter("alamat"));
        newUser.setCCN(request.getParameter("CCN"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setTelp(request.getParameter("tlp"));

        if(db.updateProfile(newUser)){
            response.sendRedirect("editProfile.jsp?status=success");    
        }else{
            response.sendRedirect("editProfile.jsp?status=fail");
        }return;
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
