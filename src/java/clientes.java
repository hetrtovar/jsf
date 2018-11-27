/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author hugo
 */
@Named(value = "clientes")
@Dependent
public class clientes {
    private ArrayList<Cliente> listClientes;
     private Cliente cc;
     private String userName ,nombre ,ap,am ,dir ,num, pass;

    public ArrayList<Cliente> getListClientes() {
        return listClientes;
    }

    public void setListClientes(ArrayList<Cliente> listClientes) {
        this.listClientes = listClientes;
    }
     
     

    public Cliente getCc() {
        return cc;
    }

    public void setCc(Cliente cc) {
        this.cc = cc;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    /**
     * Creates a new instance of clientes
     */
    public clientes() {
        llenarLista();
    }
    
    
    public void llenarLista()
    {
        conexion con = new conexion();
        listClientes = con.listaClientes();
        
    }
    
}
