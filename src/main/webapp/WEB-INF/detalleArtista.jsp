<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalle de Artista</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="container mt-5">
        <h1>Detalle de Artista</h1>
        <p><strong>Nombre:</strong> ${artista.nombre}</p> <!-- Cambiado de 'titulo' a 'nombre' -->
        <p><strong>Apellido:</strong> ${artista.apellido}</p>
        <p><strong>Bibliografía:</strong> ${artista.bibliografia}</p>

       <form action="/artistas/eliminar/${artista.id}" method="POST">
    <input type="hidden" name="_method" value="DELETE"/>
    <button class="btn btn-danger mt-3">Eliminar</button>
</form>
        <a class="btn btn-primary mt-3" href="/artistas">Volver a lista de artistas</a>
    </div>
    
    
      <a class="btn btn-primary mt-3" href="/canciones">Volver a lista de canciones</a>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-+RBeMRA1PyyLbe4/ZhM3jXk6cVfEr+DLV4j6p8ZBRa1MdA11c7WzTeqF5D/SdGqM" crossorigin="anonymous"></script>
</body>
</html>
