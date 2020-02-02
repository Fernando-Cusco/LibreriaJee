package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Libro;
import negocio.LibroON;

@ManagedBean
public class VendidosMB {

	@Inject
	private LibroON libroON;

	private Libro libro;

	private List<Libro> libros;
	
	

	@PostConstruct
	public void init() {
		
		libro = new Libro();
		
		
		
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	

	
}
