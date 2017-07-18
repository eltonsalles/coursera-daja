<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópico</title>
    </head>
    <body>
        <h1>Tópico</h1>
        <h3>Título:  ${topico.titulo} - tópico criado por ${topico.usuario.nome}</h3>
        <p>Conteúdo: ${topico.conteudo}</p>
        <h3>Comentários</h3>
        <c:forEach items="${comentarios}" var="comentario">
            <p><strong>${comentario.usuario.nome}: </strong>${comentario.comentario}</p>
        </c:forEach>
        <br>
        <c:if test="${not empty erro}">
            <h1>Erro</h1>
            <h3>${erro}</h3>
        </c:if>
        <form action="comentario" method="post">
            <input type="hidden" name="id_topico" value="${topico.id}" />
            <label>Escreva seu comentário:</label><br>
            <textarea name="comentario" cols="50" rows="5"></textarea><br>
            <input type="submit" value="Adicionar Comentário" />
        </form>
        <br>
        <a href="topico">Voltar para tópicos</a>
    </body>
</html>
