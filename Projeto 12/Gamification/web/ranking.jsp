<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Ranking</title>
    </head>
    <body>
        <h1>Ranking</h1>
        <table>
            <thead>
                <tr>
                    <td>Nome</td>
                    <td>Login</td>
                    <td>Pontos</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ranking}" var="usuario">
                    <tr>
                        <td>${usuario.nome}</td>
                        <td>${usuario.login}</td>
                        <td>${usuario.pontos}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="topico">Voltar para t�picos</a>
    </body>
</html>
