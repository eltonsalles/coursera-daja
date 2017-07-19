<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Inserir T�pico</title>
    </head>
    <body>
        <c:if test="${not empty erro}">
            <h1>Erro</h1>
            <h3>${erro}</h3>
        </c:if>
        <h1>Inserir T�pico</h1>
        <form action="inserirTopico" method="post">
            <label>T�tulo: </label>
            <input type="text" name="titulo" maxlength="255" required /><br>
            <label>Conte�do: </label><br>
            <textarea name="conteudo" cols="50" rows="5"></textarea><br>
            <input type="submit" value="Enviar" />
        </form>
        <br>
        <a href="topico">Voltar para t�picos</a>
    </body>
</html>
