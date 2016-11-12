/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.clases;

import java.sql.*; 

/**
 *
 * @author Nery Alexis Orellana
 */
public class conexionDB { 
    private Connection conexion; 
    static Statement estado; //estado de la conexion
    static ResultSet  resultado; //resultado de la onexion 
    int cantColumnas;  //cantidad de coulmas 
    int cantFilas;  //cantidad de Filas
    Object [][] registro; // matriz de objetos (valores de los registros de la base de datos)
    ResultSetMetaData resultadoMeDat; //informacion resultante de metadatos
    
    String mensaje="";
    String urlDB="jdbc:oracle:thin:@localhost:1521:XE"; //conexion al local host en el puerto por defecto de oracle en windows
    String claveDB="PRUEBA"; //usuario a la base de datos
    String usuarioDB="PRUEBA"; //usuario de la base de datos (schema de oracle)
    String comandoSQL="";
     
public Connection getConexion() { 
    return conexion; 
}    public void setConexion(Connection conexion) { 
    this.conexion = conexion; 
}  



//public funcionalidad conectar() { 
public String conectar() {     
    try { 
        Class.forName("oracle.jdbc.OracleDriver"); 
        conexion = DriverManager.getConnection(urlDB, usuarioDB,claveDB);             
        if (conexion != null) { 
            mensaje="Conexion exitosa!"; 
        }
    } catch (Exception e) { 
        mensaje="Error De Conexion A La Base De Datos: ";
        mensaje= mensaje+e.getMessage() ; 
    //}        return this; 
    }        return mensaje;
} 

public String escribir(String sql) { 
        try { 
            //Statement sentencia; 
            Class.forName("oracle.jdbc.OracleDriver"); 
            conexion = DriverManager.getConnection(urlDB, usuarioDB,claveDB);             
            if (conexion != null) { 
                //mensaje="Conexion exitosa!"; 
                estado.execute(sql);
                getConexion().commit();
                mensaje="listo";
            }
            //estado.execute(sql);  //linea hecha por mi
            //getConexion().commit(); 
            //estado.close(); 
            //conexion.close();
             
        } catch (Exception e) { 
            mensaje="Error Al Insertar Los Datos: "+ e.getMessage();
        }         
        return mensaje; 
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
