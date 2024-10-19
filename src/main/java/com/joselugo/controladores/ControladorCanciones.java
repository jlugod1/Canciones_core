package com.joselugo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.joselugo.modelos.Artista;
import com.joselugo.modelos.Cancion;
import com.joselugo.servicios.ServicioArtistas;
import com.joselugo.servicios.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {
	 @Autowired
	    private final ServicioCanciones servicioCanciones;
	    
	    @Autowired
	    private final ServicioArtistas servicioArtistas; 

	    
	    public ControladorCanciones(ServicioCanciones servicioCanciones, ServicioArtistas servicioArtistas) {
	        this.servicioCanciones = servicioCanciones;
	        this.servicioArtistas = servicioArtistas;
	    }

  @GetMapping("/canciones")
  
  public String desplegarCanciones(Model modelo) {
	  List<Cancion> canciones = this.servicioCanciones.obtenerTodasLasCanciones();
	  modelo.addAttribute("canciones", canciones);
	   
	  return "canciones.jsp";
	  
	  
  }
  
@GetMapping("/artistas")
  
  public String desplegarArtistas(Model modelo) {
	  List<Artista> artistas = this.servicioArtistas.obtenerTodosLosArtistas();
	  modelo.addAttribute("artistas", artistas);
	   
	  return "artistas.jsp";
	  
	  
  }




  
  @GetMapping("/canciones/detalle/{idCancion}")
  public String desplegarDetalleCancion(@PathVariable Long idCancion, Model model) {
      Cancion cancion = this.servicioCanciones.obtenerCancionPorId(idCancion);
      model.addAttribute("artista", cancion.getArtista());
      
      model.addAttribute("cancion", cancion);
      return "detalleCancion.jsp";
  }
  
  @GetMapping("/artistas/detalle/{idArtista}")
  public String desplegarDetalleArtista(@PathVariable Long idArtista, Model model) {
      Artista artista= this.servicioArtistas.obtenerArtistaPorId(idArtista);
      model.addAttribute("artista", artista);
      return "detalleArtista.jsp";
  }
  
  @GetMapping("/artistas/formulario/agregar")
  public String formularioAgregarArtista(@ModelAttribute Artista artista ){
  return "agregarArtista.jsp";
  
  
  }
  
  @PostMapping("/artistas/procesa/agregar")
  public  String procesarAgregarArtista(@Valid  @ModelAttribute Artista artista,
		                                 BindingResult validaciones)   {
	  
	  if (validaciones.hasErrors()) {
		  return "agregarArtista.jsp"; }
	  this.servicioArtistas.agregarArtista(artista);
	  return "redirect:/artistas";
	  
  }
  
  @GetMapping("/canciones/formulario/agregar")
  public String formularioAgregarCanciones(@ModelAttribute Cancion cancion, Model model){
	  List<Artista> artistas = servicioArtistas.obtenerTodosLosArtistas();
	  model.addAttribute("artistas", artistas);
	  return "agregarCancion.jsp";
  
  }
  
  @PostMapping("/canciones/procesa/agregar")
  public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion,
                                       BindingResult validaciones, 
                                       @RequestParam("artistaId") Long artistaId,  
                                       Model modelo) {
      if (validaciones.hasErrors()) {
          return "agregarCancion.jsp";
      }

      // Obtener el artista por ID y asociarlo a la canción
      Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
      cancion.setArtista(artista);  // Estás usando el objeto Artista, no artistaId directamente

      
      servicioCanciones.agregarCancion(cancion);
      return "redirect:/canciones";
  }

  @GetMapping("/canciones/formulario/editar/{idCancion}")
  public String formularioEditarCancion(@ModelAttribute("cancion")Cancion cancion, 
		                                                 @PathVariable("idCancion")Long idCancion,
		                                                 Model modelo  ) {
	  
	
	  
Cancion cancionActual = this.servicioCanciones.obtenerCancionPorId(idCancion);  
modelo.addAttribute("cancion", cancionActual);


return "editarCancion.jsp";
  }
  
  
  @PutMapping("/canciones/procesa/editar/{idCancion}")
  public String procesarEditarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
		  								BindingResult validaciones,
		  								@PathVariable("idCancion") long idCancion ) {
	  
	  if (validaciones.hasErrors()) {
		  return "editarCancion.jsp"; }
	 cancion.setId(idCancion);
	 this.servicioCanciones.actualizarCancion(cancion);
	  return "redirect:/canciones";  
  }
  
  @DeleteMapping("/canciones/eliminar/{idCancion}")
  public String procesarEliminarCancion(@PathVariable("idCancion")Long idCancion ) {
	  this.servicioCanciones.eliminarCancion(idCancion);
	  
	  
	 return "redirect:/canciones";
  }
  
}
  
  

  
  
  
  

