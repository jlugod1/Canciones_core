<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>lista de canciones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Canciones disponibles</h1>
    </div>
    <div class="row">
        <ul class="list-group">
            <c:forEach items="${canciones}" var="cancion">
                <li class="list-group-item">
                    <a href="/canciones/detalle/${cancion.id}">${cancion.titulo}</a> 
                    <a href="/canciones/formulario/editar/${cancion.id}">editar</a>
                </li>
            </c:forEach>
        </ul>
        
        <a href="/canciones/formulario/agregar" class="btn btn-primary">nueva cancion</a>
    </div>
</div>
</body>
</html>