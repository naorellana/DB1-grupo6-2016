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
public class Usuario extends HttpServlet {

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
            
            String ID_USUARIO= request.getParameter("ID_USUARIO");  //usar esta linea para cada variable (campo)
            String ID_TIPO_USUARIO= request.getParameter("ID_TIPO_USUARIO");
            String ID_PERSONA= request.getParameter("ID_PERSONA");
            String LOGIN= request.getParameter("LOGIN");
            String PASSWORD= request.getParameter("PASSWORD");
            String FECHA_ALTA= request.getParameter("FECHA_ALTA");
            String FECHA_BAJA= request.getParameter("FECHA_BAJA");
            String btnEjecutar= request.getParameter("comando");
            String valida="1";  //VALIDA LA OPCION QUE SE EJECUTO PARA PASAR PARAMETROS A SERVLET Y FORMULARIO JSP
            
            oracleConexion cnOracle=new oracleConexion();
            String sql="";
            switch (btnEjecutar){
                case "Guardar":
                    valida="1";
                    sql="INSERT INTO USUARIO ( ID_USUARIO, ID_TIPO_USUARIO, ID_PERSONA, LOGIN, PASSWORD, FECHA_ALTA, FECHA_BAJA ) VALUES ('";  //pegar cadena de insert hasta values *ideal para sqdl developer*
                    sql=sql+ ID_USUARIO+"', '"+ ID_TIPO_USUARIO+"', '"+ ID_PERSONA+"', '"+ LOGIN+"', '"+ PASSWORD+"', '"+ FECHA_ALTA+"', '"+ FECHA_BAJA +"')"; // +"', '"+ colocar en medio de las variables //sustiruir varX por el campo correpsondiente
                    cnOracle.insertarDB(sql);
                    break;
                    
                case "Consultar":
                    valida="2";
                    // obtener datos para formulario
                    oracleConexion co= new oracleConexion();
                    Object[][] prueba=co.consulta("Select * from USUARIO where ID_USUARIO='"+ID_USUARIO+"'");  //parametros del select o la consulta de un dato
                    //
                    
                    //enviar datos de la consulta al formulario --el formulario debe tener condicionales [para recibir la info
                    request.getSession().setAttribute("valida", valida);
                    request.getSession().setAttribute("ID_USUARIO",ID_USUARIO );
                    request.getSession().setAttribute("ID_TIPO_USUARIO", prueba[0][0].toString());  //la matriz contiene los datos de la consulta
                    request.getSession().setAttribute("ID_PERSONA", prueba[0][2].toString());
                    request.getSession().setAttribute("LOGIN", prueba[0][3].toString());
                    request.getSession().setAttribute("PASSWORD", prueba[0][4].toString());
                    request.getSession().setAttribute("FECHA_ALTA", prueba[0][5].toString());
                    request.getSession().setAttribute("FECHA_BAJA", prueba[0][6].toString());

                    break;
                    
                case "Actualizar":
                    valida="1";
                    sql="UPDATE USUARIO SET  ID_USUARIO='"+ID_USUARIO+"', ID_TIPO_USUARIO='"+ID_PERSONA+"', LOGIN='"+LOGIN+"', PASSWORD='"+PASSWORD+"', FECHA_ALTA='"+FECHA_ALTA+"', FECHA_BAJA='"+FECHA_BAJA+"' WHERE ID_USUARIO = '"+ID_USUARIO+"'";  //colocar parametros para actualizar el registro*
                    cnOracle.actualizarDB(sql);
                    break;
                
                case "Borrar":
                    valida="1";
                    sql="DELETE FROM USUARIO WHERE ID_USUARIO ='";  //comando para borrar un registro
                    sql=sql+ ID_USUARIO+"'"; //valor del id a borrar
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
            out.println("<title>Servlet Usuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Usuario at " + request.getContextPath() + "</h1>");
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
