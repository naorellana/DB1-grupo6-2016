<%-- 
    Document   : inicio
    Created on : 30-sep-2016, 9:49:12
    Author     : Nery Alexis Orellana
--%>

<%@page import="oracle.modelo.oracleConexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="js/script.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
	<link href='https://fonts.googleapis.com/css?family=Cabin+Sketch' rel='stylesheet' type='text/css'>
        <title>| Proyecto | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
        
    </head>
    <body class="fondo fuente">
        <nav class="fondo-rojo  padding-largo text-center">
		<ul class="nolista ">
			<li class="col-md-3 inline-block "> <a class="blanco" href="forMenu.jsp">Ingresar Datos</a>  </li>
			<li class="col-md-3 inline-block"> <a class="blanco" href="ReportesMenu.jsp">Reportes </a> </li>
			<li class="col-md-3 inline-block"> <a  class="blanco" href="consMenu.jsp">Consultas</a> </li>
		</ul>
	</nav>
        
        <div class="col-sd-12 col-md-12  center-block quitar-float text-center   fuente">
             <img class="imgs espacio-arriba" src="imgs/Oracle-logo.png">
        </div>

        
        <div class="col-md-6 center-block quitar-float text-center   fuente"> 
                <%! oracleConexion c= new oracleConexion();%>
                <p class="blanco" > Bienvenido <%= " "+c.getUsuarioDB()+ " "+c.conectar() %></p>
		<h1 class="Cabin-Sketch blanco"> Proyecto Final | Bases de Datos 1 | 2016 </h1>
                <h2 class="Cabin-Sketch blanco"> UMG San Jose Pinula - Seccion "A" </h2>
                <h3 class="Cabin-Sketch blanco"> Nery Alexis Orellana Cuy 3190-12-2594 </h3>
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
