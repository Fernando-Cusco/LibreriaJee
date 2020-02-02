package vista;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;

import modelo.Autor;
import modelo.Libro;
import modelo.LibroAutor;
import negocio.AutorON;
import negocio.LibroON;

@ManagedBean
@ViewScoped
public class LibroMB {

	// private Part file;
	private Libro libro;

	private List<Libro> libros;

	@Inject
	private LibroON gestion;

	@Inject
	private AutorON autoron;

	private Part file;

	@PostConstruct
	public void init() {
		libro = new Libro();
		// libro.agregarAuto(new LibroAutor());
		listar();

	}

	public String crearLibro() {

		try {
			if (file != null) {
				int size = (int) file.getSize();
				byte[] foto;
				if (size > 0) {
					foto = new byte[size];
					file.getInputStream().read(foto);
					libro.setPortada(foto);
				}
				// libro.setPortada(file.getInputstream().toString());
				gestion.crearLibro(libro);
				libro = null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String agregarAutor() {
		libro.agregarAuto(new LibroAutor());
		return null;
	}

	public void listar() {
		this.libros = this.gestion.mostrarLibros();
	}

	public String buscarAutor(LibroAutor la) {
		try {
			Autor a = this.autoron.buscar(la.getIdBuscar());
			System.out.println(a.toString() + " Autor");
			la.setAutor(a);
		} catch (Exception e) {
			System.out.println("ERRORRRR: " + e.getMessage());
		}
		return null;
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

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

}
