/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Conexion;
import modelo.Usuario;

/**
 *
 * @author cice
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Conexion conexion = new Conexion();
        String usu = req.getParameter("usu");
        String pass = req.getParameter("pass");
         
        try {
            Usuario usuario = conexion.loginSQL("SELECT * FROM usuarios WHERE username='"+usu+"' AND password='"+pass+"'");
            PrintWriter pw = resp.getWriter();
            
            if(usuario != null){
                pw.println("logeado");
                
                Date fecha = new Date();
                String fechaActual = fecha.getYear()+"/"+fecha.getMonth()+"/"+fecha.getDate();
                conexion.updateSQL("UPDATE usuarios SET lastlogin='"+fechaActual+"' WHERE username='"+usu+"'");
                resp.sendRedirect("./entrada.jsp");
                
            }else{
                pw.println("El usuario no existe");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }

  

}
