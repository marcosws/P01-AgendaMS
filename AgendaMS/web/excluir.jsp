<%-- 
    Document   : excluir
    Created on : 28/12/2020, 17:46:35
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
     if(request.getSession().getAttribute("loginAtivo") == null || request.getSession().getAttribute("loginAtivo") == ""){
        response.sendRedirect("Start");
     }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="icon" href="img/agendams-ico-small.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-global-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-formulario-css.css"/>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Excluir</title>
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
                <div id="formulario">
                    <h1>Excluir</h1>
                    <h3>Excluir Contato</h3>
                    <form id="form1" class="form" method="post" action="Excluir?idContato=${idContato}" >
                        <label class="contato">Nome: ${Nome}</label>
                        <input type="hidden" name="Nome" value="${Nome}">
                        <label class="contato">CPF: ${CPF}</label>
                        <input type="hidden" name="CPF" value="${CPF}">
                        <label class="contato">Telefone: ${Telefone}</label>
                        <input type="hidden" name="Telefone" value="${Telefone}">
                        <label class="contato">Celular: ${Celular}</label>
                        <input type="hidden" name="Celular" value="${Celular}">
                        <label class="contato">E-mail: ${Email}</label>
                        <input type="hidden" name="Email" value="${Email}">
                        <label class="contato">Site: ${Site}</label><br />
                        <input type="hidden" name="Site" value="${Site}">
                        <input type="submit" name="Excluir" id="excluir" class="btn-contato" value="Excluir" />
                        <a href="Contatos" >
                            <input type="button" name="Voltar" id="voltar" class="btn-contato" value="Voltar"/>
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
