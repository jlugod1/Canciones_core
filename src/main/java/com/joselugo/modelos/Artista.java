package com.joselugo.modelos;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;


@Entity
@Table(name="artistas")
public class Artista {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private Long id;
	
	
	@Size(min=3, message="Por favor proporciona tu nombre.")
	private String nombre;
	
	
	
	private String apellido;
	
	
	@Size(min=10, max= 200, message="Por favor proporciona tu bibliografia.")
	private String bibliografia;
	
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)//dentro del parentesis se indica que es de tipo fecha 
	@Column(name="fecha_actualizacion")//colu lo usamos cuando tienes mas de dos palabras en nombre
	private Date fechaActualizacion; //creamos el metodo

	
	@OneToMany(mappedBy="artista", cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
		
	private List<Cancion> canciones;
	
	
	public Artista() {}
	
	public Long getId() {
	return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getBibliografia() {
			return bibliografia;
		}
		public void setBibliografia(String bibliografia) {
			this.bibliografia = bibliografia;
		}
		public Date getFechaCreacion() {
			return fechaCreacion;
		}
		public void setFechaCreacion(Date fechaCreacion) {
			this.fechaCreacion = fechaCreacion;
		}
		public Date getFechaActualizacion() {
			return fechaActualizacion;
		}
		public void setFechaActualizacion(Date fechaActualizacion) {
			this.fechaActualizacion = fechaActualizacion;
		}
		public List<Cancion> getCanciones() {
			return canciones;
		}
		public void setCanciones(List<Cancion> canciones) {
			this.canciones = canciones;
		}
		
		@PrePersist
		protected void onCreate() {
			this.fechaCreacion = new Date();
			this.fechaActualizacion = this.fechaCreacion;//estsa anotacion es pra automatizar el reguistro de actualizacion y creacion
		}
		
		@PreUpdate
		protected void onUpdate() {
			this.fechaActualizacion = new Date();//esto es para que cuando se actualiza un contenido automaticamente crea la fecha
		}// estos ultimos cumplen la funcion del now() y el now() on update now()
		
		
		
		}