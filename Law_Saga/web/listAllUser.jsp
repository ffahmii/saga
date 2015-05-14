<%-- 
    Document   : index
    Created on : Apr 23, 2015, 10:26:11 AM
    Author     : Fahmi
--%>

<%@page import="com.saga.DBSaga_User"%>
<%@page import="com.saga.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Client</title>
    </head>
    <body>
        <%-- <table>
            <tr>
                <td>Nomor Kartu</td>
                <td>Status</td>
                <td>Saldo</td>
            </tr>
            <%
                Database x = new Database();
                ArrayList<User> arr = x.getAllUser();
                for (User a : arr) {
            %>
            <tr>
                <td><%= a.getUsername()%></td>
                <td><%= a.getCCN()%></td>
                <td><%= a.getPengeluaran()%></td>
            </tr>
            <%
                }
            %>
        --%>
        <table class="table-fill">
            <thead>
                <tr>
                    <th class="text-left">Username</th>
                    <th class="text-left">Credit Card</th>
                    <th class="text-left">Saldo</th>
                </tr>
            </thead>
            <%
                DBSaga_User x = new DBSaga_User();
                ArrayList<User> arr = x.getAllUser();
                for (User a : arr) {
            %>
            <tbody class="table-hover">
                <tr>
                    <td class="text-left"><%= a.getUsername()%></td>
                    <td class="text-left"><%= a.getCCN()%></td>
                    <td class="text-left"><%= a.getPengeluaran()%></td>
                </tr>

            </tbody>
            <%
                }
            %>

        </table>
        
    <CENTER><form>
            <table>
                <tr>
                    <td>Nomor kartu kredit : 
                    <input type="text" name="number">
               
                    Jumlah uang :
                    <input type="text" name="amount">
                    <input type="submit" value="Cari">
                    </td>
                    
                </tr>                               
            </table>
        </form></CENTER>
        <%--
            String card = request.getParameter("number");
            double amount = 0;
            if (request.getParameter("amount")!=null){
                amount = Double.parseDouble(request.getParameter("amount"));
            }
        if (card != null){
            try {
                com.bank.services.NewWebService_Service service = new com.bank.services.NewWebService_Service();
                com.bank.services.NewWebService port = service.getNewWebServicePort();
                java.lang.String cardNumber = card;
                java.lang.Boolean result = port.isExists(cardNumber);
                java.lang.Integer hasil = port.charge(card, amount);
                out.println(hasil);
                response.sendRedirect("index.jsp");
            } catch (Exception ex) {
                
            }
        }   
        --%>
    </body>
</html>
