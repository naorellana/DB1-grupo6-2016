/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupo6db1.controlador.servlets;

import grupo6db1.modelo.conexionSqlC;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nery Alexis Orellana
 */
public class pruebaRUTAS extends HttpServlet {

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
            
            String tipoPlaca=request.getParameter("tipoPlaca");
            String chofer= request.getParameter("chofer");
            String tiempo = request.getParameter("tiempo");
            String idRuta = request.getParameter("idRuta");
            String numPlaca = request.getParameter("numPlaca");
            String letPlaca = request.getParameter("letPlaca");
            String destino = request.getParameter("destino");
            conexionSqlC ce=new conexionSqlC();
            String sql="INSERT INTO RUTAS (TIPOPLACA, CHOFER, DESTINO, TIEMPO, IDRUTA, LETPLACA, NUMPLACA  )  VALUES  ( "+ tipoPlaca +", "+chofer+", "+ destino +", "+ tiempo+", '"+ idRuta+"', '"+ letPlaca+"', "+numPlaca+" )";
            //sql="create table tablita2 (num number(2,0), nume number(2,4)) ";
            ce.insertarDB(sql);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pruebaRUTAS</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pruebaRUTAS at " + request.getContextPath() + "</h1>");
            out.println(ce.getMensaje());
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
