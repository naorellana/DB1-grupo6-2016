<%-- 
    Document   : pruebasJSP
    Created on : 28-sep-2016, 21:37:19
    Author     : Nery Alexis Orellana
--%>

<%@page import="grupo6db1.modelo.conexionDB"%>
<%@page import="grupo6db1.clases.funcionalidad"%>
<%@page import="grupo6db1.controlador.conexionSql"%>
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
    </body>
</html>
