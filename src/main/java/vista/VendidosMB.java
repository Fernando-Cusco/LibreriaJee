package vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Libro;
import modelotmp.LibroTMP;
import negocio.LibroON;

@ManagedBean
public class VendidosMB {

	@Inject
	private LibroON libroON;

	private Libro libro;

	private List<Libro> libros;
	private List<LibroTMP> tmp;

	@PostConstruct
	public void init() {
		libro = new Libro();
		tmp = new ArrayList<LibroTMP>();
		libros = new ArrayList<>();
		cargar();
	}

	public void cargar() {
		tmp = libroON.librosMasVendidos();
		for (LibroTMP l : tmp) {
			libro = libroON.buscar(l.getId());
			libros.add(libro);
		}
		System.out.println("Size "+libros.size());
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

	public List<LibroTMP> getTmp() {
		return tmp;
	}

	public void setTmp(List<LibroTMP> tmp) {
		this.tmp = tmp;
	}

}
