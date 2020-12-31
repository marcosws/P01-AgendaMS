<%-- 
    Document   : contatos
    Created on : 28/12/2020, 17:45:07
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     if(request.getSession().getAttribute("loginAtivo") == null || request.getSession().getAttribute("loginAtivo") == ""){
        response.sendRedirect("Start");
     }
     else if(request.getAttribute("lista") == null){
         response.sendRedirect("Contatos");
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
	<link rel="stylesheet" href="styles/style-agendams-formulario-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
        <title>Agenda MS :: Contatos</title>
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
                    <li class="selected"><a href="Contatos">Contatos</a></li>
                    <li><a href="Usuarios">Usuarios</a></li>
                    <c:if test="${contaUsuario == true}"><li><a href="Adm">Administração</a></li></c:if>
                </ul>
                <br />
                <div id="formulario">
                    <h1>Contatos</h1>
                    <h3>Lista de Contatos</h3>		
                    <form>
                        <div id="tabela">
                            <table>
                                <caption>Contatos</caption>
                                <thead>
                                    <tr>
                                        <th class="contato-coluna1">ID</th>
                                        <th class="contato-coluna2">Nome</th>
                                        <th class="contato-coluna3">CPF</th>
                                        <th class="contato-coluna4">Telefone</th>
                                        <th class="contato-coluna5">Celular</th>
                                        <th class="contato-coluna6">E-Mail</th>
                                        <th class="contato-coluna7">Site</th>
                                        <th class="contato-coluna8">Operação</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${lista}" var="contatos">
                                        <tr>
                                            <td class="contato-coluna1">${contatos.getIdContato()}</td>
                                            <td class="contato-coluna2">${contatos.getNome()}</td>
                                            <td class="contato-coluna3">${contatos.getCpf()}</td>
                                            <td class="contato-coluna4">${contatos.getTelefone()}</td>
                                            <td class="contato-coluna5">${contatos.getCelular()}</td>
                                            <td class="contato-coluna6">${contatos.getEmail()}</td>
                                            <td class="contato-coluna7">${contatos.getSite()}</td>
                                            <td class="contato-coluna8"> &nbsp <a href="Alterar?idContato=${contatos.getIdContato()}">Alterar</a><span> &nbsp | &nbsp </span><a href="Excluir?idContato=${contatos.getIdContato()}">Excluir</a> &nbsp </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <br />
                        <input type="button" name="Incluir" id="incluir" class="contato" value="Incluir" onclick="location.href='Incluir'"/>
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
