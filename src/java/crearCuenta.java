/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */
import java.sql.SQLException;
import javax.faces.bean.ManagedBean;
@ManagedBean
public class crearCuenta {
    
    public String nav(){
        return "index.xhtml";
    }
    
    public String registrarCliente()
    {
        try {
            conexion con = new conexion();
            con.conectar();
            return con.insertarCliente();
        } catch (Exception ex) {
         return "Error.xhtml";   
        }
    }   
}
