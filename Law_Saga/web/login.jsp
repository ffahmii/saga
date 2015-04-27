<%-- 
    Document   : login
    Created on : Apr 24, 2015, 5:14:54 PM
    Author     : Hansel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Login Form</title>
        <link rel="stylesheet" type="text/css" href="loginstyle.css">
    </head>
    <body>
        <section class="container">
            <div class="login">
                <h1>Form Login SAGA</h1>
                
                <%
                    //check if user already logged in
                    //if it is, redirect to home
                    //if not, show the login page
                    if (session.getAttribute("sessionUser") != null) {
                        if(session.getAttribute("sessionUserRole")!=null&&session.getAttribute("sessionUserRole").equals("admin")){
                            response.sendRedirect("gameAdminHome.jsp?status=loggedIn");
                            return;
                        }else{
                        response.sendRedirect("home.jsp?status=loggedIn");
                        return;
                        }
                    }
                    String checker = request.getParameter("status");
                    if(checker!=null&&checker.equals("notLoggedIn")){
                %>
                <CENTER><font color="red">Please Login First</font></CENTER>
                <%
                    }
                %>
                <form action="LoginServlet" method="post">
                    <p><input type="text" name="username" placeholder="Username"></p>
                    <p><input type="password" name="password" placeholder="Password"></p>
                    <p class="remember_me">
                        <label>
                            <input type="checkbox" name="remember_me" id="remember_me">
                            Remember me on this computer
                        </label>
                    </p>
                    <p class="submit"><input type="submit" name="LoginButton" value="Login"></p>
                </form>
            </div>
            <div class="login-help">
                <a href="register.jsp">Doesn't have SAGA Account? click here to register</a>
            </div>
        </section>
    </body>
</html>
