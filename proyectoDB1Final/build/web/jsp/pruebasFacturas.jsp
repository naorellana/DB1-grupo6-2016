<%-- 
    Document   : enviosPrueba
    Created on : 04-oct-2016, 17:31:34
    Author     : Nery Alexis Orellana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
        <script src="js/script.js"></script>
        <link rel="stylesheet" href="css/style.css"/>
	<link href='https://fonts.googleapis.com/css?family=Cabin+Sketch' rel='stylesheet' type='text/css'>
        <title>| vehiculos | Bases de Datos 1 | 2016 | Grupo No. 6 Seccion "A"</title>
    </head>
    <body class="fondo fuente">
        <nav class="fondo-rojo  padding-largo text-center">
		<ul class="nolista ">
			<li class="col-md-3 inline-block "> <a class="blanco" href="envios.jsp">Envíos</a>  </li>
			<li class="col-md-3 inline-block"> <a class="blanco" href="entregas.jsp">Entregas </a> </li>
			<li class="col-md-3 inline-block"> <a  class="blanco"href="rutas.jsp">Rutas</a> </li>
		</ul>
	</nav>
        <div class="col-md-6 center-block quitar-float text-center   fuente"> 

		
                <p class="Cabin-Sketch blanco"> Ingresar Los Datos Del Envio </p>
                <form action="pruebaVEHICULO" method="post">
                    <p><input type="text" name="numeroFactura" id="numeroFactura" placeholder="numeroFactura"> </p>
                    <p><input type="text" name="fecha" id="fecha" placeholder="id_envio"> </p>
                    <p><input type="text" name="cliente" id="cliente" placeholder="cliente"> </p>
                    <p><input type="text" name="direccion" id="direccion" placeholder="direccion"> </p>
                    <p><input type="text" name="productos" id="productos" placeholder="productos"> </p>
                    <p><input type="submit" name="Entrar" id="Entrar" value="Entrar"/></p>
                    <input type="button" value="Saluda" onclick = "Saluda()"/>
                </form>
		<nav class="espacio-arriba"  >
			<a class="blanco espacio-derecha" href="https://github.com/naorellana/DB1-grupo6-2016" >| GitHub |</a>
			<a class="blanco espacio-derecha"href="http://db1umg2016.hol.es/">| Documentacion |</a>
			<a class="blanco espacio-derecha" href="proyectos.html">| Descargas |</a>
                        <p class="blanco espacio-derecha">| Escríbenos a:<a class="blanco" href="mailto:db1umgsjp@gmail.com"> db1umgsjp@gmail.com | </a></p>
		</nav>
                
	</div>
    </body>
</html>
