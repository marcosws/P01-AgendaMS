<%-- 
    Document   : mensagem
    Created on : 28/12/2020, 14:26:45
    Author     : Marcos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if(request.getAttribute("mensagemStatus") == null) {
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
        <style>
            #logar{
                border: none;
                width: 80px;
                height: 30px;
                background-color: rgb(112,146,190);
                color: #ffffff;
            }
        </style>
        <title>AgendaMS :: Mensagem</title>
    </head>
    <body>
        <div id="container">
            <div id="header">
                <img id="logo" src="img/logo-agenda-ms.png" />
            </div>
            <div id="body">
                <div id="formulario">
                    <h1>${mensagemTitulo}</h1>
                    <p>${mensagemStatus}</p>
                    <input type="button" name="logar" id="logar" class="btn-usuario" value="Logar" onclick="location.href='${pagina}'"/>
                </div>
            </div>
        </div>
    </body>
</html>
