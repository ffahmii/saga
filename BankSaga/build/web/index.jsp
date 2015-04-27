<%-- 
    Document   : index
    Created on : Apr 23, 2015, 2:40:00 PM
    Author     : Fahmi
--%>

<%@page import="com.bank.CreditCard"%>
<%@page import="com.bank.ToDatabase"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table>
            <tr>
                <td>Nomor Kartu</td>
                <td>Status</td>
                <td>Saldo</td>
            </tr>
        <%
            ToDatabase x = new ToDatabase();
            ArrayList<CreditCard> arr = x.getAllCreditCard();
            for(CreditCard a : arr){
        %>
            <tr>
                <td><%= a.getNumCard() %></td>
                <td><%= a.isIsActive() ? "Active" : "Suspend" %></td>
                <td><%= a.getAmount() %></td>
            </tr>
        <%
            }
        %>
        </table>
        <form>
            Masukkan nomor kartu = <input type="text" name="no_card">
            Jumlah uang = <input type="text" name="amount">
            <input type="submit" value="Cari">
        </form>
        <%
            if (request.getParameter("no_card") != null){
                if (x.isExist(request.getParameter("no_card"))){
                    out.print("Kartu ditemukan");
                } else {
                    out.print("Kartu tidak ditemukan");
                }
                out.print(x.isActive(request.getParameter("no_card")));
                out.print("<br>");
                out.print(x.getGrade(request.getParameter("no_card")));
                out.print("<br>");
                out.print(x.getLimit(request.getParameter("no_card")));
                out.print("<br>");
                out.print(x.carge(request.getParameter("no_card"), Double.parseDouble(request.getParameter("amount"))));
            }
        %>
    </body>
</html>
