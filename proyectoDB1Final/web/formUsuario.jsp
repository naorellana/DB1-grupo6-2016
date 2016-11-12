<%-- 
    Document   : enviosPrueba
    Created on : 04-oct-2016, 17:31:34
    Author     : Nery Alexis Orellana
--%>
<%-- contenido de java//--%>
<%! String valida; %>
<%  valida = (String)session.getAttribute("valida"); %> <%-- valida la solicitud que se hizo al servlet--%>
<%! String ID_USUARIO=""; %>
<%! String ID_TIPO_USUARIO=""; %>
<%! String ID_PERSONA=""; %>
<%! String LOGIN=""; %>
<%! String PASSWORD=""; %>
<%! String FECHA_ALTA=""; %>
<%! String FECHA_BAJA=""; %>

<%--valida si se llego al formulario por una consulta y setea los datos--%>
<%if (valida=="2"){ %>
<%  ID_USUARIO = (String)session.getAttribute("ID_USUARIO"); %>
<%  ID_TIPO_USUARIO = (String)session.getAttribute("ID_TIPO_USUARIO"); %>
<%  ID_PERSONA = (String)session.getAttribute("ID_PERSONA"); %>
<%  LOGIN = (String)session.getAttribute("LOGIN"); %>
<%  PASSWORD = (String)session.getAttribute("PASSWORD"); %>
<%  FECHA_ALTA = (String)session.getAttribute("FECHA_ALTA"); %>
<%  FECHA_BAJA = (String)session.getAttribute("FECHA_BAJA"); %>
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
                <form action="formularioUsuario" method="post">
                    <p><input type="text" name="ID_USUARIO" id="ID_USUARIO" placeholder="ID_USUARIO" value="<%=ID_USUARIO %>"></p>
                    <p><input type="text" name="ID_TIPO_USUARIO" id="ID_TIPO_USUARIO" placeholder="ID_TIPO_USUARIO" value="<%=ID_TIPO_USUARIO %>"></p>
                    <p><input type="text" name="ID_PERSONA" id="ID_PERSONA" placeholder="ID_PERSONA" value="<%=ID_PERSONA %>"> </p>
                    <p><input type="text" name="LOGIN" id="LOGIN" placeholder="LOGIN" value="<%=LOGIN %>"> </p>
                    <p><input type="text" name="PASSWORD" id="PASSWORD" placeholder="PASSWORD" value="<%=PASSWORD %>"> </p>
                    <p><input type="text" name="FECHA_ALTA" id="FECHA_ALTA" placeholder="FECHA_ALTA" value="<%=FECHA_ALTA %>"> </p>
                    <p><input type="text" name="FECHA_BAJA" id="FECHA_BAJA" placeholder="FECHA_BAJA" value="<%=FECHA_BAJA %>"> </p>
                    <select name="comando" id="comando">
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
