<%-- 
    Document   : pruebaReportes
    Created on : 20-oct-2016, 7:53:51
    Author     : Nery Alexis Orellana
--%>

<%@page import="oracle.modelo.oracleConexion"%>
<%@page import="grupo6db1.modelo.conexionSqlC"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="js/script.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
	<link href='https://fonts.googleapis.com/css?family=Cabin+Sketch' rel='stylesheet' type='text/css'>
        <title>| Reportes | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
    </head>
    <body class="fondo fuente">
        <nav class="fondo-rojo  padding-largo text-center">
		<ul class="nolista ">
			<li class="col-md-3 inline-block "> <a class="blanco" href="forMenu.jsp">Ingresar Datos</a>  </li>
			<li class="col-md-3 inline-block"> <a class="blanco" href="ReportesMenu.jsp">Reportes </a> </li>
			<li class="col-md-3 inline-block"> <a  class="blanco" href="consMenu.jsp">Consultas</a> </li>
		</ul>
	</nav>
        <div class="col-md-12 center-block quitar-float text-center   fuente text-align: center;">
            <%! String tabla="";%>
                    <%         tabla = (String)session.getAttribute("tabla");        %>
                    <%
            String nombre_variable = (String)session.getAttribute("nombre_param");
            %>
            <%! oracleConexion co= new oracleConexion();%>
            <% Object[][] prueba=co.consultarDB1(tabla.toString()); %>
            <%! String  dat=""; %>
            <%! int i; %>
            
        </div> 
        <div class="col-md-6 center-block quitar-float text-center   fuente ">
            <table>
                <h1><caption  class="Cabin-Sketch blanco"> Reporte De <%= tabla %> :</caption></h1>
                <tr> 
                    <%!oracleConexion ccc= new oracleConexion(); %>
                    <%Object [][] p=ccc.consulta("SELECT cname FROM col WHERE tname = '"+ tabla +"'");%>
                    <%for (int i=0; i< ccc.getCantFilas(); i++ ){%>
                    <th> <%= p[i][0].toString() %> </th>
                        <%}%>
                </tr>
                <% for (int c=0; c<co.getCantFilas(); c++){ %>
                <tr>
                    <% for (int f=0; f<co.getCantColumnas(); f++){ %>
                        <td><%=prueba[c][f].toString() %></td>
            
                    <% }%>
                </tr>
                <% }%>
            </table>
        </div>
        <div class="col-md-6 center-block quitar-float text-center   fuente"> 
                <nav class="espacio-arriba"  >
			<a class="blanco espacio-derecha" href="https://github.com/naorellana/DB1-grupo6-2016" >| GitHub |</a>
			<a class="blanco espacio-derecha" href="http://db1umg2016.hol.es/">| Documentacion |</a>
			<a class="blanco espacio-derecha" href="proyectos.html">| Descargas |</a>
                        <p class="blanco espacio-derecha">| Escríbenos a:<a class="blanco" href="mailto:db1umgsjp@gmail.com"> db1umgsjp@gmail.com | </a></p>
		</nav>
                
	</div>
            <footer class="blanco" >
                   <p> © 2016 <a class="blanco" href="http://norellana.hol.es/"> Nery Alexis Orellana Cuy </a> - Todos los derechos reservados. </p>
                </footer>
    </body>
</html>