<%-- 
    Document   : adm
    Created on : 30/12/2020, 14:16:01
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<link rel="stylesheet" href="styles/style-agendams-global-menu-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-grid-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Administração</title>
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
                <ul class="nav" id="menu">
                    <li><a href="Home">Home</a></li>
                    <li><a href="Contatos">Contatos</a></li>
                    <li><a href="Usuarios">Usuarios</a></li>
                    <li class="selected"><a href="Adm">Administração</a></li>
                </ul>
                <br />
                <div id="formulario">
                    <h1>Administração</h1>
                    <h3>Administração da Agenda MS</h3>
                    <form>
                        <div id="tabela">
                            <table>
                                <caption>Usuários</caption>
                                <thead>
                                    <tr>
                                        <th class="adm-usuario-coluna1">ID</th>
                                        <th class="adm-usuario-coluna2">Nome</th>
                                        <th class="adm-usuario-coluna3">Login</th>
                                        <th class="adm-usuario-coluna4">Tipo de Conta</th>
                                        <th class="adm-usuario-coluna5">Operação</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lista}" var="usuarios">
                                        <tr>
                                            <td class="adm-usuario-coluna1">${usuarios.get(0)}</td>
                                            <td class="adm-usuario-coluna2">${usuarios.get(1)}</td>
                                            <td class="adm-usuario-coluna3">${usuarios.get(2)}</td>
                                            <td class="adm-usuario-coluna4">${usuarios.get(3)}</td>
                                            <td class="adm-usuario-coluna5"> &nbsp </span><a href="AdmAlterar?idUsuario=${usuarios.get(0)}">Alterar</a> &nbsp | &nbsp <a href="AdmExcluir?idUsuario=${usuarios.get(0)}">Excluir</a><span> &nbsp | &nbsp </span><a href="AdmConsultar?idUsuario=${usuarios.get(0)}">Consultar</a> &nbsp </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
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
