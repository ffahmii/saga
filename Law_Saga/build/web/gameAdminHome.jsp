<%-- 
    Document   : gameAdminHome
    Created on : Apr 25, 2015, 5:11:06 PM
    Author     : Hansel
--%>

<%@page import="com.saga.DBSaga_User"%>
<%@page import="com.saga.DBLog"%>
<%@page import="com.saga.DBSaga_Client"%>
<%@page import="com.saga.Client"%>
<%@page import="com.saga.ClientLog"%>
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
        <title>Admin Home</title>
    </head>
    <body>
        <%
            //allow access only if session exists
            String user = null;
            if (session.getAttribute("sessionUser") == null) {
                response.sendRedirect("login.jsp?status=notLoggedIn");
                return;
            } else if(session.getAttribute("sessionUserRole")==null 
                    ||!session.getAttribute("sessionUserRole").equals("admin")){
                response.sendRedirect("unauthorized.jsp");
                return;
            }else
            {
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
            ArrayList<Client> c = dbClient.getClientDetails("g1");
            ArrayList<ClientLog> cl = dbLog.getLogClientList("g1");
            User ud = u.get(0);
            Client client = c.get(0);
        %>
        <div class="widget">
            <h1>Welcome <%=userName%> !</h1> 
            <%--Your Session ID=<%=sessionID%></h3> --%>

            <ol class="widget-list" id="details">
                <li>
                    <a class="widget-list-link">
                        <%
                            for (ClientLog log : cl) {
                                out.print("<span>Game id = " + log.getGameId() + "</span>");
                                out.print("<span>Log id = " + log.getLogId() + "</span>");
                                out.print("<span>Buyer name = " + log.getUl().getUsername() + "</span>");
                                out.print("<span>Itel sale name = " + log.getUl().getItemName() + "</span>");
                                out.print("<span>Waktu pembelian = " + log.getUl().getTime() + "</span>");
                                out.print("<span>Harga = " + log.getUl().getHarga() + "</span><br>");
                            }
                        %>
                    </a>
                </li>
            </ol>
            <ol class="widget-list" id="akun">
                <li>
                    <a class="widget-list-link">
                        Game details :
                        <span>Idgame = <%= client.getGameId()%></span>
                        <span>Nama game = <%= client.getGameName()%></span>
                        <span>Admin Username = <%= client.getAdminUsername()%></span>
                        <span>Sale game = <%= client.getSale()%></span>
                        <br>
                        Admin details :
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
                    <a href="#details" class="widget-tab-link">Details</a>
                <li class="widget-tab">
                    <a href="#akun" class="widget-tab-link">Akun</a>
            </ul>
            <CENTER><form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
                    <input type="submit" value="Logout" >
                </form></CENTER>
                <%--
                        <header>
                            <nav>
                                <ul class="nav">
                                    <li><a href="home.jsp">Akun</a></li>
                                    <li class="dropdown">
                                        <a href="home.jsp">Log</a>

                    </li>
                </ul>
                <right><form action="<%=response.encodeURL("LogoutServlet")%>" method="post">
                        <input type="submit" value="Logout" >
                    </form></right>
            </nav>
        </header>
                --%>
        </div>
    </body>
</html>
