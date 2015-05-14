<%-- 
    Document   : listAllClient
    Created on : Apr 26, 2015, 6:15:12 PM
    Author     : Hansel
--%>

<%@page import="com.saga.DBSaga_Client"%>
<%@page import="com.saga.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="tablestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Client Page</title>
    </head>
    <body>
       
        <table class="table-fill">
            <%
                if (session.getAttribute("sessionUser") == null) {
                    response.sendRedirect("login.jsp?status=notLoggedIn");
                    return;
                }
                DBSaga_Client db = new DBSaga_Client();
                int rank = 1;
                ArrayList<Client> sortedClient = db.getSortedClientBySale();
            %>
            <tbody class="table-hover">
                <tr>
                    <th class="text-left">Rank</th>
                    <th class="text-left">Game</th>
                    <th class="text-left">Sale</th>
                </tr>
            </tbody>
            <%--<tr><td>Rank</td><td>Game</td><td>Sale</td></tr> --%>
            <%
                for (Client client : sortedClient) {
            %>
            <tbody class="table-hover">
                <tr>
                    <td class="text-left"><%=rank++%></td>
                    <td class="text-left"><%=client.getGameName()%></td>
                    <td class="text-left"><%=client.getSale()%></td>
                </tr>

            </tbody>
            <%--
                <tr>
                    <td><%=rank++%></td>
                    <td><%=client.getGameName()%></td>
                    <td><%=client.getSale()%></td>
                </tr>
            --%>
            <%
                }
            %>
        </table>
    </body>
</html>
