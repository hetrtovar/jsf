/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author hugo
 */
@ManagedBean(name="catalogo")
@SessionScoped
public class catalogo {
private ArrayList<pelicula> list;
private String titulo, genero;
private int existemcia;
 private boolean showPassword =true;     
    public boolean isShowColumnDelete(){ 
     return showPassword; 
    } 

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getExistemcia() {
        return existemcia;
    }

    public void setExistemcia(int existemcia) {
        this.existemcia = existemcia;
    }

   

    public ArrayList<pelicula> getList() {
        return list;
    }

    public void setList(ArrayList<pelicula> list) {
        this.list = list;
    }
    /**
     * Creates a new instance of catalogo
     */
    public catalogo() {
        list =  llenartab();
    }
    
    public ArrayList<pelicula> llenartab()
    {
        conexion con = new conexion();
        return con.lista();      
   }
    
    
    
}
