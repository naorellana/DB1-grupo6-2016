/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.modelo;

/**
 *
 * @author Nery Alexis Orellana
 */
import java.sql.*;
public class conexionSqlC {
    static Connection conexion;
    static Statement estado; //estado de la conexion
    static ResultSet  resultado; //resultado de la onexion 
    private int cantColumnas;  //cantidad de coulmas 
    private int cantFilas;  //cantidad de Filas
    Object [][] registro; // matriz de objetos (valores de los registros de la base de datos)
    ResultSetMetaData resultadoMeDat; //informacion resultante de metadatos
    
    private String mensaje="";
    private String urlDB="jdbc:oracle:thin:@localhost:1521:XE"; //conexion al local host en el puerto por defecto de oracle en windows
    private String claveDB="PRUEBA"; //usuario a la base de datos
    private String usuarioDB="PRUEBA"; //usuario de la base de datos (schema de oracle)
    private String comandoSQL="";
    
    
    public String conectar(){
        try{
            Class.forName("oracle.jdbc.OracleDriver"); // define el driver al usarlo en jsp
            conexion= DriverManager.getConnection(getUrlDB(), getUsuarioDB(), getClaveDB());
            estado= conexion.createStatement();
            setMensaje("Conexion Exitosa");
            
        }
        catch(Exception e){
            setMensaje("No Se Ha Podido Establecer Una Conexion A La Base De Datos" + e);
        }
        return getMensaje();
    }
    
    public Object[] consultarDB(String nombreTabla, Object[] registro ){
        registro=new Object[getCantColumnas()];
        try{
            conectar();
            resultado=estado.executeQuery("Select count(*) from "+nombreTabla); //inicio, conteo de registros en la tabla
            if (resultado.next()){
                setCantFilas(resultado.getInt("count(*)"));
            }
            else{
                setCantFilas(0);
            } //finaliza el conteo de registros de la tabla
            
            resultado=estado.executeQuery("Select * From "+nombreTabla); //inicio, obtenemos los registros de la tabla
            resultadoMeDat=resultado.getMetaData();
            setCantColumnas(resultadoMeDat.getColumnCount());
            
            registro=new Object[getCantColumnas()]; //creando un objeto con los registros
            while (resultado.next()){
                for(int i=0; i<getCantColumnas(); i++){
                    registro[i]=resultado.getObject(i+1);  //obtiene el registro en la posicion i del ciclo
                }
                setMensaje(registro[1].toString()+ registro[0]);
                
            }
            /*
            System.out.println(mensaje);
            
            */
        }
        catch(Exception e){
            setMensaje("Error Al Consultar La Base De Datos");
        }
        System.out.println(getMensaje());
        return registro;
        
    }
    
    
    public Object [][] consultarDB1(String nombreTabla){
        try{
            conectar();
            resultado=estado.executeQuery("Select count(*) from "+nombreTabla); //inicio, conteo de registros en la tabla
            if (resultado.next()){
                setCantFilas(resultado.getInt("count(*)"));
            }
            else{
                setCantFilas(0);
            } //finaliza el conteo de registros de la tabla
            
            resultado=estado.executeQuery("Select * From "+nombreTabla); //inicio, obtenemos los registros de la tabla
            resultadoMeDat=resultado.getMetaData();
            setCantColumnas(resultadoMeDat.getColumnCount()); //se btiene el valor numerico del total de columnas
            registro=new Object[getCantFilas()][getCantColumnas()]; //creando matriz con los registros
            int n=0; // variabla uxiliar para la posiion de las filas y columnas
            while (resultado.next()){
                for(int i=0; i<getCantColumnas(); i++){
                    registro[n][i]=resultado.getObject(i+1);  //obtiene el registro en la posicion i del ciclo
                }
                n++; 
            }
            
        }
        catch(Exception e){
            setMensaje("Error Al Consultar La Base De Datos"+ e);
        }        
        return registro; // retorna un objeto con los datos y al llamarlo desde otra clase un bbjeto sera = conexionSqlC.consultarDB1
        
    }
    
    //CONSULTAS VARIAS 
    public Object [][] consulta(String nombreTabla){
        try{
            conectar();
            resultado=estado.executeQuery("Select count(*) from ("+nombreTabla+")"); //inicio, conteo de registros en la tabla
            if (resultado.next()){
                setCantFilas(resultado.getInt("count(*)"));
            }
            else{
                setCantFilas(0);
            } //finaliza el conteo de registros de la tabla
            
            resultado=estado.executeQuery(nombreTabla); //inicio, obtenemos los registros de la tabla
            resultadoMeDat=resultado.getMetaData();
            setCantColumnas(resultadoMeDat.getColumnCount()); //se btiene el valor numerico del total de columnas
            registro=new Object[getCantFilas()][getCantColumnas()]; //creando matriz con los registros
            int n=0; // variabla uxiliar para la posiion de las filas y columnas
            while (resultado.next()){
                for(int i=0; i<getCantColumnas(); i++){
                    registro[n][i]=resultado.getObject(i+1);  //obtiene el registro en la posicion i del ciclo
                }
                n++; 
            }
            
        }
        catch(Exception e){
            setMensaje("Error Al Consultar La Base De Datos"+ e);
        }        
        return registro; // retorna un objeto con los datos y al llamarlo desde otra clase un bbjeto sera = conexionSqlC.consultarDB1
        
    }
  
    
    
    // consulta encabezado 
    public Object [][] encabezadoTabla(String nombreTabla){
        String ncolumOracle="SELECT cname FROM col WHERE tname = '"+ nombreTabla+"'";
        conexionSqlC conAux= new conexionSqlC();
        Object [][] obj=conAux.consulta(ncolumOracle);
        System.out.println(nombreTabla);
        return obj;
    }     
  
    
    public void imprimirObjeto(){
        //String [][] ma= new String [3][2];
            for (int i=0; i<getCantFilas(); i++){
                for(int j=0; j<getCantColumnas(); j++){
                    //registro[i][j]="p";
                    System.out.println(registro[i][j]);
                }
                System.out.println("\n");
            }
    }
    public String [][] text(){
        //this.mat[cantFilas][cantFilas]=mat[cantFilas][cantColumnas];
        String [][]mat =new String[getCantFilas()][getCantColumnas()];
        //String [][] ma= new String [3][2];
            for (int i=0; i<getCantFilas(); i++){
                for(int j=0; j<getCantColumnas(); j++){
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
        String [][]matr =new String[getCantFilas()][getCantColumnas()];
        String p="|";
        for (int i=0; i<getCantFilas(); i++){
                for(int j=0; j<getCantColumnas(); j++){
                    //registro[i][j]="p";
                    matr[i][j]="";
                    //System.out.println(registro[i][j]);
                    p=p+registro[i][j].toString()+" ";
                }
                p=p+(" | ");
            }
        return p;
    }
    
    public String insertarDB(String comandoSQL){
        this.comandoSQL=comandoSQL;
        try{
            conectar(); // conectamos mediante la funion previa conectar
            estado.executeQuery(comandoSQL);  //ejecutamos la sentencia o comando sql
            conexion.close(); //erramos la conexion
            mensaje="Exito";
        }
        catch(Exception e){
            mensaje="Error Al Ingresar Datos" + e.getMessage();
        }
        return mensaje;
    }
    
    public void actualizarDB(){
        try{
        }
        catch(Exception e){
            setMensaje("");
        }
    }
    
    public void borrarDB(){
        try{
        }
        catch(Exception e){
            setMensaje("");
        }
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the urlDB
     */
    public String getUrlDB() {
        return urlDB;
    }

    /**
     * @param urlDB the urlDB to set
     */
    public void setUrlDB(String urlDB) {
        this.urlDB = urlDB;
    }

    /**
     * @return the claveDB
     */
    public String getClaveDB() {
        return claveDB;
    }

    /**
     * @param claveDB the claveDB to set
     */
    public void setClaveDB(String claveDB) {
        this.claveDB = claveDB;
    }

    /**
     * @return the usuarioDB
     */
    public String getUsuarioDB() {
        return usuarioDB;
    }

    /**
     * @param usuarioDB the usuarioDB to set
     */
    public void setUsuarioDB(String usuarioDB) {
        this.usuarioDB = usuarioDB;
    }

    /**
     * @return the comandoSQL
     */
    public String getComandoSQL() {
        return comandoSQL;
    }

    /**
     * @param comandoSQL the comandoSQL to set
     */
    public void setComandoSQL(String comandoSQL) {
        this.comandoSQL = comandoSQL;
    }

    /**
     * @return the cantColumnas
     */
    public int getCantColumnas() {
        return cantColumnas;
    }

    /**
     * @param cantColumnas the cantColumnas to set
     */
    public void setCantColumnas(int cantColumnas) {
        this.cantColumnas = cantColumnas;
    }

    /**
     * @return the cantFilas
     */
    public int getCantFilas() {
        return cantFilas;
    }

    /**
     * @param cantFilas the cantFilas to set
     */
    public void setCantFilas(int cantFilas) {
        this.cantFilas = cantFilas;
    }
    
    
    
}
