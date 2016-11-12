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
public class formEnvios extends HttpServlet {

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
            String ID_ENVIO= request.getParameter("ID_ENVIO");    
            String ID_DETALLE_ENVIO= request.getParameter("ID_DETALLE_ENVIO");
            String ID_DESTINATARIO= request.getParameter("ID_DESTINATARIO");
            String ID_SERVICIO= request.getParameter("ID_SERVICIO");
            String ID_MANEJO= request.getParameter("ID_MANEJO");
            String ID_ALERTA= request.getParameter("ID_ALERTA");
            String ID_USUARIO= request.getParameter("ID_USUARIO");
            String ID_ESTADO= request.getParameter("ID_ESTADO");
            String ID_DIRECCION= request.getParameter("ID_DIRECCION");
            String ID_PRODUCTO= request.getParameter("ID_PRODUCTO");
            String ID_DEVOLUCION= request.getParameter("ID_DEVOLUCION");
            String ENVIO= request.getParameter("ENVIO");
            String FECHA= request.getParameter("FECHA");
            
            String btnEjecutar= request.getParameter("comando");
            String valida="1";  //VALIDA LA OPCION QUE SE EJECUTO PARA PASAR PARAMETROS A SERVLET Y FORMULARIO JSP
            
            oracleConexion cnOracle=new oracleConexion();
            String sql="";
            switch (btnEjecutar){
                case "Guardar":
                    valida="1";
                    sql="INSERT INTO ENVIOS ( ID_ENVIO, ID_DETALLE_ENVIO, ID_DESTINATARIO, ID_SERVICIO, ID_MANEJO, ID_ALERTA, ID_USUARIO, ID_ESTADO, ID_DIRECCION, ID_PRODUCTO, ID_DEVOLUCION, ENVIO, FECHA ) VALUES ( ' ";
                    sql=sql+ ID_ENVIO+"', '"+ ID_DETALLE_ENVIO+"', '"+ ID_DESTINATARIO+"', '"+ ID_SERVICIO+"', '"+ ID_MANEJO+"', '"+ ID_ALERTA+"', '"+ ID_USUARIO+"', '"+ ID_ESTADO+"', '"+ ID_DIRECCION+"', '"+ ID_PRODUCTO+"', '"+ ID_DEVOLUCION+"', '"+ ENVIO+"', '"+ FECHA +"')"; // +"', '"+ colocar en medio de las variables //sustiruir varX por el campo correpsondiente 
                    cnOracle.insertarDB(sql);
            
                    break;
                    
                case "Consultar":
                    valida="2";
                    // obtener datos para formulario
                    oracleConexion co= new oracleConexion();
                    Object[][] prueba=co.consulta("Select * from ENVIOS where ID_ENVIO='"+ID_ENVIO+"'");  //parametros del select o la consulta de un dato
                    //
                    
                    //enviar datos de la consulta al formulario --el formulario debe tener condicionales [para recibir la info
                    request.getSession().setAttribute("valida", valida);
                    request.getSession().setAttribute("ID_ENVIO", ID_ENVIO);
                    request.getSession().setAttribute("ID_DETALLE_ENVIO", prueba[0][1].toString());  //la matriz contiene los datos de la consulta
                    request.getSession().setAttribute("ID_DESTINATARIO", prueba[0][2].toString());
                    request.getSession().setAttribute("ID_SERVICIO", prueba[0][3].toString());
                    request.getSession().setAttribute("ID_MANEJO", prueba[0][4].toString());
                    request.getSession().setAttribute("ID_ALERTA", prueba[0][5].toString());
                    request.getSession().setAttribute("ID_USUARIO", prueba[0][6].toString());
                    request.getSession().setAttribute("ID_ESTADO", prueba[0][7].toString());
                    request.getSession().setAttribute("ID_DIRECCION", prueba[0][8].toString());
                    request.getSession().setAttribute("ID_PRODUCTO", prueba[0][9].toString());
                    request.getSession().setAttribute("ID_DEVOLUCION", prueba[0][10].toString());
                    request.getSession().setAttribute("ENVIO", prueba[0][11].toString());
                    request.getSession().setAttribute("FECHA", prueba[0][12].toString());

                    break;
                    
                case "Actualizar":
                    valida="1";
                    sql="UPDATE ENVIOS SET  ID_ENVIO='"+ID_ENVIO+"', ID_DETALLE_ENVIO='"+ID_DETALLE_ENVIO+"', ID_DESTINATARIO='"+ID_DESTINATARIO+"', ID_SERVICIO='"+ID_SERVICIO+"', ID_MANEJO='"+ID_MANEJO+"', ID_ALERTA='"+ID_ALERTA+"', ID_USUARIO='"+ID_USUARIO+"', ID_ESTADO='"+ID_ESTADO+
                            "', ID_DIRECCION='"+ID_DIRECCION+"', ID_PRODUCTO='"+ID_PRODUCTO+"', ID_DEVOLUCION='"+ID_DEVOLUCION+"', ENVIO='"+ENVIO+"', FECHA='"+FECHA+"' WHERE ID_ENVIO = '"+ID_ENVIO+"'";  //colocar parametros para actualizar el registro*
                    cnOracle.actualizarDB(sql);
                    break;
                
                case "Borrar":
                    valida="1";
                    sql="DELETE FROM DETALLE_ENVIO WHERE ID_ENVIO ='";  //comando para borrar un registro
                    sql=sql+ ID_ENVIO+"'"; //valor del id a borrar
                    cnOracle.actualizarDB(sql);
                    break;
                    
                
                    
                
                    
            }
            request.getSession().setAttribute("valida", valida);  //envia el valor de la variable o validador
            out.println(cnOracle.getMensaje());  //mensaje de solicitud
            out.println(sql);  //comando
            
            out.println("<form action=\"#\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Continuar\" id=\"Continuar\" value=\"Continuar\"/>"); //boton para continuar
            out.println("</form>");
            out.println("<form action=\"forEnvios.jsp\" method=\"post\">");  //a donde redirecciona el boton
            out.println("<input type=\"submit\" name=\"Volver\" id=\"Volver\" value=\"Volver\"/>"); //boton para continuar
            out.println("</form>");
            
            
            out.println(cnOracle.getMensaje());
            out.println(sql);
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet formEnvios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet formEnvios at " + request.getContextPath() + "</h1>");
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
