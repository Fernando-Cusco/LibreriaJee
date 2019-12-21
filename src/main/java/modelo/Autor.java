package modelo;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "autores")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "nombres son requeridos")
	private String nombres;
	@NotNull(message = "nacionalidad son requeridos")
	private String nacionalidad;
	@NotNull(message = "numero de publicaciones son requeridos")
	private int numeroPublicaciones;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "autlib_id")
	private List<Libro> libros;
	
	
	public void agregarLibro(Libro libro) {
		if(this.libros == null) {
			this.libros = new ArrayList<Libro>();
		}
		this.libros.add(libro);
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getNumeroPublicaciones() {
		return numeroPublicaciones;
	}
	public void setNumeroPublicaciones(int numeroPublicaciones) {
		this.numeroPublicaciones = numeroPublicaciones;
	}


	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombres=" + nombres + ", nacionalidad=" + nacionalidad + ", numeroPublicaciones="
				+ numeroPublicaciones + ", libros=" + libros + "]";
	}
	
	
	
}
