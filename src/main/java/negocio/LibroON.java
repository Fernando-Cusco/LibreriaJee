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
	
	public Libro buscar(int id) {
		return librodao.buscar(id);
	}
	
	public Libro buscarLibro(Integer id) {
		return librodao.buscarLibro(id);
	}
	
	public List<Libro> buscarSimilar(String key) {
		return librodao.buscarSimilar(key);
	}
	
}
