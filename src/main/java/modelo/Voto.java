package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import javax.persistence.Table;

@Entity
@Table(name = "votos")
public class Voto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
//	@OneToOne(mappedBy = "voto")
//	private Usuario usuario;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Libro> libros;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private List<Usuario> usuarios;
	
	//buscar el id que viene de ionic 
	
	
	public void agregarLibro(Libro l) {
		if(libros == null) {
			libros = new ArrayList<Libro>();
		}
		libros.add(l);
	}
	
	public void agregarUsuario(Usuario u) {
		if(usuarios == null) {
			usuarios = new ArrayList<Usuario>();
		}
		usuarios.add(u);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
}
