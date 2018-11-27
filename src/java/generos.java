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
 * @author hugo
 */

@ManagedBean(name="generos")
@SessionScoped
public class generos implements Serializable{
private ArrayList<genero> generos;
private String gene;
private int id;

    public ArrayList<genero> getGeneros() { 
        return generos;
    }
    
    private void llenarlist()
    {
        conexion con = new conexion();
        generos = con.generos();
        System.out.println(generos.size()+"");
      
    }
    

    public void setGeneros(ArrayList<genero> gen) {
        this.generos = gen;
    }

    

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
/**
     * Creates a new instance of generos
     */
    public generos() {
        llenarlist();
    }
    
    public void agregarGenero()
    {
        genero ng = new genero();
        ng.setGenero(gene);
        conexion con = new conexion();
        con.insertarGenero(ng);
        generos.clear();
        setGene(null);
        llenarlist();
    }
    
}
