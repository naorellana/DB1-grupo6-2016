<%-- 
    Document   : formulario
    Created on : 01-oct-2016, 11:39:10
    Author     : Nery Alexis Orellana
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]> <html class="lt-ie9 lt-ie8 lt-ie7" lang="en"> <![endif]-->
<!--[if IE 7]> <html class="lt-ie9 lt-ie8" lang="en"> <![endif]-->
<!--[if IE 8]> <html class="lt-ie9" lang="en"> <![endif]-->
<html> 
        <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Registration Form</title>
  <link rel="stylesheet" href="css/form.css">
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
</head>
<body>
  <h1 class="register-title">Welcome</h1>
  <form class="register">
    <div class="register-switch">
      <input type="radio" name="sex" value="F" id="sex_f" class="register-switch-input" checked>
      <label for="sex_f" class="register-switch-label">Female</label>
      <input type="radio" name="sex" value="M" id="sex_m" class="register-switch-input">
      <label for="sex_m" class="register-switch-label">Male</label>
    </div>
    <input type="email" class="register-input" placeholder="Email address">
    <input type="password" class="register-input" placeholder="Password">
    <input type="submit" value="Create Account" class="register-button">
  </form>
</body>
</html>
    </html>>


