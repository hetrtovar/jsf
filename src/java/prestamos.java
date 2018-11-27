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

/**
 *
 * @author desa
 */
@ManagedBean(name = "prestamos")
@SessionScoped
public class prestamos implements Serializable{
    private ArrayList<prestamo> prestamos;
    private String prestamo;
    private int id;
    
      public ArrayList<prestamo> getPrestamos(){
          return prestamos;
      }
      
      private void llenarLista(){
          conexion con = new conexion();
          prestamos = con.prestamos();
          System.out.println(prestamos.size()+"");
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
      }
}
