
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
            String query = "select id_user, pass from clientes where username='"+userName+"'";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            if(res.next())
            {
                index.id_user = Integer.valueOf(res.getString("id_user"));
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

public ArrayList<prestamo> prestamos(){
    ArrayList<prestamo> lista = new ArrayList();
    try{
        conectar();
        Statement stm = conexion.createStatement();
        String query = "select id_prestamo pres, nombre cli , titulo pel  , fechasalida pres , fechaentrega from prestamos pres, peliculas pel, clientes cli where pel.id_pelicula = pres.id_pelicula and cli.id_user=pres.id_cliente";
        ResultSet res = stm.executeQuery(query);
        while(res.next()){
            System.out.println("etre al while");
            prestamo p = new prestamo();
            p.setId(Integer.parseInt(res.getString(1)));
            p.setPelicula(res.getString(3));
            p.setCliente(res.getString(2)); 
            p.setFechaPrestamo(res.getString(4));
            p.setFechaEntrega(res.getString(5));
            lista.add(p);
        }
        System.out.println(lista.size()+"");
        return lista;
    } catch (Exception ex){
        System.out.println(ex.toString());
    }
    return lista;
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


   public ArrayList<pelicula> listaSelectAltasPEliculas()
{
    ArrayList<pelicula> list = new ArrayList();
        try {
            conectar();
            Statement stm = conexion.createStatement();
            String query = "select  id_pelicula p ,titulo p , nombre_gen g from peliculas p, genero g where p.genero =  g.id_genero and existencia>0";
            ResultSet res = stm.executeQuery(query);
            System.out.println(query);
            
            while(res.next())
            {
              pelicula p = new pelicula();
                p.setIdpelicula(Integer.valueOf(res.getString(1)));
                p.setTitulo(res.getString(2));
               p.setGenero(res.getString(3));
               list.add(p);
            }
            return list;
            
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    return list;
    
}
    
public void pedirPrestamo(int pelicula)
{
     try {
         int a= Calendar.YEAR;
         int d= Calendar.DATE;
         int m = Calendar.MONTH + 1;
         String fecha = a+"/"+m+"/"+d;
         fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         
         System.out.println("la fecha es "+fecha    );
            conectar();
            Statement stm = conexion.createStatement();
            String query = "insert into prestamos(id_prestamo,id_cliente,id_pelicula,fechasalida, estatus) values(idprestamo.nextval,"+index.id_user+","+pelicula+ ",to_date('"+fecha+"', 'yyyy/mm/dd'),0)";
            System.out.println(query);
            ResultSet res = stm.executeQuery(query);
            query = "select existencia,f_decremento(existencia) from peliculas where id_pelicula =" +pelicula;
            res = stm.executeQuery(query);
            if(res.next())
                    {
                        int resultado = res.getInt(2);
                        System.out.println("la existencia es "+resultado);
                         query = "update Peliculas set existencia = "+resultado+" where id_pelicula= "+pelicula;
                         res = stm.executeQuery(query);
                    }
            conexion.commit();
        } catch (Exception ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
