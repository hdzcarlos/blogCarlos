
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

/**
 *
 * @author carlos
 */
@WebServlet (name = "CrearEntrada",urlPatterns = {"/CrearEntrada"} )
public class CrearEntrada extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         try {
        String titulo = req.getParameter("titulo");
        String subtitulo = req.getParameter("subtitulo");
        String cuerpo = req.getParameter("cuerpo");
        
       Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/carlos","root","root");
            PreparedStatement statement = con.prepareStatement("INSERT INTO entradas (titulo, subtitulo, cuerpo, usuarios_idusuarios) VALUES (?,?,?,?)");
            statement.setString(1, titulo);
            statement.setString(2, subtitulo);
            statement.setString(3, cuerpo);
            statement.setInt(4, 1);
            statement.execute();
            statement.close();
            con.close();
            resp.getWriter().print("OK");
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CrearEntrada.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CrearEntrada.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
}

