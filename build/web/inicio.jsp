<%-- 
    Document   : inicio
    Created on : 30-sep-2016, 9:49:12
    Author     : Nery Alexis Orellana
--%>

<%@page import="grupo6db1.modelo.conexionSql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<link href='https://fonts.googleapis.com/css?family=Cabin+Sketch' rel='stylesheet' type='text/css'>
        <title>GRUPO 6| DB1</title>
    </head>
    <body>
        <nav class="fondo-gris padding-largo text-center">
		<ul class="nolista ">
			<li class="col-md-3 inline-block"> <a href="#">Envíos</a>  </li>
			<li class="col-md-3 inline-block"> <a href="#">Entregas </a> </li>
			<li class="col-md-3 inline-block"> <a href="#">Rutas</a> </li>
		</ul>
	</nav>
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
        
        
        
        <div class="col-md-4 center-block quitar-float text-center quitar-arriba espacio-abajo fuente"> 
		<img src="imgs/umgLogo.png">
		<h1 class="Cabin-Sketch naranja"> Grupo 6 </h1>
		<nav >
			<a class="azul espacio-derecha" href="index.html" >Envíos</a>
			<a class="azul espacio-derecha"href="contacto.html">Entregas</a>
			<a href="proyectos.html">Rutas </a>
		</nav>
	</div>
        
        <div class="col-md-6 center-block quitar-float text-center  espacio-abajo fuente">
			<a href="https://mobile.facebook.com/alexis.orellana2?ref=bookmarks"> <img src="imgs/rs/Facebook.png" class="col-md-3 quitar-float "> </a>
			<a href="https://twitter.com/all_exis?s=09"> <img src="imgs/rs/Twitter-Bird.png" class="col-md-3 quitar-float "> </a>
			<a href="https://github.com/naorellana"> <img src="imgs/rs/Github.png" class="col-md-3 quitar-float "> </a>
			<p>Escríbeme a: <a href="mailto:alexis_oc@yahoo.es">alexis_oc@yahoo.es</a></p>
        </div>
    </body>
</html>
