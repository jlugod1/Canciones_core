package com.joselugo.modelos;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="canciones")
public class Cancion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	
	private Long id;
	
	
	@Size(min=5, message="Por favor proporciona tu titulo.")
	private String titulo;
	
	
	@Size(min=3, message="Por favor proporciona el album.")
	private String album;
	
	
	@Size(min=3, message="Por favor proporciona el artista.")
	private String artista;
	
	
	@Size(min=3, message="Por favor proporciona el genero.")
	private String genero;
	@Size(min=3, message="Por favor proporciona tu idioma.")
	private String idioma;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_creacion")
	private Date fechaCreacion;
	
	@Temporal(TemporalType.DATE)//dentro del parentesis se indica que es de tipo fecha 
	@Column(name="fecha_actualizacion")//colu lo usamos cuando tienes mas de dos palabras en nombre
	private Date fechaActualizacion; //creamos el metodo

	public Cancion() {}
	
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
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
