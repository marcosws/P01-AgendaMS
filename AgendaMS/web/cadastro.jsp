<%-- 
    Document   : cadastro
    Created on : 25/12/2020, 16:10:43
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/agendams-ico-small.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-cadastro-css.css"/>
        <script src="scripts/script-agendams-cadastro-js.js"></script>
	<title>Agenda MS :: Nova Conta</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <div id="formulario">
                    <form id="form1" class="form" method="post" action="start.jsp" onSubmit="return validaFormulario()">
                        <label for="nome" class="usuario">Nome:</label>
                        <input type="text" name="Nome" id="nome" class="usuario" />
                        <label for="login" class="usuario">Login:</label>
                        <input type="text" name="Login" id="login" class="usuario" />
                        <label for="senha" class="usuario">Senha:</label>
                        <input type="password" name="Senha" id="senha" class="usuario" />
                        <label for="confsenha" class="usuario">Confirma Senha:</label>
                        <input type="password" name="ConfirmaSenha" id="confsenha" class="usuario" /><br />
                        <input type="submit" name="Cadastrar" id="cadastrar" class="btn-usuario" value="Cadastrar" /> &nbsp 
                        <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" onclick="location. href='start.jsp'"/>
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
