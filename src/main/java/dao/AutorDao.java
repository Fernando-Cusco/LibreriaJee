package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Autor;

public class AutorDao {

	@Inject
	private EntityManager em;
	
	
	public void crearAutor(Autor autor) {
		em.persist(autor);
	}
	
	public Autor buscar(int id) {
		return em.find(Autor.class, id);
	}
	
	public Autor buscarAutor(String nombres) {
		String jpql = "SELECT a FROM Autor a JOIN FETCH a where a.nombres = :nombres";
		Query query = em.createQuery(jpql, Autor.class);
		query.setParameter("nombres", nombres);
		Autor autor = (Autor) query.getSingleResult();
		return autor;
	}
	
	public List<Autor> mostrarAutores() {
		String jpql = "SELECT a FROM Autor a";
		Query query = em.createQuery(jpql, Autor.class);
		List<Autor> autores = query.getResultList();
		for(Autor autor : autores) {
			//autor.getLibros().size();
		}
		return autores;
	}
	
}


