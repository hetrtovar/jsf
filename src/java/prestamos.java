/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author desa
 */
@ManagedBean(name = "prestamos")
@SessionScoped
public class prestamos implements Serializable{
    private ArrayList<prestamo> prestamos;
    private ArrayList<SelectItem> pedir;
    private String prestamo;
    private int id;
    private int idPelicula;

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }
    public ArrayList<SelectItem> getPedir() {
        return pedir;
    }
    public void setPedir(ArrayList<SelectItem> pedir) {
        this.pedir = pedir;
    }
    
      public ArrayList<prestamo> getPrestamos(){
          return prestamos;
      }
      
      private void llenarLista(){
        
          conexion con = new conexion();
          prestamos = con.prestamos();
      }
      
      private void setPrestamos(ArrayList<prestamo> pres){
          this.prestamos = pres;
      }
      
      public String getPrestamo(){
          return prestamo;
      }
      
      public void setPrestamo(String prestamo){
          this.prestamo = prestamo;
      }
      
      public int getId(){
          return id;
      }
      
      public void setId(int id){
        this.id = id;
      }
      
      public prestamos(){
          llenarLista();
          llenarList();
      }
      
      
      public void llenarList()
      {
          pedir = new ArrayList();
          conexion conn = new conexion();
          ArrayList p = conn.listaSelectAltasPEliculas();
          for(int i=0; i < p.size() ; i++)
          {
             pelicula pel =(pelicula) p.get(i);
             SelectItem item =  new SelectItem(pel.getIdpelicula(),pel.getTitulo()+" "+pel.getGenero());
             pedir.add(item);
          }
      }
      
      
      public void pedirPrestamo()
      {
       conexion con = new conexion();
       con.pedirPrestamo(idPelicula);
       llenarLista();   
      }
      
     
      
}
