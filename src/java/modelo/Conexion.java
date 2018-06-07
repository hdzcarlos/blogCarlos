/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlos
 */
public class Conexion {
    private Connection jdbcConnection;
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    
    public Conexion(){
        this.jdbcURL = "jdbc:mysql://localhost:8889/carlos";
        this.jdbcUsername = "root";
        this.jdbcPassword = "root";
    }
    public Conexion(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    public boolean conectar() throws SQLException{
        boolean esConectado = false;
        if(jdbcConnection == null || jdbcConnection.isClosed()){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                 jdbcConnection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
                 if(jdbcConnection !=null){
                     esConectado = true;
                 }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        return esConectado;
        
    }
    public void desconectar() throws SQLException{
        if(jdbcConnection != null && !jdbcConnection.isClosed()){
            jdbcConnection.close();
        }
    }
    
    public void insertarSQL(String sql) throws SQLException{
    if(conectar()){
        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.executeUpdate();
        ps.close();
    }
    desconectar();
    }
      public void updateSQL(String sql) throws SQLException{
    if(conectar()){
        PreparedStatement ps = jdbcConnection.prepareStatement(sql);
        ps.execute();
        ps.close();
    }
    desconectar();
    
      }
      
      public Usuario loginSQL(String sql) throws SQLException{
          Usuario usuario = null;
          
          if(conectar()){
              PreparedStatement ps = jdbcConnection.prepareStatement(sql);
              ResultSet rs = ps.executeQuery();
              
              if(rs.first()){
                  usuario = new Usuario();
                  usuario.setId(rs.getString(1));
                  usuario.setUsername(rs.getString(2));
                  usuario.setPassword(rs.getString(3));
                  usuario.setEmail(rs.getString(4));
                  usuario.setNombre(rs.getString(5));
                  usuario.setApellido(rs.getString(6));
                 rs.close();
                 ps.close();
              }
              
          }
          desconectar();
          
          return usuario;
      }
      
    /*public Connection getJdbcConnection(){
        return jdbcConnection;
    }*/
}
