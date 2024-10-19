package com.joselugo.repositorios;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joselugo.modelos.Artista;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long>{



/*SELECT *
 * FROM ARTISTAS;
 */
List<Artista> findAll();



//query parametedo usando opcional
//Optional<Cancion> findById(Long id);
//long save(); ---> INSERT INTO peliculas
//VALUES()

}