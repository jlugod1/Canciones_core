<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de Canción</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <h1>Detalle de Canción</h1>
    <p>Título: ${cancion.titulo}</p>
    <p>Artista: ${cancion.artista}</p>
    <p>Álbum: ${cancion.album}</p>
    <p>Género: ${cancion.genero}</p>
    <p>Idioma: ${cancion.idioma}</p>
    <p>Fecha de Creación: ${cancion.fechaCreacion}</p>
    <p>Fecha de Actualización: ${cancion.fechaActualizacion}</p>
    
<form action="/canciones/eliminar/${cancion.id}" method="POST">
 <input type="hidden" name="_method" value="DELETE"/>
 
 <button class="btn btn-primary ">Eliminar</button>
</form>


<a class="btn btn-primary mt-3" href="/canciones">Volver a lista de canciones</a>



</body>
</html>