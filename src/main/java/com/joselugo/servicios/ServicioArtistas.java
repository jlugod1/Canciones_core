package com.joselugo.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselugo.modelos.Artista;
import com.joselugo.modelos.Cancion;
import com.joselugo.repositorios.RepositorioArtistas;


@SuppressWarnings("unused")
@Service
public class ServicioArtistas {
	 @Autowired
	   private final RepositorioArtistas repositorioArtistas;
	   
	   public ServicioArtistas( RepositorioArtistas repositorioArtistas) {
	   this.repositorioArtistas = repositorioArtistas;

	   
	   }
	   
	   public List<Artista> obtenerTodosLosArtistas(){
		 return this.repositorioArtistas.findAll();
}
	   public Artista obtenerArtistaPorId(Long id) {
	       return repositorioArtistas.findById(id).orElse(null); // Si no la encuentra, regresa null
	   
	   }
	   
	   public Artista agregarArtista(Artista nuevoArtista) {
		   return this.repositorioArtistas.save(nuevoArtista);	   
	   
	   }
	   
	   
	   
}