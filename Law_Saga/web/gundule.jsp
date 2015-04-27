<%-- 
    Document   : gundule
    Created on : Apr 25, 2015, 4:34:32 PM
    Author     : Fahmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

        <link rel="stylesheet" href="gundulestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<% 
    if (session.getAttribute("sessionUser") == null) {
                response.sendRedirect("login.jsp?status=notLoggedIn");
                return;
            }
%>
    <body>

        <form method="GET" action="pembelian" class="contact">
            <center><h1 class="checkout-title">FORM PEMBELIAN</h1></center>
            <fieldset class="contact-inner">
                <p class="contact-input">
                    <input type="text" name="username" placeholder="Username" 
                           value="<%=session.getAttribute("sessionUser") %>" autofocus>
                </p>
                <p class="contact-input">
                    <input type="text" name="amount" placeholder="Amount" autofocus>
                </p>
                <link href="../../../css/43-contact-form/css/style.css" rel="stylesheet" type="text/css"/>
                <p class="contact-input">
                    <input type="text" name="item" placeholder="Item" autofocus>
                </p>
                <p class="contact-input">
                    <input type="text" name="gameId" placeholder="game id" autofocus>
                </p>
                <p><td><input type="hidden" name="date" value='<%= new java.util.Date()%>'></td></p>
                <p class="contact-submit">
                    <input type="submit" value="Beli">
                </p>
            </fieldset>
        </form>
    </body>
</html>
