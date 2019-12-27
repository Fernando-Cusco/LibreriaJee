package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Tarjeta;
import modelo.Usuario;

public class UsuarioDao {
	
	@Inject
	private EntityManager em;
	
	public void agregarUsuario(Usuario usuario) {
		em.persist(usuario);
	}
	
	public List<Usuario> mostrarUsuarios() {
		String jqpl = "SELECT u FROM Usuario u";
		Query query = em.createQuery(jqpl, Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		for (Usuario usuario : usuarios) {
			usuario.getDirecciones().size();
		}
		return usuarios;
	}
	
	public void eliminar(int id) {
		em.remove(buscar(id));
	}
	
	public Usuario buscar(int id) {
		return em.find(Usuario.class, id);
	}
	
	public void actualizarUsuaurio(Usuario usuario) {
		em.merge(usuario);
	}
	
	public Usuario login(String correo, String password) {
		String jpql = "SELECT u FROM Usuario u where u.correo = :correo and u.password = :password";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("correo", correo);
		query.setParameter("password", password);
		Usuario usuario = (Usuario) query.getSingleResult();
		
		return usuario;
	}
	
	public void realizarVoto() {
		
	}
	
	
//	public List<Usuario> tarjetas(int id) {
//		String jpql = "SELECT t FROM Usuario u, Tarjeta t where t = :id";
//		Query query= em.createQuery(jpql, Usuario.class);
//		query.setParameter("id", id);
//		List<Usuario> tarjetas = query.getResultList();
//		return tarjetas;
//	}
	
}


