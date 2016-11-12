<%-- 
    Document   : pruebaReportes
    Created on : 20-oct-2016, 7:53:51
    Author     : Nery Alexis Orellana
--%>

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
        <title>| Menu Reportes | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
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
            
        </div> 
        
        <div class="col-md-6 center-block quitar-float text-center   fuente"> 
            <h1 class="Cabin-Sketch blanco"> REPORTES COMPLETOS </h1>
            <img src="imgs/png/reporte.png" class="col-md-6 quitar-float espacio-abajo">
                <form action="data" method="post">
                    <select name="tabla" id="tabla">
                        <option value="CONTENIDO_ENVIO">CONTENIDO ENVIO</option>
                        <option value="DESTINATARIO">DESTINATARIO</option>
                        <option value="DETALLE_ENVIO">DETALLE ENVIO</option>
                        <option value="ENVIOS">ENVIOS</option>
                        <option value="ID_TIPO_PAQUETE">ID TIPO PAQUETE</option>
                        <option value="REMITENTE">REMITENTE</option>
                        <option value="USUARIO">USUARIO</option>
                    </select> 
                    <p><input type="submit" name="generarReporte " id="Entrar" value="Generar Reporte"></p>
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