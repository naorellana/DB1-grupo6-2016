<%-- 
    Document   : envios
    Created on : 30-sep-2016, 9:46:48
    Author     : Nery Alexis Orellana
--%>
<%-- contenido de java//--%>
<%! String valida; %>
<%  valida = (String)session.getAttribute("valida"); %> <%-- valida la solicitud que se hizo al servlet--%>
<%! String ID_ENVIO=""; %>
<%! String ID_DETALLE_ENVIO=""; %>
<%! String ID_DESTINATARIO=""; %>
<%! String ID_SERVICIO=""; %>
<%! String ID_MANEJO=""; %>
<%! String ID_ALERTA=""; %>
<%! String ID_USUARIO=""; %>
<%! String ID_ESTADO=""; %>
<%! String ID_DIRECCION=""; %>
<%! String ID_PRODUCTO=""; %>
<%! String ID_DEVOLUCION=""; %>
<%! String ENVIO=""; %>
<%! String FECHA=""; %>

<%--valida si se llego al formulario por una consulta y setea los datos--%>
<%if (valida=="2"){ %>

<% String ID_ENVIO=""; %>
<% String ID_DETALLE_ENVIO=""; %>
<% String ID_DESTINATARIO=""; %>
<% String ID_SERVICIO=""; %>
<% String ID_MANEJO=""; %>
<% String ID_ALERTA=""; %>
<% String ID_USUARIO=""; %>
<% String ID_ESTADO=""; %>
<% String ID_DIRECCION=""; %>
<% String ID_PRODUCTO=""; %>
<% String ID_DEVOLUCION=""; %>
<% String ENVIO=""; %>
<% String FECHA=""; %>

<%  ID_ENVIO = (String)session.getAttribute("ID_ENVIO"); %>
<%  ID_DETALLE_ENVIO = (String)session.getAttribute("ID_DETALLE_ENVIO"); %>
<%  ID_DESTINATARIO = (String)session.getAttribute("ID_DESTINATARIO"); %>
<%  ID_SERVICIO = (String)session.getAttribute("ID_SERVICIO"); %>
<%  ID_MANEJO = (String)session.getAttribute("ID_MANEJO"); %>
<%  ID_ALERTA = (String)session.getAttribute("ID_ALERTA"); %>
<%  ID_USUARIO = (String)session.getAttribute("ID_USUARIO"); %>
<%  ID_ESTADO = (String)session.getAttribute("ID_ESTADO"); %>
<%  ID_DIRECCION = (String)session.getAttribute("ID_DIRECCION"); %>
<%  ID_PRODUCTO = (String)session.getAttribute("ID_PRODUCTO"); %>
<%  ID_DEVOLUCION = (String)session.getAttribute("ID_DEVOLUCION"); %>
<%  ENVIO = (String)session.getAttribute("ENVIO"); %>
<%  FECHA = (String)session.getAttribute("FECHA"); %>
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
        <title>| Formulario De Envio | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
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

		
                <p class="Cabin-Sketch blanco"> Ingresar Los Datos Del Envio </p>
                <form action="formularioEnvios" method="post">
                    <p><input type="text" name="ID_ENVIO" id="ID_ENVIO" placeholder="ID_ENVIO" value="<%= ID_ENVIO %>"> </p>
                    <p><input type="text" name="ID_DETALLE_ENVIO" id="ID_DETALLE_ENVIO" placeholder="ID_DETALLE_ENVIO" value="<%=ID_DETALLE_ENVIO%>"> </p>
                    <p><input type="text" name="ID_DESTINATARIO" id="ID_DESTINATARIO" placeholder="ID_DESTINATARIO" value="<%=ID_DESTINATARIO%>"> </p>
                    <p><input type="text" name="ID_SERVICIO" id="ID_SERVICIO" placeholder="ID_SERVICIO" value="<%=ID_SERVICIO%>"> </p>
                    <p><input type="text" name="ID_MANEJO" id="ID_MANEJO" placeholder="ID_MANEJO" value="<%=ID_MANEJO%>" > </p>
                    <p><input type="text" name="ID_ALERTA" id="ID_ALERTA" placeholder="ID_ALERTA" value="<%=ID_ALERTA%>" > </p>
                    <p><input type="text" name="ID_USUARIO" id="ID_USUARIO" placeholder="ID_USUARIO" value="<%=ID_USUARIO%>" > </p>
                    <p><input type="text" name="ID_ESTADO" id="ID_ESTADO" placeholder="ID_ESTADO" value="<%=ID_ESTADO%>" > </p>
                    <p><input type="text" name="ID_DIRECCION" id="ID_DIRECCION" placeholder="ID_DIRECCION" value="<%=ID_DIRECCION%>" > </p>
                    <p><input type="text" name="ID_PRODUCTO" id="ID_PRODUCTO" placeholder="ID_PRODUCTO" value="<%=ID_PRODUCTO%>" > </p>
                    <p><input type="text" name="ID_DEVOLUCION" id="ID_DEVOLUCION" placeholder="ID_DEVOLUCION" value="<%=ID_DEVOLUCION%>" > </p>
                    <p><input type="text" name="ENVIO" id="ENVIO" placeholder="ENVIO" value="<%=ENVIO%>" > </p>
                    <p><input type="text" name="FECHA" id="ID_ESTADO" placeholder="FECHA" value="<%=FECHA%>" > </p>
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
