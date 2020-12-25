<%-- 
    Document   : start
    Created on : 25/12/2020, 15:11:10
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" href="img/agendams-ico-small.ico" type="image/x-icon" />
	<link rel="stylesheet" href="styles/style-agendams-start-css.css"/>
	<link rel="stylesheet" href="styles/style-agendams-global-menu-sup-css.css"/>
	<script src="scripts/script-agendams-start-js.js"></script>
	<title>Agenda MS :: Inicio</title>
    </head>
    <body>
	<div id="container">
            <div id="header">
                <div id="link_topo">
                    <a href="cadastro.html">Criar uma Conta</a>
                </div>
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <label id="status" class="lbStatus"></label> <!-- Usuário ou Senha Inválidos! -->
                <div id="formulario">
                    <form id="form1" class="form" method="post" action="home.html" onSubmit="return validaFormulario()">
                        <label for="login" class="usuario">Login:</label>
                        <input type="text" name="Login" id="login" class="usuario" />
                        <label for="senha" class="usuario">Senha:</label>
                        <input type="password" name="Senha" id="senha" class="usuario" /><br />
                        <input type="submit" name="Entrar" id="entrar" class="usuario" value="Entrar" />		
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
