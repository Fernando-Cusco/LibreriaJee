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
		// JOIN FETCH l.autores a
		String jpql = "SELECT l FROM Libro l";
		Query query = em.createQuery(jpql, Libro.class);
		List<Libro> libros = query.getResultList();
		for (Libro libro : libros) {
			libro.getAutores().size();
		}
		return libros;
	}
	
	public Libro buscar(int id) {
		return em.find(Libro.class, id);
	}
	
	public Libro buscarLibro(int id) {
		String jpql = "SELECT l FROM Libro l where l.id = :id";
		Query query = em.createQuery(jpql, Libro.class);
		query.setParameter("id", id);
		Libro libro = (Libro) query.getSingleResult();
		for(int i =0; i < libro.getAutores().size(); i++) {
			libro.getAutores().get(i).getAutor().getId();
		}
		
		return libro;
	}
	
	public List<Libro> buscarSimilar(String key) {
		System.out.println(key+" VALORES");
		String jpql = "SELECT l FROM Libro l where l.titulo like :key or l.descripcion like :key";
		Query query = em.createQuery(jpql, Libro.class);
		query.setParameter("key", "%"+key+"%");
		List<Libro> libros = query.getResultList();
		for (Libro libro : libros) {
			libro.getAutores().size();
		}
		return libros;
	}
}
//String jpql = "SELECT a FROM Alumnos a WHERE a.nota_matematicas > ?1 AND a.nombre like = ?2"