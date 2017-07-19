<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
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
        <br>
        <a href="inserirTopico">Inserir Novo Tópico</a><br>
        <a href="ranking">Ranking</a>
    </body>
</html>
