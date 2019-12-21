package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Autor;
import modelo.Libro;
import modelo.LibroAutor;
import negocio.AutorON;
import negocio.LibroON;

@ManagedBean
public class LibroMB {
	
	private Libro libro;
	
	private List<Libro> libros;
	
	@Inject
	private LibroON gestion;
	
	@Inject
	private AutorON autoron;
	
	
	
	@PostConstruct
	public void init() {
		this.libro = new Libro();
		listar();
	}

	
	public String crearLibro() {
		this.gestion.crearLibro(libro);
		this.libro = null;
		return null;
	}
	public String agregarAutor() {
		this.libro.agregarAuto(new LibroAutor());
		return null;
	}
	
	
	
	public void listar() {
		this.libros = this.gestion.mostrarLibros();
	}
	
	public String buscarAutor(LibroAutor la) {
		try {
			Autor a = this.autoron.buscarAutor(la.getNombres());
			System.out.println(a.toString()+" Autor");
			la.setAutor(a);
		} catch (Exception e) {
			System.out.println("ERRORRRR: "+e.getMessage());
		}
		return "";
	}
	
	
	public List<Libro> getLibros() {
		return libros;
	}


	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}


	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

}
