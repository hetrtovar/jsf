/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 * @author hugo
 */
@ManagedBean
@SessionScoped
public class crearCuenta {
      public String userName ,nombre ,ap,am ,dir ,num, pass, confirpass;
    private Cliente cliente;
    private conexion con;

    public String getConfirpass() {
        return confirpass;
    }

    public void setConfirpass(String confirpass) {
        this.confirpass = confirpass;
    }

    
    
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
    
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

   
    public String registrarCliente() 
    {
        if(pass.equals(confirpass))
        {
            cliente = new Cliente();
        cliente.setUserName(userName);
        cliente.setAp(ap);
        cliente.setAm(am);
        cliente.setDir(dir);
        cliente.setNum(num);
        cliente.setNombre(nombre);
        cliente.setPass(pass);
        try {        
            con = new conexion();
            String error =  con.insertarCliente(cliente);
            if(error.isEmpty())
            {
                return "Error.xhtml";
            }
            else
            {
            return error;
            }
        } catch (Exception ex) {
         return "Error.xhtml";   
        }
            
        }
        else
        {
         return "Error.xhtml";      
        }
        
        
        
    }
    
    
    public String nav(){
        return "index.xhtml";
    }
       
    
}
