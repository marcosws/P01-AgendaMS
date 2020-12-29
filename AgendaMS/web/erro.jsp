<%-- 
    Document   : erro
    Created on : 28/12/2020, 12:27:48
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getAttribute("mensagemErro") == null) {
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
        <title>AgendaMS :: Erro</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <div id="formulario">
                    <h1>${mensagemTitulo}</h1>
                    <p>${mensagemErro}</p>
                    <input type="button" name="Voltar" id="voltar" class="btn-usuario" value="Voltar" onclick="location.href='${pagina}'"/>
                </div>
            </div>
        </div>
    </body>
</html>
