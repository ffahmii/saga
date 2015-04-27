<%-- 
    Document   : profile
    Created on : Apr 26, 2015, 12:17:28 PM
    Author     : Hansel
--%>

<%@page import="com.saga.User"%>
<%@page import="com.sun.istack.logging.Logger"%>
<%@page import="com.saga.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Profile</h1>
        <%            
            if (session.getAttribute("sessionUser") == null) {
                response.sendRedirect("login.jsp?status=notLoggedIn");
                return;
            }
            Database db = new Database();
            String username = (String) session.getAttribute("sessionUser");
            User user = db.getUserDetail(username);
        %>
        Hello <%=username%> <br>
        role : <%=user.getRole()%><br>
        email : <%=user.getEmail()%><br>
        telephone : <%=user.getTelp()%><br>
        Address :  <%=user.getAlamat()%><br>
        Money Spend : <%=user.getPengeluaran()%> <br>
        
        <a href="editProfile.jsp">Edit Profile</a>
        
    </body>
</html>
