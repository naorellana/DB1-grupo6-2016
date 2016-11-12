<%-- 
    Document   : enviosPrueba
    Created on : 04-oct-2016, 17:31:34
    Author     : Nery Alexis Orellana
--%>
<%-- contenido de java//--%>
<%! String valida; %>
<%  valida = (String)session.getAttribute("valida"); %> <%-- valida la solicitud que se hizo al servlet--%>
<%! String ID_DIRECCION=""; %>
<%! String ID_MUNICIPIO=""; %>
<%! String DIRECCION=""; %>
<%! String CODIGO_POSTAL=""; %>

<%--valida si se llego al formulario por una consulta y setea los datos--%>
<%if (valida=="2"){ %>
<%  ID_DIRECCION = (String)session.getAttribute("ID_DIRECCION"); %>
<%  ID_MUNICIPIO = (String)session.getAttribute("ID_MUNICIPIO"); %>
<%  DIRECCION = (String)session.getAttribute("DIRECCION"); %>
<%  CODIGO_POSTAL = (String)session.getAttribute("CODIGO_POSTAL"); %>
<%}%>
<%-- contenido de java//--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="js/script.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
	<link href='https://fonts.googleapis.com/css?family=Cabin+Sketch' rel='stylesheet' type='text/css'>
        <title>| Tipo De Paquete | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
    </head>
    
    <body class="fondo fuente">
        <nav class="fondo-rojo  padding-largo text-center">
		<ul class="nolista ">
			<li class="col-md-3 inline-block "> <a class="blanco" href="forMenu.jsp">Ingresar Datos</a>  </li>
			<li class="col-md-3 inline-block"> <a class="blanco" href="ReportesMenu.jsp">Reportes </a> </li>
			<li class="col-md-3 inline-block"> <a  class="blanco" href="consMenu.jsp">Consultas</a> </li>
		</ul>
	</nav>
        <div class="col-md-6 center-block quitar-float text-center   fuente"> 

		
                <p class="Cabin-Sketch blanco"> Ingresar Los Datos Del Tipo De Paquete </p>
                <form action="FormularioDireccion"   method="post">
                    <p><input type="text" name="ID_DIRECCION" id="ID_DIRECCION" placeholder="ID_DIRECCION" value="<%=ID_DIRECCION  %>"></p>
                    <p><input type="text" name="ID_MUNICIPIO" id="ID_MUNICIPIO" placeholder="ID_MUNICIPIO" value="<%=ID_MUNICIPIO  %>"> </p>
                    <p><input type="text" name="DIRECCION" id="DIRECCION" placeholder="DIRECCION" value="<%= DIRECCION %>"> </p>
                    <p><input type="text" name="CODIGO_POSTAL" id="CODIGO_POSTAL" placeholder="CODIGO_POSTAL" value="<%= CODIGO_POSTAL  %>"> </p><select name="comando" id="comando">
                        <option value="Actualizar">Actualizar</option>
                        <option value="Borrar">Borrar</option>
                        <option value="Guardar"> Guardar</option>
                        <option value="Consultar"> Consultar</option>
                    </select> 
                    <p><input type="submit" name="btn" id="btn" value="Ejecutar"/>  </p>
                </form>
		<nav class="espacio-arriba"  >
			<a class="blanco espacio-derecha" href="https://github.com/naorellana/DB1-grupo6-2016" >| GitHub |</a>
			<a class="blanco espacio-derecha"href="http://db1umg2016.hol.es/">| Documentacion |</a>
			<a class="blanco espacio-derecha" href="proyectos.html">| Descargas |</a>
                        <p class="blanco espacio-derecha">| Escríbenos a:<a class="blanco" href="mailto:db1umgsjp@gmail.com"> db1umgsjp@gmail.com | </a></p>
		</nav>
                
	</div>
        <footer class="blanco" >
                   <p> © 2016 <a class="blanco" href="http://norellana.hol.es/"> Nery Alexis Orellana Cuy </a> - Todos los derechos reservados. </p>
                </footer>
    </body>
</html>
