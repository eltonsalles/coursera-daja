<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
    </head>
    <body>
        <form action="cadastro" method="post">
            <label>Login: </label>
            <input type="text" name="login" maxlength="255" required="" /><br>
            <label>Email: </label>
            <input type="email" name="email" maxlength="255" required="" /><br>
            <label>Nome: </label>
            <input type="text" name="nome" maxlength="255" required="" /><br>
            <label>Senha: </label>
            <input type="password" name="senha1" maxlength="255" required="" /><br>
            <label>Repita a senha: </label>
            <input type="password" name="senha2" maxlength="255" required="" /><br>
            <input type="submit" value="Enviar" />
        </form>
    </body>
</html>
