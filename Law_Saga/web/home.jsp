<%-- 
    Document   : Home
    Created on : Apr 24, 2015, 5:48:35 PM
    Author     : Hansel
--%>

<%@page import="com.saga.DBLog"%>
<%@page import="com.saga.DBSaga_User"%>
<%@page import="com.saga.DBSaga_Client"%>
<%@page import="com.saga.BuyerLog"%>
<%@page import="com.saga.User"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="homestyle.css">
        <script src="jquery.min.js"></script>
        <script src="bar.js"></script>
        <title>Home</title>
    </head>
    <body>

        <%
            //allow access only if session exists
            String user = null;
            if (session.getAttribute("sessionUser") == null) {
                response.sendRedirect("login.jsp?status=notLoggedIn");
                return;
            } else {
                user = (String) session.getAttribute("sessionUser");
            }
            String userName = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("cookieUsername")) {
                        userName = cookie.getValue();
                    }
                    if (cookie.getName().equals("JSESSIONID")) {
                        sessionID = cookie.getValue();
                    }
                }
            } else {
                sessionID = session.getId();
            }
            String checker = request.getParameter("status");
            if (checker != null && checker.equals("loggedIn")) {
        %>
        <font color="red">You Already Logged In</font>
    <%
            }
            DBSaga_Client dbClient = new DBSaga_Client();
            DBSaga_User dbUser = new DBSaga_User();
            DBLog dbLog = new DBLog();
            ArrayList<User> u = dbUser.getUserDetails(userName);
            ArrayList<BuyerLog> ul = dbLog.getLogBuyerList(userName);
            User ud = u.get(0);
            ArrayList<String> gameId = dbLog.getGameIdPlayedByBuyer(userName);
            ArrayList<ArrayList<BuyerLog>> daftar = dbLog.getSeparatedLogBuyer(userName);
        %>


        <div class="widget">
            <%--<h1>Welcome,<%=userName%> !</h1> --%>
            <%--Your Session ID=<%=sessionID%></h3> --%>

            <ol class="widget-list" id="History">
                <li>
                    <a class="widget-list-link">

                    </a>
                </li>
            </ol>

            <ol class="widget-list" id="GamePurchases">
                <li>
                    <a id="container" style="width:50%; height:400px;"></a>
                    <a class="widget-list-link">
                        <%
                            double [] sum = new double [gameId.size()];
                            int i = 0;
                            for (ArrayList<BuyerLog> arrLog : daftar) {
////                                out.print("Nama game = " + arrLog.get(0).getGameName());
//                                out.print("<p class='submit'><button>"+d.getGameName(arrLog.get(0).getGameName()+"</button></p>"));
                                out.print("<button class='submit' onClick='$(\"#" + i + "\").slideToggle()'>View details " 
                                        + dbClient.getGameName(arrLog.get(0).getGameName()) + "</button>");
                                out.print("<div hidden id='" + i + "'>");
                                for (BuyerLog usLog : arrLog) {
                                    out.print("<br>Pembelian untuk item = " + usLog.getItemName());
                                    out.print("<br>Waktu pembelian = " + usLog.getTime());
                                    out.print("<br>Jumlah harga = " + usLog.getHarga() + "<br>");
                                    for (int j = 0; j < gameId.size(); j++) {
                                        if (usLog.getGameName().equals(gameId.get(j))) {
                                            sum[j] += usLog.getHarga();
                                        }
                                    }
                                }
                                out.print("</div><br><br>");
                                i++;
                            }
                            String categories = "[";
                            for (int j = 0; j < gameId.size(); j++){
                                if (j == gameId.size() - 1) {
                                    categories += "'" + dbClient.getGameName(gameId.get(j)) + "'";
                                } else {
                                    categories += "'" + dbClient.getGameName(gameId.get(j)) + "',";
                                }
                            }
                            categories += "]";
                            String data = "[";
                            for (int j = 0; j < sum.length; j++){
                                if (j == sum.length-1) {
                                    data +=  sum[j];
                                } else {
                                    data += sum[j] + ",";
                                }
                            }
                            data += "]";
//                            out.print(categories);
//                            out.print(data);
                        %>
                    </a>
                    <script>
                         $(function () {
                            $('#container').highcharts({
                                chart: {
                                    type: 'bar'
                                },
                                title: {
                                    text: 'Details on Game'
                                },
                                xAxis: {
                                    categories: <%= categories%>
                                },
                                yAxis: {
                                    title: {
                                        text: 'Pengeluaran'
                                    }
                                },
                                series: [{
                                        name: '<%= ud.getUsername()%>',
                                        data: <%= data %>
                                    }]
                            });
                        });
                    </script>
                </li>
            </ol>

        
            <ol class="widget-list" id="akun">
                <li>
                    <a class="widget-list-link">
                        <span>Username = <%= ud.getUsername()%></span>
                        <span>Credit card number = <%= ud.getCCN()%></span>
                        <span>Role = <%= ud.getRole()%></span>
                        <span>Email = <%= ud.getEmail()%></span>
                        <span>Telepon = <%= ud.getTelp()%></span>
                        <span>Email = <%= ud.getEmail()%></span>
                        <span>Alamat = <%= ud.getAlamat()%></span>
                    </a>
                </li>
            </ol>
            <ul class="widget-tabs">
                <li class="widget-tab">
                    <a href="#History" class="widget-tab-link">History</a>
                <li class="widget-tab">
                    <a href="#GamePurchases" class="widget-tab-link">Game Purchases</a>
              
                <li class="widget-tab">
                    <a href="#akun" class="widget-tab-link">Account Details </a>
            </ul>
      
            <CENTER><form action="<%=response.encodeURL("editProfile.jsp")%>" method="post">
                    <p class="submit" ><input type="submit" name="EditProfile" value="Edit Profile"></p>
                </form>
            </CENTER>
            <CENTER> <form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
                    <p class="submit"><input type="submit" name="LogoutButton" value="Log Out"></p>
                </form>
            </CENTER>

        </div>

    </body>
</html>
