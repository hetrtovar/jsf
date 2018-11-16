
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */
public class conexion {  
    
    Connection conexion;

public conexion() {
    conexion = null;
}

public String conectar() throws ClassNotFoundException, SQLException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Hugo", "proyecto", "proyecto");
    if (conexion != null) {
        return "Conectado";
    } else {
        return "Sin conexion";
    }
  }
    
public String insertarCliente(Cliente c)
{
    
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "insert into clientes values(idcliente.nextval,'"+c.getUserName()+"','"+c.getNombre()+"','"+c.getAp()+"','"+c.getAm()+"','"+c.getDir()+"',"+c.getNum()+")";
            ResultSet res = stm.executeQuery(query);
                conexion.commit();
                return "index.xhtml";
            
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
}

}
