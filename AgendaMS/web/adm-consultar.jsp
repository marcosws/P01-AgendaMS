<%-- 
    Document   : adm-consultar
    Created on : 30/12/2020, 14:28:38
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     if(request.getSession().getAttribute("loginAtivo") == null || request.getSession().getAttribute("loginAtivo") == ""){
        response.sendRedirect("Start");
     }
     if(!request.getSession().getAttribute("contaAtiva").equals("Administrativa")){
         response.sendRedirect("Start");
     }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/agendams-ico-small-adm.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-global-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-formulario-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Adm:Consultar</title>
    </head>
    <body onload="ajustaContainer();" onresize="redimencionaContainer();" >
	<div id="container">
            <div id="header">
                <div id="link_topo">
                    <a href="Sair">Logout</a><a href="Conta">Conta</a>
                </div>
                <img id="logo" src="img/logo-agenda-ms-adm.png" />
            </div>
            <div id="body">
                <div id="formulario">
                    <h1>Administração</h1>
                    <h3>Consulta Usuário</h3>
                    <label class="usuario">ID: ${idUsuario}</label>
                    <label class="usuario">Nome: ${Nome}</label>
                    <label class="usuario">Login: ${Login}</label>
                    <label class="usuario">Tipo de Conta: ${tipoConta}</label>
                    <label class="usuario">Total de contatos cadastrados pelo usuário: ${totalContatos}</label><br />
                    <a href="Adm">
                        <input type="button" name="Voltar" id="voltar" class="btn-contato" value="Voltar" />
                    </a>
                </div>
            </div>
            <div id="footer">
                <small>Agenda MS - 2018</small><br />
                <small>Desenvolvido por: Marcos Willian de Souza</small>
            </div>
	</div>
    </body>
</html>
