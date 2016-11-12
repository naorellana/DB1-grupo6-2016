/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oracle.controlador.Formularios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.modelo.oracleConexion;

/**
 *
 * @author Nery Alexis Orellana
 */
public class DetalleEnvio extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            String ID_PAQUETE= request.getParameter("ID_PAQUETE");  //usar esta linea para cada variable (campo)
            String ID_DETALLE_ENVIO= request.getParameter("ID_DETALLE_ENVIO");
            String FECHA_ENVIO= request.getParameter("FECHA_ENVIO");
            String EMBALAJE= request.getParameter("EMBALAJE");
            String PESO_TOTAL= request.getParameter("PESO_TOTAL");
            String VALOR_TRANSPORTE= request.getParameter("VALOR_TRANSPORTE");
            String COSTO_ESTIMADO= request.getParameter("COSTO_ESTIMADO");
            String REFERENCIA= request.getParameter("REFERENCIA");
            
            String btnEjecutar= request.getParameter("comando");
            String valida="1";  //VALIDA LA OPCION QUE SE EJECUTO PARA PASAR PARAMETROS A SERVLET Y FORMULARIO JSP
            
            oracleConexion cnOracle=new oracleConexion();
            String sql="";
            switch (btnEjecutar){
                case "Guardar":
                    valida="1";
                    sql="INSERT INTO DETALLE_ENVIO ( ID_PAQUETE, ID_DETALLE_ENVIO, FECHA_ENVIO, EMBALAJE, PESO_TOTAL, VALOR_TRANSPORTE, COSTO_ESTIMADO, REFERENCIA ) VALUES ('";  //pegar cadena de insert hasta values *ideal para sqdl developer*
                    sql=sql+ ID_PAQUETE+"', '"+ ID_DETALLE_ENVIO+"', '"+ FECHA_ENVIO+"', '"+ EMBALAJE+"', '"+ PESO_TOTAL+"', '"+ VALOR_TRANSPORTE+"', '"+ COSTO_ESTIMADO+"', '"+ REFERENCIA +"')"; // +"', '"+ colocar en medio de las variables //sustiruir varX por el campo correpsondiente
                    cnOracle.insertarDB(sql);
                    break;
                    
                case "Consultar":
                    valida="2";
                    // obtener datos para formulario
                    oracleConexion co= new oracleConexion();
                    Object[][] prueba=co.consulta("Select * from DETALLE_ENVIO where ID_DETALLE_ENVIO='"+ID_DETALLE_ENVIO+"'");  //parametros del select o la consulta de un dato
                    //
                    
                    //enviar datos de la consulta al formulario --el formulario debe tener condicionales [para recibir la info
                    request.getSession().setAttribute("valida", valida);
                    request.getSession().setAttribute("ID_PAQUETE", prueba[0][0].toString());
                    request.getSession().setAttribute("ID_DETALLE_ENVIO", ID_DETALLE_ENVIO);  //la matriz contiene los datos de la consulta
                    request.getSession().setAttribute("FECHA_ENVIO", prueba[0][2].toString());
                    request.getSession().setAttribute("EMBALAJE", prueba[0][3].toString());
                    request.getSession().setAttribute("PESO_TOTAL", prueba[0][4].toString());
                    request.getSession().setAttribute("VALOR_TRANSPORTE", prueba[0][5].toString());
                    request.getSession().setAttribute("COSTO_ESTIMADO", prueba[0][6].toString());
                    request.getSession().setAttribute("REFERENCIA", prueba[0][7].toString());

                    break;
                    
                case "Actualizar":
                    valida="1";
                    sql="UPDATE DETALLE_ENVIO SET  ID_PAQUETE='"+ID_PAQUETE+"', ID_DETALLE_ENVIO='"+ID_DETALLE_ENVIO+"', FECHA_ENVIO='"+FECHA_ENVIO+"', EMBALAJE='"+EMBALAJE+"', PESO_TOTAL='"+PESO_TOTAL+"', VALOR_TRANSPORTE='"+VALOR_TRANSPORTE+"', COSTO_ESTIMADO='"+COSTO_ESTIMADO+"', REFERENCIA='"+REFERENCIA+"' WHERE ID_DETALLE_ENVIO = '"+ID_DETALLE_ENVIO+"'";  //colocar parametros para actualizar el registro*
                    cnOracle.actualizarDB(sql);
                    break;
                
                case "Borrar":
                    valida="1";
                    sql="DELETE FROM DETALLE_ENVIO WHERE ID_DETALLE_ENVIO ='";  //comando para borrar un registro
                    sql=sql+ ID_DETALLE_ENVIO+"'"; //valor del id a borrar
                    cnOracle.actualizarDB(sql);
                    break;
                    
                
                    
                
                    
            }
            request.getSession().setAttribute("valida", valida);  //envia el valor de la variable o validador
            out.println(cnOracle.getMensaje());  //mensaje de solicitud
            out.println(sql);  //comando
            
            out.println("<form action=\"#\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Continuar\" id=\"Continuar\" value=\"Continuar\"/>"); //boton para continuar
            out.println("</form>");
            out.println("<form action=\"formDetalleEnvio.jsp\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Volver\" id=\"Volver\" value=\"Volver\"/>"); //boton para continuar
            out.println("</form>");

            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DetalleEnvio</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println(cnOracle.getMensaje());
            out.println(sql);
            
            out.println("<h1>Servlet DetalleEnvio at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
