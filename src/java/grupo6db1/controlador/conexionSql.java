/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.controlador;

/**
 *
 * @author Nery Alexis Orellana
 */
import java.sql.*;
public class conexionSql {
    static Connection conexion;
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
    
    
    public String conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver"); // define el driver al usarlo en jsp
            conexion= DriverManager.getConnection(urlDB,usuarioDB,claveDB);
            estado= conexion.createStatement();
            mensaje="Conexion Exitosa";
            
        }
        catch(Exception e){
            mensaje="No Se Ha Podido Establecer Una Conexion A La Base De Datos" + e;
        }
        return mensaje;
    }
    
    public Object[] consultarDB(String nombreTabla, Object[] registro ){
        registro=new Object[cantColumnas];
        try{
            conectar();
            resultado=estado.executeQuery("Select count(*) from "+nombreTabla); //inicio, conteo de registros en la tabla
            if (resultado.next()){
                cantFilas=resultado.getInt("count(*)");
            }
            else{
                cantFilas=0;
            } //finaliza el conteo de registros de la tabla
            
            resultado=estado.executeQuery("Select * From "+nombreTabla); //inicio, obtenemos los registros de la tabla
            resultadoMeDat=resultado.getMetaData();
            cantColumnas=resultadoMeDat.getColumnCount();
            
            registro=new Object[cantColumnas]; //creando un objeto con los registros
            while (resultado.next()){
                for(int i=0; i<cantColumnas; i++){
                    registro[i]=resultado.getObject(i+1);  //obtiene el registro en la posicion i del ciclo
                }
                mensaje= registro[1].toString()+ registro[0];
                
            }
            /*
            System.out.println(mensaje);
            
            */
        }
        catch(Exception e){
            mensaje="Error Al Consultar La Base De Datos";
        }
        System.out.println(mensaje);
        return registro;
        
    }
    
    
    public Object [][] consultarDB1(String nombreTabla){
        try{
            conectar();
            resultado=estado.executeQuery("Select count(*) from "+nombreTabla); //inicio, conteo de registros en la tabla
            if (resultado.next()){
                cantFilas=resultado.getInt("count(*)");
            }
            else{
                cantFilas=0;
            } //finaliza el conteo de registros de la tabla
            
            resultado=estado.executeQuery("Select * From "+nombreTabla); //inicio, obtenemos los registros de la tabla
            resultadoMeDat=resultado.getMetaData();
            cantColumnas=resultadoMeDat.getColumnCount(); //se btiene el valor numerico del total de columnas
            registro=new Object[cantFilas][cantColumnas]; //creando matriz con los registros
            int n=0; // variabla uxiliar para la posiion de las filas y columnas
            while (resultado.next()){
                for(int i=0; i<cantColumnas; i++){
                    registro[n][i]=resultado.getObject(i+1);  //obtiene el registro en la posicion i del ciclo
                }
                n++; 
            }
            
        }
        catch(Exception e){
            mensaje="Error Al Consultar La Base De Datos"+ e;
        }        
        return registro; // retorna un objeto con los datos y al llamarlo desde otra clase un bbjeto sera = conexionSql.consultarDB1
        
    }
  
    
    public void imprimirObjeto(){
        //String [][] ma= new String [3][2];
            for (int i=0; i<cantFilas; i++){
                for(int j=0; j<cantColumnas; j++){
                    //registro[i][j]="p";
                    System.out.println(registro[i][j]);
                }
                System.out.println("\n");
            }
    }
    public String [][] text(){
        //this.mat[cantFilas][cantFilas]=mat[cantFilas][cantColumnas];
        String [][]mat =new String[cantFilas][cantColumnas];
        //String [][] ma= new String [3][2];
            for (int i=0; i<cantFilas; i++){
                for(int j=0; j<cantColumnas; j++){
                    //registro[i][j]="p";
                    mat[i][j]="";
                    System.out.println(registro[i][j]);
                    mat[i][j]=registro[i][j].toString();
                }
                System.out.println("\n");
            }
            return mat;
    }
    public String datosCOnsulta(){
        String [][]matr =new String[cantFilas][cantColumnas];
        String p="|";
        for (int i=0; i<cantFilas; i++){
                for(int j=0; j<cantColumnas; j++){
                    //registro[i][j]="p";
                    matr[i][j]="";
                    //System.out.println(registro[i][j]);
                    p=p+registro[i][j].toString()+" ";
                }
                p=p+(" | ");
            }
        return p;
    }
    
    public void insertarDB(){
        try{
            conectar(); // conextamos medianta la funion conectar
            estado.execute(comandoSQL);  //ejecutamos la sentencia o comando sql
            conexion.close(); //erramos la conexion
        }
        catch(Exception e){
            mensaje="Error Al Ingresar Datos";
        }
        
    }
    
    public void actualizarDB(){
        try{
        }
        catch(Exception e){
            mensaje="";
        }
    }
    
    public void borrarDB(){
        try{
        }
        catch(Exception e){
            mensaje="";
        }
    }
    
    
    
}
