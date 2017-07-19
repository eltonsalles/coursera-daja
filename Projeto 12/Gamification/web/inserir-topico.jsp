<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inserir Tópico</title>
    </head>
    <body>
        <c:if test="${not empty erro}">
            <h1>Erro</h1>
            <h3>${erro}</h3>
        </c:if>
        <h1>Inserir Tópico</h1>
        <form action="inserirTopico" method="post">
            <label>Título: </label>
            <input type="text" name="titulo" maxlength="255" required /><br>
            <label>Conteúdo: </label><br>
            <textarea name="conteudo" cols="50" rows="5"></textarea><br>
            <input type="submit" value="Enviar" />
        </form>
        <br>
        <a href="topico">Voltar para tópicos</a>
    </body>
</html>
