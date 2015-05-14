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
            DBSaga_User x = new DBSaga_User();
            ArrayList<User> arr = x.getAllUser();
            for(User a : arr){
        %>
            <tr>
                <td><%= a.getUsername() %></td>
                <td><%= a.getCCN() %></td>
                <td><%= a.getPengeluaran() %></td>
            </tr>
        <%
            }
        %>
        </table>
        Form Pengecekan kartu kredit
        <form>
            <table>
                <tr>
                    <td>Nomor kartu kredit<td>
                    <td><input type="text" name="number"></td>
                </tr>
                <tr>
                    <td>Jumlah uang<td>
                    <td><input type="text" name="amount"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Cari"></td>
                </tr>
            </table>
        </form>
        <%
            String card = request.getParameter("number");
            double amount = 0;
            if (request.getParameter("amount")!=null){
                amount = Double.parseDouble(request.getParameter("amount"));
            }
        if (card != null){
            try {
                
            } catch (Exception ex) {
                
            }
        }   
        %>
    </body>
</html>
