/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.clases;

import grupo6db1.controlador.conexionSql;

/**
 *
 * @author Nery Alexis Orellana
 */
public class pruebasClases {
    
    public static void main(String args[]){
        funcionalidad co= new funcionalidad();
        //co.conectar();
        //co.escribir("INSERT INTO  PRUEBA2  (    ID,    USUARIO  )  VALUES  ('holas1', 'holas')");
        
        conexionSql con= new conexionSql();
        String g;
        g=con.conectar();
        System.out.println(g);
        Object [][] o=con.consultarDB1("PRUEBA2");
        //System.out.println("leyendo objeto en 0,1 " +o[0][1].toString());
        String f=con.datosCOnsulta();
        System.out.println("f " +f);
        //String [][]t=con.text();
        //System.out.println("texto "+t[0][0]);
        
        /*
        //System.out.println(o[1].toString());
        int [][] ma= new int [3][2];
        for (int i=0; i<3; i++){
                for(int j=0; j<2; j++){
                    ma[i][j]=i;
                    System.out.println(ma[i][j]);
                }
                System.out.println("\n");
            }*/
    }
}

