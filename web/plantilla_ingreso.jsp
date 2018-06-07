<form action="UsuariosServlet" method="POST">
    Introduzca su usuario<br>
    <input type="text" name="usuario" placeholder="Usuario"><br>
    Itroduzca su contraseña<br>
    <input type="password" name="pass" placeholder="Contraseña"><br>
    Introduzca su nombre<br>
    <input type="text" name="nombre" placeholder="Nombre"><br>
    Introduzca su apellido<br>
    <input type="text" name="apellido" placeholder="Apellido"><br>
    Introduzca su email<br>
    <input type="text" name="email" placeholder="Email"><br>
    Seleccione su edad.<br>
       <select name="edad"><br>
        <%for (int i = 1; i <= 150; i++) {%>
        <option value= "<%=i%>"><%=i%></option><br>
        <%}%>
       </select><br>
   
 
    <input type="submit" value="Enviar">
  


</form>