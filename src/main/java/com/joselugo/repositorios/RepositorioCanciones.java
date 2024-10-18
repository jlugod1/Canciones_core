package com.joselugo.repositorios;

import java.util.List;
//import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joselugo.modelos.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long>{



/*SELECT *
 * FROM cancion;
 */
List<Cancion> findAll();

//query parametedo usando opcional
//Optional<Cancion> findById(Long id);
//long save(); ---> INSERT INTO peliculas
//VALUES()

}
 