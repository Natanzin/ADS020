<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diga olá!</title>
        <link rel="stylesheet" href="estilo.css">

    </head>
    <body>
        <%
            String nome = request.getParameter("nome");
            if (nome == null || nome.isEmpty()) {
        %>
        <h1>Olá Mundo!</h1>
        <%
        } else {
        %>
        <h1>Olá <%=nome%>!</h1>
        <%
            }
        %>
        <p>Você está acessando uma página JSP.</p>
        <hr>
        <%java.util.Date data = new java.util.Date();%> 
        <%=data%>
        <br><br>
        <a href="index.jsp">VOLTAR</a>
    </body>
</html>
