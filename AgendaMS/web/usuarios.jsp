<%-- 
    Document   : usuarios
    Created on : 29/12/2020, 22:23:56
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    if(request.getSession().getAttribute("loginAtivo") == null || request.getSession().getAttribute("loginAtivo") == ""){
       response.sendRedirect("Start");
    }
    if(request.getSession().getAttribute("contaAtiva") != null)
        request.setAttribute("contaUsuario", request.getSession().getAttribute("contaAtiva").equals("Administrativa"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="img/agendams-ico-small.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-global-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-grid-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Usuários</title>
    </head>
    <body onload="ajustaContainer();" onresize="redimencionaContainer();" >
        <div id="container">
            <div id="header">
                <div id="link_topo">
                    <a href="Sair">Logout</a><a href="Conta">Conta</a>
                </div>
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <ul class="nav" id="menu">
                    <li><a href="Home">Home</a></li>
                    <li><a href="Contatos">Contatos</a></li>
                    <li class="selected"><a href="Usuarios">Usuarios</a></li>
                    <c:if test="${contaUsuario == true}"><li><a href="Adm">Administração</a></li></c:if>
                </ul>
                <br />
                <div id="formulario">
                    <h1>Usuarios</h1>
                    <h3>Lista de Usuarios</h3>
                    <div id="tabela">
                        <table>
                            <caption>Usuários</caption>
                            <thead>
                                <tr>
                                    <th class="usuario-coluna1">Nome</th>
                                    <th class="usuario-coluna2">Login</th>
                                    <th class="usuario-coluna3">Tipo de Conta</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${lista}" var="usuarios">
                                    <tr>
                                        <td class="usuario-coluna1">${usuarios.get(0)}</td>
                                        <td class="usuario-coluna2">${usuarios.get(1)}</td>
                                        <td class="usuario-coluna3">${usuarios.get(2)}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <div id="footer">
                <small>Agenda MS - 2018</small><br />
                <small>Desenvolvido por: Marcos Willian de Souza</small>
            </div>
        </div>
    </body>
</html>
