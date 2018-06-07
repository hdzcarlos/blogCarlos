/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.Conexion;
/**
 *
 * @author carlos
 */
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {
    Conexion con;
    Connection connection;
    Usuario usu;
   
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String nombreUsuario = req.getParameter("usuario");
            String pass = req.getParameter("pass");
            String nombre = req.getParameter("nombre");
            String apellido = req.getParameter("apellido");
            String email = req.getParameter("email");
            
           
        
                // esto no funciona  Conexion con = new Conexion("jdbc:mysql://localhost:8889/carlosblog","root", "root");
               Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/carlos","root","root");
                
      
           
          //  String sql = "INSERT INTO usuarios (username, password, email, name, surname) VALUES (?,?,?,?,?)";
           // connection = con.getJdbcConnection();
           //con.conectar();
          // connection = con.getJdbcConnection();
           
            PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios (username, password, email, name, surname) VALUES (?,?,?,?,?)");
            statement.setString(1, nombreUsuario);
            statement.setString(2, pass);
            statement.setString(3, nombre);
            statement.setString(4, apellido);
            statement.setString(5, email);
            statement.execute();
            statement.close();
            connection.close();
            resp.getWriter().println("ok");
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuariosServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }  
    }

