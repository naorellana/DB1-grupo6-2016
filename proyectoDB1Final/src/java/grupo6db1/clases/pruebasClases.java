/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.clases;

import grupo6db1.modelo.conexionSqlC;

/**
 *
 * @author Nery Alexis Orellana
 */
public class pruebasClases {
    
    public static void main(String args[]){
        funcionalidad co= new funcionalidad();
        //co.conectar();
        //co.escribir("INSERT INTO  PRUEBA2  (    ID,    USUARIO  )  VALUES  ('holas1', 'holas')");
        
        conexionSqlPrueba con= new conexionSqlPrueba();
        String g;
        g=con.conectar();
        System.out.println(g);
        Object [][] o=con.consultarDB1("factura");
        //System.out.println("leyendo objeto en 0,1 " +p[0][1].toString());
        String f=con.datosCOnsulta();
        System.out.println("f " +f);
        //String [][]t=ccc.text();
        //System.out.println("texto "+t[0][0]);
        
        conexionSqlC ccc= new conexionSqlC();
        String t;
        t=ccc.conectar();
        System.out.println(t);
        Object [][] p=ccc.consulta("SELECT cname FROM col WHERE tname = 'FACTURA'");
        //System.out.println("leyendo objeto en 0,1 " +p[0][1].toString());
        String h=ccc.datosCOnsulta();
        System.out.println(ccc.getCantColumnas());
        System.out.println(ccc.getCantFilas());
        System.out.println("pollo " +h);
        for (int i=0; i< ccc.getCantFilas(); i++ ){
            System.out.println("banda" +p[i][0].toString());
        }
        /*
        //System.out.println(p[1].toString());
        int [][] ma= new int [3][2];
        for (int i=0; i<3; i++){
                for(int j=0; j<2; j++){
                    ma[i][j]=i;
                    System.out.println(ma[i][j]);
                }
                System.out.println("\n");
            }*/
        
        
        conexionSqlC cp= new conexionSqlC();
        Object [][] pp=cp.encabezadoTabla("FACTURA");
        String ncolumOracle="SELECT cname FROM col WHERE tname = '";
        conexionSqlC ctc= new conexionSqlC();
        ctc.conectar();
        Object [][] obl=ctc.consulta(ncolumOracle+"FACTURA"+"'");
        System.out.println(ctc.getCantColumnas()+"   "+ cp.getCantFilas());
        for (int i=0; i< ctc.getCantColumnas(); i++ ){
            System.out.println("banda" +obl[0][0].toString());
        }
        
    }
}

