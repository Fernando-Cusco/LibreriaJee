package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Categoria;

public class CategoriaDao {

	@Inject
	private EntityManager em;
	
	public void crearCategoria(Categoria categoria) {
		em.persist(categoria);
	}
	
	public Categoria buscar(int id) {
		return em.find(Categoria.class, id);
	}
	
	public Categoria buscarCategoria(String nombre) {
		String jpql = "SELECT c FROM Categoria c JOIN FETCH c where a.nombre = :nombre";
		Query query = em.createQuery(jpql, Categoria.class);
		query.setParameter("nombre", nombre);
		Categoria categoria = (Categoria) query.getSingleResult();
		return categoria;
	}
	
	public List<Categoria> mostrarCategorias() {
		String jpql = "SELECT a FROM Categoria a";
		Query query = em.createQuery(jpql, Categoria.class);
		List<Categoria> categorias = query.getResultList();
		return categorias;
	}
	
	
}
