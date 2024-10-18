<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
   
    <title>Editar Canción</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1>Editar Canción</h1>
    </div>
    <div class="row">
        <form:form action="/canciones/procesa/editar/${cancion.id}" method="POST" modelAttribute="cancion">
            <div>
                <input type="hidden" name="_method" value="put" />
                <form:label path="titulo">Título</form:label>
                <form:input type="text" path="titulo" id="titulo" value="${cancion.titulo}" />
                <form:errors path="titulo" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="artista">Artista</form:label>
                <form:input type="text" path="artista" id="artista" value="${cancion.artista}" />
                <form:errors path="artista" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="album">Álbum</form:label>
                <form:input type="text" path="album" id="album" value="${cancion.album}" />
                <form:errors path="album" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="genero">Género</form:label>
                <form:input type="text" path="genero" id="genero" value="${cancion.genero}" />
                <form:errors path="genero" cssClass="text-danger" />
            </div>

            <div>
                <form:label path="idioma">Idioma</form:label>
                <form:input type="text" path="idioma" id="idioma" value="${cancion.idioma}" />
                <form:errors path="idioma" cssClass="text-danger" />
            </div>

            <!-- Botón submit -->
            <form:button class="btn btn-primary">Guardar cambios</form:button>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
