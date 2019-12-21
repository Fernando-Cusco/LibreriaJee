package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.LibroDao;
import modelo.Libro;

@Stateless
public class LibroON {
	
	@Inject
	private LibroDao librodao;
	
	public void crearLibro(Libro libro) {
		this.librodao.crearLibro(libro);
	}
	
	public List<Libro> mostrarLibros() {
		return this.librodao.mostrarLibros();
	}
	
}
