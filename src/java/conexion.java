
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo
 */
public class conexion {  
    
    Connection conexion;

public conexion() {
    conexion = null;
}

public String conectar() throws ClassNotFoundException, SQLException {
    Class.forName("oracle.jdbc.driver.OracleDriver");
    conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:Hugo", "proyecto", "proyecto");
    if (conexion != null) {
        return "Conectado";
    } else {
        return "Sin conexion";
    }
  }
    
public String insertarCliente(Cliente c)
{
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "insert into clientes values(idcliente.nextval,'"+c.getUserName()+"','"+c.getNombre()+"','"+c.getAp()+"','"+c.getAm()+"','"+c.getDir()+"',"+c.getNum()+",'"+c.getPass()+"')";
            ResultSet res = stm.executeQuery(query);
                conexion.commit();
                return "index.xhtml";
            
        } catch (Exception ex) {
            System.out.println("insert into clientes values(idcliente.nextval,'"+c.getUserName()+"','"+c.getNombre()+"','"+c.getAp()+"','"+c.getAm()+"','"+c.getDir()+"',"+c.getNum()+",'"+c.getPass()+"')");
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
}


public String login(String userName)
{
    String Respuesta = "";
    try {
        
            conectar();
            Statement stm = conexion.createStatement();
            System.out.println("username: "+userName);
            String query = "select pass from clientes where username='"+userName+"'";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            if(res.next())
            {
                Respuesta = res.getString("pass");
            }
            return Respuesta;
                         
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
            return Respuesta;
        }
}


public ArrayList<pelicula> lista()
{
    ArrayList<pelicula> list = new ArrayList();
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "select titulo p, nombre_gen g , existencia p from peliculas p, genero g where genero = id_genero and existencia>0";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            
            while(res.next())
            {
              pelicula p = new pelicula();
                System.out.println("jejeje");
               p.setTitulo(res.getString(1));
               p.setGenero(res.getString(2));
               p.setExistemcia(Integer.parseInt(res.getString(3)));
               list.add(p);
            }
            System.out.println("tam"+list.size());
            return list;
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    
}

public ArrayList<genero> generos()
{
         ArrayList<genero> list = new ArrayList();
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "select * from genero";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            while(res.next())
            {
               genero g = new genero();
               g.setId(Integer.parseInt(res.getString(1)));
               g.setGenero(res.getString(2));
               list.add(g);
            }
            return list;
            
        } catch (Exception ex) {
                System.out.println(ex.toString());
        }
    return list;   
}


public String insertarGenero(genero c)
{
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "insert into genero values(idgenero.nextval,'"+c.getGenero()+"')";
            System.out.println(query);
            ResultSet res = stm.executeQuery(query);
                conexion.commit();
                return "index.xhtml";
            
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
}


    public ArrayList<Cliente> listaClientes()
    {
         ArrayList<Cliente> list = new ArrayList();
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "select * from clientes";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            while(res.next())
            {
               Cliente cc = new Cliente();
               cc.setId(res.getInt(1));
               cc.setUserName(res.getString(2));
               cc.setNombre(res.getString(3));
               cc.setAp(res.getString(4));
               cc.setAm(res.getString(5));
               cc.setDir(res.getString(6));
               cc.setNum(res.getString(7));
               list.add(cc);
            }
            return list;
   
        } catch (Exception ex){
                System.out.println(ex.toString());
        }
    return list;
    }


}
