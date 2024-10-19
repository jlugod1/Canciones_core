<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/CSS/peliculas.css" rel="stylesheet">
    <title>Agregar artista</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Agregar artista</h1>
    </div>
    <div class="row">
        <form:form action="/artistas/procesa/agregar" method="POST" modelAttribute="artista">
            <div>
                <form:label path="nombre">Nombre:</form:label>
                <form:input type="text" path="nombre" />
                <form:errors path="nombre" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="apellido">Apellido:</form:label>
                <form:input type="text" path="apellido" />
                <form:errors path="apellido" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="bibliografia">Bibliografia:</form:label>
                <form:input type="text" path="bibliografia" />
                <form:errors path="bibliografia" cssClass="text-danger" />
            </div>

           

            <!-- Botón submit -->
            <form:button class="btn btn-primary">Agregar artista</form:button>
        </form:form>
    </div>
    
    
     <a class="btn btn-primary mt-3" href="/canciones">Lista de canciones</a>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
