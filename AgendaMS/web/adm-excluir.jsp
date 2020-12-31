<%-- 
    Document   : adm-excluir
    Created on : 30/12/2020, 14:32:19
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
	<title>Agenda MS :: Adm:Excluir</title>
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
                    <h3>Excluir Usuário</h3>
                    <form id="form1" class="form" method="post" action="AdmExcluir">
                        <label class="usuario">ID: ${idUsuario}</label>
                        <input type="hidden" name="idUsuario" value="${idUsuario}">
                        <label class="usuario">Nome: ${Nome}</label>
                        <label class="usuario">Login: ${Login}</label>
                        <input type="hidden" name="Login" value="${Login}">
                        <label class="usuario">Tipo de Conta: ${tipoConta}</label>
                        <label class="usuario">Total de contatos cadastrados pelo usuário: ${totalContatos}</label><br />
                        <input type="submit" name="Excluir" id="excluir" class="btn-usuario" value="Excluir" /> &nbsp 
                        <a href="Adm">
                            <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" />
                        </a>
                    </form>
                </div>
            </div>
            <div id="footer">
                <small>Agenda MS - 2018</small><br />
                <small>Desenvolvido por: Marcos Willian de Souza</small>
            </div>
	</div>
    </body>
</html>
