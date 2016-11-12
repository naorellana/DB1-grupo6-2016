<%-- 
    Document   : index
    Created on : 23-sep-2016, 13:29:19
    Author     : Nery Alexis Orellana
--%>

<%@page import="grupo6db1.controlador.conexionSql"%>
<%@page import="grupo6db1.clases.funcionalidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>GRUPO 6 </p>
        <p><---Envíos / Entregas / Rutas--->!</p>
        <%! conexionSql co= new conexionSql();%>
        <%! Object[][] prueba=co.consultarDB1("PRUEBA2"); %>
        <%! String  dat=""; %>
        <%!int i; %>
        <p><%= co.conectar() %></p>
        <p><%= prueba[0][0].toString() %></p>
        <%
            i=0;
            dat=co.datosCOnsulta();
            prueba=co.consultarDB1("PRUEBA2");
            while(i<4){
                out.println(prueba[i][0]);
                out.println(prueba[i][1]);
                i++;
            };
        %>
        <p><%= dat=co.datosCOnsulta()%></p>
        
    </body>
</html>
