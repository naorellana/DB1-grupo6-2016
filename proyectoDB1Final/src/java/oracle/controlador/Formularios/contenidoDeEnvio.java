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
public class contenidoDeEnvio extends HttpServlet {

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
            
            String ID_CONTENIDO_ENVIO= request.getParameter("ID_CONTENIDO_ENVIO");  //usar esta linea para cada variable (campo)
            String ID_ENVIO= request.getParameter("ID_ENVIO");
            String CONTENIDO= request.getParameter("CONTENIDO");
            String btnEjecutar= request.getParameter("comando");
            String valida="1";  //VALIDA LA OPCION QUE SE EJECUTO PARA PASAR PARAMETROS A SERVLET Y FORMULARIO JSP
            
            oracleConexion cnOracle=new oracleConexion();
            String sql="";
            switch (btnEjecutar){
                case "Guardar":
                    valida="1";
                    sql="INSERT INTO CONTENIDO_ENVIO ( ID_CONTENIDO_ENVIO, ID_ENVIO, CONTENIDO ) VALUES ('";  //pegar cadena de insert hasta values *ideal para sqdl developer*
                    sql=sql+ ID_CONTENIDO_ENVIO+"', '"+ ID_ENVIO+"', '"+ CONTENIDO +"')"; // +"', '"+ colocar en medio de las variables //sustiruir varX por el campo correpsondiente
                    cnOracle.insertarDB(sql);
            
                    break;
                    
                case "Consultar":
                    valida="2";
                    // obtener datos para formulario
                    oracleConexion co= new oracleConexion();
                    Object[][] prueba=co.consulta("Select * from CONTENIDO_ENVIO where ID_CONTENIDO_ENVIO='"+ID_CONTENIDO_ENVIO+"'");  //parametros del select o la consulta de un dato
                    //
                    
                    //enviar datos de la consulta al formulario --el formulario debe tener condicionales [para recibir la info
                    request.getSession().setAttribute("valida", valida);
                    request.getSession().setAttribute("ID_CONTENIDO_ENVIO",ID_CONTENIDO_ENVIO );
                    request.getSession().setAttribute("ID_ENVIO", prueba[0][1].toString());  //la matriz contiene los datos de la consulta
                    request.getSession().setAttribute("CONTENIDO", prueba[0][2].toString());
                    break;
                    
                case "Actualizar":
                    valida="1";
                    sql="UPDATE CONTENIDO_ENVIO SET  ID_CONTENIDO_ENVIO='"+ID_CONTENIDO_ENVIO+"', ID_ENVIO='"+ID_ENVIO+"', CONTENIDO='"+CONTENIDO+"' WHERE ID_CONTENIDO_ENVIO = '"+ID_CONTENIDO_ENVIO+"'";  //colocar parametros para actualizar el registro*
                    cnOracle.actualizarDB(sql);
                    break;
                
                case "Borrar":
                    valida="1";
                    sql="DELETE FROM CONTENIDO_ENVIO WHERE ID_CONTENIDO_ENVIO ='";  //comando para borrar un registro
                    sql=sql+ ID_CONTENIDO_ENVIO+"'"; //valor del id a borrar
                    cnOracle.actualizarDB(sql);
                    break;
                    
                
                    
                
                    
            }
            request.getSession().setAttribute("valida", valida);  //envia el valor de la variable o validador
            out.println(cnOracle.getMensaje());  //mensaje de solicitud
            out.println(sql);  //comando
            
            /*out.println("<form action=\"#\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Continuar\" id=\"Continuar\" value=\"Continuar\"/>"); //boton para continuar
            out.println("</form>");
            out.println("<form action=\"formContenidoDeEnvio.jsp\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Volver\" id=\"Volver\" value=\"Volver\"/>"); //boton para continuar
            out.println("</form>");*/
            
            out.println("<form action=\"AlmacenaDatos\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"text\" name=\"dato1\" id=\"dato1\"  style=\"visibility:hidden\" value=\""+ID_CONTENIDO_ENVIO+"\"> ");
            out.println("<input type=\"text\" name=\"pag\" id=\"pag\"  style=\"visibility:hidden\" value=\"2\"> ");
            out.println("<p></p>");
            out.println("<input type=\"submit\" name=\"Continuar\" id=\"Continuar\" value=\"Continuar\"/>"); //boton para continuar
            out.println("</form>");
            out.println("<form action=\"formDireccion.jsp\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Volver\" id=\"Volver\" value=\"Volver\"/>"); //boton para continuar
            out.println("</form>");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet contenidoDeEnvio</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet contenidoDeEnvio at " + request.getContextPath() + "</h1>");
            out.println(cnOracle.getMensaje());
            out.println(sql);
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
