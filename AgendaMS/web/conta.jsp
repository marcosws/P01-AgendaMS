<%-- 
    Document   : conta
    Created on : 30/12/2020, 14:05:36
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
	<link rel="stylesheet" href="styles/style-agendams-formulario-radio-css.css"/>
	<script src="scripts/script-agendams-formulario-radio-js.js"></script>
	<script src="scripts/script-agendams-conta-js.js"></script>
	<script src="scripts/script-agendams-common-js.js"></script>
	<title>Agenda MS :: Conta</title>
    </head>
    <body onload="ajustaContainer();" onresize="redimencionaContainer();" >
	<div id="container">
            <div id="header">
                <div id="link_topo">
                    <a href="Sair">Logout</a><a href="Home">Home</a>
                </div>
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <div id="formulario">
                    <label id="status" class="lbStatus"></label><!-- Senha Inválida! -->
                    <h1>Conta de Usuário</h1>
                    <h3>Manutenção Conta de Usuário</h3>
                    <label class="usuario">Nome: ${Nome}</label>
                    <label class="usuario">Login: ${Login}</label>
                    <br />
                    <form id="formulario1" class="form" method="post" action="Conta" onSubmit="return validaFormulario()">
                        <fieldset class="groupbox" id="groupbox1">
                            <legend>Operação:</legend>
                            <input type="radio" name="Operacao" class="radiobutton" value="AlterarNome" id="opnome" onclick="operacao();" checked>Alterar Nome</input>
                            <input type="radio" name="Operacao" class="radiobutton" value="AlterarSenha" id="opsenha"  onclick="operacao();" >Alterar Senha</input>
                            <input type="radio" name="Operacao" class="radiobutton" value="ExcluirConta" id="opexcluir"  onclick="operacao();" >Excluir Conta</input>
                        </fieldset> &nbsp 
                        <div id="form1">
                            <label for="nome" class="usuario">Nome:</label>
                            <input type="text" name="Nome" id="nome" class="usuario" value="${Nome}"/>
                            <label for="login" class="usuario">Login:</label>
                            <input type="text" name="Login" id="login" class="usuario" value="${Login}"/><br />
                            <input type="submit" name="Alterar" id="alterar" class="btn-usuario" value="Alterar" /> &nbsp 
                            <a href="Home">
                                <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" />
                            </a>
                        </div>
                        <div id="form2">
                            <label for="atualsenha" class="usuario">Senha Atual:</label>
                            <input type="password" name="SenhaAtual" id="atualsenha" class="usuario" />
                            <label for="novasenha" class="usuario">Nova Senha:</label>
                            <input type="password" name="NovaSenha" id="novasenha" class="usuario" />
                            <label for="confsenha" class="usuario">Confirma Senha:</label>
                            <input type="password" name="ConfirmaSenha" id="confsenha" class="usuario" /><br />
                            <input type="submit" name="Alterar" id="alterar" class="btn-usuario" value="Alterar" /> &nbsp 
                            <a href="Home">
                                <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" />
                            </a>
                        </div>
                        <div id="form3">
                            <br />
                            <input type="submit" name="Excluir" id="excluir" class="btn-usuario" value="Excluir" /> &nbsp 
                            <a href="Home">
                                <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" />
                            </a>
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
