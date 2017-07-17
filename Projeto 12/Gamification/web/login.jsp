<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <c:if test="${not empty erro}">
            <h1>${erro}</h1>
        </c:if>
        <h1>Entre com as informações abaixo:</h1>
        <form action="login" method="post">
            <label>Login: </label>
            <input type="text" name="login" />
            <label>Senha: </label>
            <input type="password" name="senha" />
            <input type="submit" value="Fazer login" />
        </form>
        <p>Não é cadastrado? <a href="cadastro">Clique aqui</a></p>
    </body>
</html>
