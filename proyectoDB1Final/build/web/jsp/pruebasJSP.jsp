<%-- 
    Document   : pruebasJSP
    Created on : 28-sep-2016, 21:37:19
    Author     : Nery Alexis Orellana
--%>

<%@page import="grupo6db1.modelo.conexionSqlC"%>
<%@page import="grupo6db1.modelo.conexionDB"%>
<%@page import="grupo6db1.clases.funcionalidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%! conexionDB conectado=new conexionDB();%>
        <h1>Hello World!</h1>
        <%! String h=conectado.conectar(); %>
        <%! conexionDB fun=new conexionDB(); %>
        <%! String fu;%>
        <% fu= fun.conectar(); %>
        <% h=fun.escribir("INSERT INTO  PRUEBA2  (    ID,    USUARIO  )  VALUES  ('basek1', 'base')"); %>
        <%= fu %>
        <p><%= h%></p>
        
        
        <%! conexionSqlC ccc= new conexionSqlC(); %>
        <%! String t; %>
        <% t=ccc.conectar(); %>
        <%=t%>
        <%!Object [][] p=ccc.consulta("SELECT cname FROM col WHERE tname = 'FACTURA'");%>
        //System.out.println("leyendo objeto en 0,1 " +p[0][1].toString());
        <% t =ccc.datosCOnsulta();%>
        
    </body>
</html>
