package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libro;

public class LibroDao {
	
	@Inject
	private EntityManager em;
	
	public void crearLibro(Libro libro) {
		em.persist(libro);
	}
	
	public List<Libro> mostrarLibros() {
		String jpql = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpql, Libro.class);
		List<Libro> libros = query.getResultList();
		for (Libro libro : libros) {
			libro.getAutores().size();
		}
		return libros;
	}
}
