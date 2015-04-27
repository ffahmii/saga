/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.saga.handler;

import com.saga.Database;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
            
            Database db = new Database();

		// get request parameters for userID and password
		String user = request.getParameter("username");
		String pwd = request.getParameter("password");
		
		if(db.isUserValid(user, pwd)){
			HttpSession session = request.getSession();
			session.setAttribute("sessionUser", user);
			//setting session to expiry in 30 mins
			session.setMaxInactiveInterval(30*60);
			Cookie userName = new Cookie("cookieUsername", user);
			response.addCookie(userName);
			if(db.getRole(user).equals("admin")){
                            session.setAttribute("sessionUserRole", "admin");
                            String encodedURL2 = response.encodeURL("gameAdminHome.jsp");
                            response.sendRedirect(encodedURL2);
                            return;
                        }
                        
                        //Get the encoded URL string
			String encodedURL = response.encodeRedirectURL("home.jsp");
			response.sendRedirect(encodedURL);
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
    }
}
