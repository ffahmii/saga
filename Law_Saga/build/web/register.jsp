<%-- 
    Document   : index
    Created on : Apr 23, 2015, 10:26:11 AM
    Author     : Fahmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="registerstyle.css">
        <title>Register SAGA</title>
    </head>
    <%
if (session.getAttribute("sessionUser") != null) {
                response.sendRedirect("war_logoutFirst.jsp");
                return;
            }
%>
    <body>
        <form class="checkout" action="RegisterHandler" method="post">
            <div class="checkout-header">
                <CENTER><h1 class="checkout-title"> Form Registrasi SAGA </h1></CENTER>
            </div>
            <p>
                <input required type="text" class="checkout-input checkout-name" name="username" placeholder="Username" autofocus>
            </p>
            <p>
                <input required type="text" class="checkout-input checkout-name" name="password" placeholder="Password" autofocus>
            </p>
            <p>
                <input type="text" class="checkout-input checkout-card" name="CCN" placeholder="Your Credit Card Number">
            </p>
            <p>
                <input required type="text" class="checkout-input checkout-name" name="email" placeholder="e-mail">
            </p>
            <p>
                <input required type="text" class="checkout-input checkout-name" name="tlp" placeholder="telephone number">
            </p>
            <p>
                <input required type="text" class="checkout-input checkout-name" name="alamat" placeholder="address">
            </p>
            <p>
                <input type="submit" value="Register" class="checkout-btn" name="RegisterButton">
            </p>
        </form>
    </body>
</html>
