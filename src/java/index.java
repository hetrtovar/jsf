/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
@ManagedBean
public class index {
    
    public String btncatalogo()
    {
        return "catalogo.xhtml";
     
    }
    
    
    public String linkcrear()
    {
     return "crearCuenta.xhtml";
    }
}
