<%-- 
    Document   : alterar
    Created on : 28/12/2020, 17:46:24
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
	<link rel="stylesheet" href="styles/style-agendams-formulario-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<script src="scripts/script-agendams-validacao-js.js"></script>
	<script src="scripts/script-agendams-mascara-js.js"></script>
	<script src="scripts/script-agendams-global-js.js"></script>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Alterar</title>
    </head>                                     
    <body onload="ajustaContainer();" onresize="redimencionaContainer();" >
	<div id="container">
            <div id="header">
		<div id="link_topo">
                    <a href="sair.html">Logout</a><a href="conta.html">Conta</a>
		</div>
		<img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
		<div id="formulario">
                    <h1>Alterar</h1>
                    <h3>Alterar Contato</h3>
                    <form id="form1" class="form" method="post" action="Alterar?idContato=${idContato}" onSubmit="return validaFormulario()">
                        <label for="nome" class="contato">Nome:</label>
                        <input type="text" name="Nome" id="nome" class="contato" maxlength="100" value="${Nome}" />
                        <label for="cpf" class="contato">CPF:</label>
                        <input type="text" name="CPF" id="cpf" class="contato" onchange="mascaraCpf();"  maxlength="15" value="${CPF}"/>
                        <label for="telefone" class="contato">Telefone:</label>
                        <input type="text" name="Telefone" id="telefone" class="contato" onchange="mascaraTelefone();" maxlength="13" value="${Telefone}"/>
                        <label for="celular" class="contato">Celular:</label>
                        <input type="text" name="Celular" id="celular" class="contato" onchange="mascaraCelular();" maxlength="14" value="${Celular}"/>
                        <label for="email" class="contato">E-email:</label>
                        <input type="text" name="Email" id="email" class="contato" maxlength="100" value="${Email}"/>
                        <label for="site" class="contato">Site:</label>
                        <input type="text" name="Site" id="site" class="contato" maxlength="100" value="${Site}"/><br />
                        <input type="submit" name="Alterar" id="alterar" class="btn-contato" value="Alterar" /> &nbsp 
                        <input type="button" name="Voltar" id="voltar" class="btn-contato" value="Voltar" onclick="location. href='Contatos'"/>
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
