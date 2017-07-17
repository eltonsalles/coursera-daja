<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópicos</title>
    </head>
    <body>
        <h1>Tópicos</h1>
        <table>
            <thead>
                <tr>
                    <td>Título</td>
                    <td>Criador</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${topicos}" var="topico">
                    <tr>
                        <td><a href="topico?id=${topico.id}">${topico.titulo}</a></td>
                        <td>${topico.usuario.nome}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
