<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>T�pico</title>
    </head>
    <body>
        <h1>T�pico</h1>
        <h3>T�tulo:  ${topico.titulo} - t�pico criado por ${topico.usuario.nome}</h3>
        <p>Conte�do: ${topico.conteudo}</p>
        <h3>Coment�rios</h3>
        <c:forEach items="${comentarios}" var="comentario">
            <p><strong>${comentario.usuario.nome}: </strong>${comentario.comentario}</p>
        </c:forEach>
        <br>
        <c:if test="${not empty erro}">
            <h3>Erro</h3>
            <h3>${erro}</h3>
        </c:if>
        <c:remove var="erro"></c:remove>
        <form action="comentario" method="post">
            <input type="hidden" name="id_topico" value="${topico.id}" />
            <label>Escreva seu coment�rio:</label><br>
            <textarea name="comentario" cols="50" rows="5"></textarea><br>
            <input type="submit" value="Adicionar Coment�rio" />
        </form>
        <br>
        <a href="topico">Voltar para t�picos</a>
    </body>
</html>
