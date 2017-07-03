<%-- 
    Document   : resposta
    Created on : 03/07/2017, 16:31:37
    Author     : Elton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resposta dos Melhores Produtos</title>
    </head>
    <body>
        <h1>Os melhores produtos do tipo # ${param.produto} # são:</h1>
        <ul>
            <c:forEach var="item" items="${produtos}">
                <li>${item}</li>    
            </c:forEach>
        </ul>
    </body>
</html>
