<%-- 
    Document   : editProfile
    Created on : Apr 26, 2015, 1:49:17 PM
    Author     : Hansel
--%>

<%@page import="com.saga.User"%>
<%@page import="com.saga.Database"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <link rel="stylesheet" href="editprofilestyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Profile</title>
    </head>
    <body>
        <form class="contact" action="<%=response.encodeURL("ProfileServlet")%>" method="post" >
            <%
                if (session.getAttribute("sessionUser") == null) {
                    response.sendRedirect("login.jsp?status=notLoggedIn");
                    return;
                }
                Database db = new Database();
                String username = (String) session.getAttribute("sessionUser");
                User user = db.getUserDetail(username);

                if (request.getParameter("status") != null && request.getParameter("status").equals("success")) {
            %>
            <CENTER><font color="red">Profile Saved</font></CENTER>
                <%
                    response.sendRedirect("home.jsp");
                    }
                %>


            <input type="hidden" name="username" value="<%=user.getUsername()%>"/>
            <p class="contact-input">
                Username : <BOLD><%=user.getUsername()%></BOLD>
        </p>
        <p class="contact-input">
            Password : <input type="text" required id="password" name="password" value=<%=user.getPassword()%> autofocus>
        </p>
        <p class="contact-input">
            Email : <input type="text" required id="email" name="email" value=<%=user.getEmail()%> autofocus>
        </p>

        <p class="contact-input">
            Credit Card Number : <input type="text" id="CCN" name="CCN" type="number" value=<%=user.getCCN()%> autofocus>
        </p>
        <p class="contact-input">
            Telephone : <input type="text" id="tlp" name="tlp" required type="number" value=<%=user.getTelp()%> autofocus>
        </p>
        <p class="contact-input">
            Addreses : <textarea id="alamat" name="alamat" required><%=user.getAlamat()%> </textarea>
        </p>

        <p class="contact-submit">
            <input type="submit" value="Save">
        </p>



    </form>   

    <%--<a href="profile.jsp">Back to Profile</a><--%>
</body>
</html>
