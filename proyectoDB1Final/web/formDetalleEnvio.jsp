<%-- 
    Document   : enviosPrueba
    Created on : 04-oct-2016, 17:31:34
    Author     : Nery Alexis Orellana
--%>
<%-- contenido de java//--%>
<%! String valida; %>
<%  valida = (String)session.getAttribute("valida"); %> <%-- valida la solicitud que se hizo al servlet--%>
<%! String ID_PAQUETE=""; %>
<%! String ID_DETALLE_ENVIO=""; %>
<%! String FECHA_ENVIO=""; %>
<%! String EMBALAJE=""; %>
<%! String PESO_TOTAL=""; %>
<%! String VALOR_TRANSPORTE=""; %>
<%! String COSTO_ESTIMADO=""; %>
<%! String REFERENCIA=""; %>

<%--valida si se llego al formulario por una consulta y setea los datos--%>
<%if (valida=="2"){ %>
<%  ID_PAQUETE = (String)session.getAttribute("ID_PAQUETE"); %>
<%  ID_DETALLE_ENVIO = (String)session.getAttribute("ID_DETALLE_ENVIO"); %>
<%  FECHA_ENVIO = (String)session.getAttribute("FECHA_ENVIO"); %>
<%  EMBALAJE = (String)session.getAttribute("EMBALAJE"); %>
<%  PESO_TOTAL = (String)session.getAttribute("PESO_TOTAL"); %>
<%  VALOR_TRANSPORTE = (String)session.getAttribute("VALOR_TRANSPORTE"); %>
<%  COSTO_ESTIMADO = (String)session.getAttribute("COSTO_ESTIMADO"); %>
<%  REFERENCIA = (String)session.getAttribute("REFERENCIA"); %>
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
                <form action="formularioDetalleEnvio" method="post">
                    <p><input type="text" name="ID_PAQUETE" id="ID_PAQUETE" placeholder="ID_PAQUETE" value="<%= ID_PAQUETE %>"> </p>
                    <p><input type="text" name="ID_DETALLE_ENVIO" id="ID_DETALLE_ENVIO" placeholder="ID_DETALLE_ENVIO" value="<%= ID_DETALLE_ENVIO %>"> </p>
                    <p><input type="text" name="FECHA_ENVIO" id="FECHA_ENVIO" placeholder="FECHA_ENVIO" value="<%= FECHA_ENVIO %>" > </p>
                    <p><input type="text" name="EMBALAJE" id="EMBALAJE" placeholder="EMBALAJE" value="<%= EMBALAJE %>" > </p>
                    <p><input type="text" name="PESO_TOTAL" id="PESO_TOTAL" placeholder="PESO_TOTAL" value="<%= PESO_TOTAL %>" > </p>
                    <p> <input type="text" name="VALOR_TRANSPORTE" id="VALOR_TRANSPORTE" placeholder="VALOR_TRANSPORTE"value="<%= VALOR_TRANSPORTE %>" > </p>
                    <p><input type="text" name="COSTO_ESTIMADO" id="COSTO_ESTIMADO" placeholder="COSTO_ESTIMADO" value="<%= COSTO_ESTIMADO %>" ></p>
                    <p><input type="text" name="REFERENCIA" id="REFERENCIA" placeholder="REFERENCIA" value="<%= REFERENCIA %>" ></p>
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
