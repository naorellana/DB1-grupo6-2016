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
import javax.servlet.http.HttpSession;
import oracle.modelo.oracleConexion;

/**
 *
 * @author Nery Alexis Orellana
 */
public class IdTipoPaquete extends HttpServlet {

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
            
            String ID_TIPO_PAQUETE= request.getParameter("ID_TIPO_PAQUETE");  //usar esta linea para cada variable (campo)
            String TIPO_PAQUETE= request.getParameter("TIPO_PAQUETE");
            String LARGO= request.getParameter("LARGO");
            String ANCHO= request.getParameter("ANCHO");
            String PROFUNDIDA= request.getParameter("PROFUNDIDA");
            String PESO= request.getParameter("PESO");
            String btnEjecutar= request.getParameter("comando");
            
            String valida="1";  //VALIDA LA OPCION QUE SE EJECUTO PARA PASAR PARAMETROS A SERVLET Y FORMULARIO JSP
            
            oracleConexion cnOracle=new oracleConexion();
            String sql="";
            
            switch (btnEjecutar){
                case "Actualizar":
                    valida="1";
                    sql="UPDATE ID_TIPO_PAQUETE SET  TIPO_PAQUETE='"+TIPO_PAQUETE+"', LARGO='"+LARGO+"', ANCHO='"+ANCHO+"', PROFUNDIDA='"+PROFUNDIDA+"', PESO='"+PESO+"' WHERE ID_TIPO_PAQUETE = '"+ID_TIPO_PAQUETE+"'";  //pegar cadena de insert hasta values *ideal para sqdl developer*
                    cnOracle.actualizarDB(sql);
                    break;
                
                case "Borrar":
                    valida="1";
                    sql="DELETE FROM ID_TIPO_PAQUETE WHERE ID_TIPO_PAQUETE ='";  //pegar cadena de insert hasta values *ideal para sqdl developer*
                    sql=sql+ ID_TIPO_PAQUETE+"'"; // +"', '"+ colocar en medio de las variables //sustiruir varX por el campo correpsondiente
                    cnOracle.actualizarDB(sql);
                    break;
                
                
                case "Guardar":
                    valida="1";
                    sql="INSERT INTO ID_TIPO_PAQUETE ( ID_TIPO_PAQUETE, TIPO_PAQUETE, LARGO, ANCHO, PROFUNDIDA, PESO ) VALUES ('";  
                    sql=sql+ ID_TIPO_PAQUETE+"', '"+ TIPO_PAQUETE+"', '"+ LARGO+"', '"+ ANCHO+"', '"+ PROFUNDIDA+"', '"+ PESO +"')"; 
                    cnOracle.actualizarDB(sql);
                    
                    
                    
                    break;
                    
                case "Consultar":
                    valida="2";
                    // obtener datos para formulario
                    oracleConexion co= new oracleConexion();
                    Object[][] prueba=co.consulta("Select * from ID_TIPO_PAQUETE where ID_TIPO_PAQUETE='"+ID_TIPO_PAQUETE+"'");
                    //
                    
                    request.getSession().setAttribute("valida", valida);
                    //ID_TIPO_PAQUETE = request.getParameter("ID_TIPO_PAQUETE");
                    request.getSession().setAttribute("ID_TIPO_PAQUETE", ID_TIPO_PAQUETE);
                    //TIPO_PAQUETE = request.getParameter("TIPO_PAQUETE");
                    request.getSession().setAttribute("TIPO_PAQUETE", prueba[0][1].toString());
                    //LARGO = request.getParameter("LARGO");
                    request.getSession().setAttribute("LARGO", prueba[0][2].toString());
                    //ANCHO = request.getParameter("ANCHO");
                    request.getSession().setAttribute("ANCHO", prueba[0][3].toString());
                    //PROFUNDIDA = request.getParameter("PROFUNDIDA");
                    request.getSession().setAttribute("PROFUNDIDA", prueba[0][4].toString());
                    //PESO = request.getParameter("PESO");
                    request.getSession().setAttribute("PESO", prueba[0][5].toString());

                    break;
                    
            }
            request.getSession().setAttribute("valida", valida);  //envia el valor de la variable o validador
            out.println(cnOracle.getMensaje());
            out.println(sql);
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script src=\"js/script.js\"></script>");
            out.println("<title>Servlet IdTipoPaquete</title>");            
            out.println("</head>");
            out.println("<h1>Servlet IdTipoPaquete at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            
            out.println("<form action=\"formIdTipoPaquete.jsp\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"Continuar\" id=\"Continuar\" value=\"Continuar\"/>");
            
            out.println("<form action=\"formIdTipoPaquete.jsp\" method=\"post\">");
            out.println("<input type=\"submit\" name=\"Volver\" id=\"Volver\" value=\"Volver\"/>");
            
            out.println("</form>");
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
