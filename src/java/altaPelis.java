/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
@ManagedBean(name="altaPelis")
@SessionScoped
public class altaPelis {
private ArrayList<SelectItem> generos;
        private String genero;

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public ArrayList<SelectItem> getGeneros() {
        conexion con = new conexion();
        ArrayList gen = con.generos();
        generos = new ArrayList();
        for(int i = 0 ; i < gen.size() ; i++)
        {
            generos.add(new SelectItem(((genero)gen.get(i)).getId(),((genero)gen.get(i)).getGenero()));
        }
        return generos;
    }
    /**
     * Creates a new instance of altaPelis
     */
    public altaPelis() {
        
    }
    
}
