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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean
public class index {
    public static int userType = -1;
    public static int  id_user = 0;
    private String contraseña, userName;
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
       this.tipo = tipo;
    }
    
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
    public String login()
    {
         String res = "";
         System.out.println(tipo+" tipo");
        if(tipo.equals("1"))
        {
             try {
            conexion con = new conexion();
            res = con.login(userName);
            System.out.println(res);
            if(res.equals(contraseña) )
            {
                userType = 1;
                return "catalogo.xhtml";
            }
            else
            {
                
                return "index.xhtml";
            }
            
        } catch (Exception ex) {
            Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                return "index.xhtml";
        }
            
        }
        else
        {
            return "Error.xhtml";
        }
       
    }
    
    public String btncatalogo()
    {
        userType = 3;
        return "catalogo.xhtml";
     
    }
    
    
    public String linkcrear()
    {
     return "crearCuenta.xhtml";
    }
}
