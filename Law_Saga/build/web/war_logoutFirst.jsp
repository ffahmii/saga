<%-- 
    Document   : war_logoutFirst
    Created on : Apr 27, 2015, 12:11:20 PM
    Author     : Hansel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>You are already login</h1>
        <h3>Please Log out First to register a new Account</h3>
        <CENTER> <form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
                    <p class="submit"><input type="submit" name="LogoutButton" value="Log Out"></p>
                </form>
            </CENTER>
    </body>
</html>
