/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.clases;


/**
 *
 * @author Nery Alexis Orellana
 */
public class conexionOracle {
    public static void main(String args[]){
        funcionalidad co= new funcionalidad();
        co.conectar();
        //co.escribir("INSERT INTO  PRUEBA2  (    ID,    USUARIO  )  VALUES  ('PRUEBA1', 'PRUEBA1')");
        co.consultar("Select * From PRUEBA2");
    }
}
