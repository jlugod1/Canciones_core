package com.joselugo.servicios;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joselugo.modelos.Cancion;
import com.joselugo.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
   @Autowired
   private final RepositorioCanciones repositorioCanciones;
   
   public ServicioCanciones( RepositorioCanciones repositorioCanciones) {
   this.repositorioCanciones = repositorioCanciones;

   
   }
   
   public List<Cancion> obtenerTodasLasCanciones(){
	 return this.repositorioCanciones.findAll();
	   
	   
	   
   }
     //otro metodo para conseguir cancion por id 
   /*public Cancion obtenerCancionPorId(Long id) {
       Optional<Cancion> cancion = repositorioCanciones.findById(id);
       
       if (cancion.isPresent() ) {
           return cancion.get(); // Devuelve la canción si esta
       else {
           System.out.println("Canción no encontrada con ID: " + id);
           return null; // Devuelve null si no se encuentra
       }
   }*/
		   
// Método explicado en el codingdojo para obtener una canción por su ID
   public Cancion obtenerCancionPorId(Long id) {
       return repositorioCanciones.findById(id).orElse(null); // Si no la encuentra, regresa null
   
   }
   
   public Cancion agregarCancion(Cancion nuevaCancion) {
	   return this.repositorioCanciones.save(nuevaCancion);
	   
   }
   public Cancion actualizarCancion(Cancion cancionActual) {
	   return this.repositorioCanciones.save(cancionActual);
	   
   }
   public void eliminarCancion(Long idLong) {
	   this.repositorioCanciones.deleteById(idLong);
	   
   }
   public void actualizaCancion(Cancion cancion) {
	   
	   repositorioCanciones.save(cancion); 
	}
}
