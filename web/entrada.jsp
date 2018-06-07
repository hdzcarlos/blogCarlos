<%-- 
    Document   : entrada
    Created on : 05-jun-2018, 23:25:30
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Entradas de nuestro blog</h1>
        <form action="CrearEntrada" method="POST">
            Titulo<br>
            <input type="text" name="titulo" placeholder="Título"><br>
            Subtitulo<br>
            <input type="text" name="subtitulo" placeholder="Subtitulo"<br>                
            Entrada<br>
            <textarea name="ecuerpo" rows="10" cols="100" placeholder="Escriba su noticia ">  </textarea><br>
            Comentario<br>
            <%@include file="comentario.jsp" %><br>
            <input type="submit" value="Enviar">
        </form>
    </body>
</html>
