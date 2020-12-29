<%-- 
    Document   : home
    Created on : 27/12/2020, 19:39:13
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     if(request.getSession().getAttribute("loginAtivo") == null || request.getSession().getAttribute("loginAtivo") == ""){
        response.sendRedirect("Start");
     }
     else if(request.getAttribute("totalConUsuario") == null){
         response.sendRedirect("Home");
     }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/agendams-ico-small.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-global-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Home</title>
    </head>
    <body onload="ajustaContainer();" onresize="redimencionaContainer();" >
        <div id="container">
            <div id="header">
                <div id="link_topo">
                    <a href="Sair">Logout</a><a href="conta.html">Conta</a>
                </div>
                    <img id="logo" src="img/logo-agenda-ms.png" />
                </div>
                <div id="body">
                    <ul class="nav" id="menu">
                        <li class="selected"><a href="Home">Home</a></li>
                        <li><a href="Contatos">Contatos</a></li>
                        <li><a href="Usuarios">Usuarios</a></li>
                        <li><a href="Adm">Administração</a></li>
                    </ul>
                     <br />
                    <div id="formulario">
                    <h1>Home</h1>
                    <h3>Bem Vindo a Agenda MS!</h3>
                    <h5>Com a Agenda MS você pode manter seus contatos de forma facil.</h5>
                    <h4>Você tem ${totalConUsuario} Contatos Cadastrados.</h4>
                    <h4>Total de Contatos Cadastrados: ${totalContatos}</h4>
                    <h4>Total de Usuários Cadastrados: ${totalUsuarios}</h4>			
                </div>
            </div>
            <div id="footer">
                <small>Agenda MS - 2018 - 2019</small><br />
                <small>Desenvolvido por: Marcos Willian de Souza</small>
            </div>
        </div>
    </body>
</html>
