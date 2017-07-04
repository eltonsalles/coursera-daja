<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tradutor</title>
    </head>
    <body>
        <h4><c:if test="${erro eq true}">Informe uma palavra!</c:if></h4>
        <h4><c:if test="${palavraNaoEncontrada eq true}">A tradução da palavra <c:out value="${param.palavra}"></c:out> não foi encontrada!</c:if></h4>
        <h4><c:if test="${not empty traducao}">A tradução da palavra <c:out value="${param.palavra}"></c:out> é <c:out value="${traducao}"></c:out></c:if></h4>
        <a href="/Tradutor">Voltar</a>
    </body>
</html>
