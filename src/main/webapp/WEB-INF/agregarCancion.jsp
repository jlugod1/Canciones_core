<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="/CSS/peliculas.css" rel="stylesheet">
    <title>Agregar Canción</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Agregar Canción</h1>
    </div>
    <div class="row">
        <form:form action="/canciones/procesa/agregar" method="POST" modelAttribute="cancion">
            <div>
                <form:label path="titulo">Título</form:label>
                <form:input type="text" path="titulo" />
                <form:errors path="titulo" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="artistaId">Seleccionar Artista</form:label> 
                <form:select path="artistaId" class="form-select">
                    <form:options items="${artistas}" itemValue="id" itemLabel="nombre" />
                </form:select>
                <form:errors path="artistaId" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="album">Álbum</form:label>
                <form:input type="text" path="album" />
                <form:errors path="album" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="genero">Género</form:label>
                <form:input type="text" path="genero" />
                <form:errors path="genero" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="idioma">Idioma</form:label>
                <form:input type="text" path="idioma" />
                <form:errors path="idioma" cssClass="text-danger" />
            </div>

            <!-- Botón submit -->
            <form:button class="btn btn-primary">Agregar canción</form:button>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
