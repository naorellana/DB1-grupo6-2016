/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.controlador;

import java.sql.*; 

/**
 *
 * @author Nery Alexis Orellana
 */
public class oracleSQL { 
private Connection conexion; 
     
public Connection getConexion() { 
    return conexion; 
}    public void setConexion(Connection conexion) { 
    this.conexion = conexion; 
}  



//public funcionalidad conectar() { 
public String conectar() {     
    String t="";
    try { 
        Class.forName("oracle.jdbc.OracleDriver"); 
        String BaseDeDatos = "jdbc:oracle:thin:@localhost:1521:XE"; 
          
        conexion = DriverManager.getConnection(BaseDeDatos, "PRUEBA","PRUEBA");             
        if (conexion != null) { 
            t="Conexion exitosa!";
            System.out.println("Conexion exitosa!"); 
        } else { 
            System.out.println("Conexion fallida!"); 
            t="Error De Conexion"; 
        } 
    } catch (Exception e) { 
        e.printStackTrace(); 
        t=t+e.getMessage() ; 
    //}        return this; 
    }        return t;
} 

public boolean escribir(String sql) { 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            //sentencia.executeUpdate(sql); //linea original
            sentencia.execute(sql);  //linea hecha por mi
            getConexion().commit(); 
            sentencia.close(); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            System.out.print("ERROR SQL"); 
            return false; 
        }         
        return true; 
    } 

public ResultSet consultar(String sql) { 
        ResultSet resultado = null; 
        try { 
            Statement sentencia; 
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql); 
             
        } catch (SQLException e) { 
            e.printStackTrace(); 
            return null; 
        }        return resultado; 
    } 

} 
