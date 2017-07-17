<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tópico</title>
    </head>
    <body>
        <h3>Título:  ${topico.titulo} - tópico criado por ${topico.usuario.nome}</h3>
        <p>Conteúdo: ${topico.conteudo}</p>
    </body>
</html>
