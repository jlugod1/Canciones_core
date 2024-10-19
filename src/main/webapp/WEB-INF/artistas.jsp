<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de artistas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>artistas disponibles</h1>
    </div>
    <div class="row">
        <ul class="list-group">
            <c:forEach items="${artistas}" var="artista">
                <li class="list-group-item">
                      <a href="/artistas/detalle/${artista.id}">${artista.nombre}</a> 
                </li>
            </c:forEach>
        </ul>
        
        <a href="/artistas/formulario/agregar" class="btn btn-primary">Agregar un Artista</a>
        
        <a href="/canciones" class="btn btn-primary mt-3">Volver a la lista de canciones</a>
    </div>
</div>
</body>
</html>