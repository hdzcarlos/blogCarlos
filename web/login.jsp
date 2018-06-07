<%-- 
    Document   : login
    Created on : 07-jun-2018, 20:14:46
    Author     : cice
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
        Nombre usuario<br> 
        <input type="text" name="usu" placeholder="Nombre usuario"><br>
        
        Password<br>
        <input type="password" name="pass" placeholder="Contraseña">
        <input type="submit" value="Enviar">
        </form>
    </body>
</html>
