<%-- 
    Document   : pasangIklan
    Created on : May 14, 2015, 4:49:01 PM
    Author     : Hansel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Memasang Iklan</h1>
        <form class="checkout" action="PengajuanIklanHandler" method="post">
            <div class="checkout-header">
                <CENTER><h1 class="checkout-title"> Form Pengajuan Iklan SAGA </h1></CENTER>
            </div>
            <p>
                Tipe Iklan
                <select name="tipeIklan">
                    <option value="Gold">Gold</option>
                    <option value="Silver">Silver</option>
                    <option value="Bronze">Bronze</option>
                </select>
            </p>
            <p>
                URL Banner<input required type="text" class="checkout-input checkout-name" name="urlBanner" placeholder="URL banner anda" autofocus>
            </p>
            <p>
                <input type="submit" value="Ajukan Iklan" class="checkout-btn" name="AjukanIklanButton">
            </p>
        </form>
        
    </body>
</html>
