package dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Direccion;
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
	
	public Usuario search(int id) {
		String jpql = "SELECT u FROM Usuario u JOIN FETCH u.direcciones where u.id = :id";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("id", id);
		Usuario usuario = (Usuario) query.getSingleResult();
		List<Direccion> direcciones = new ArrayList<>();
		for (Direccion direccion : usuario.getDirecciones()) {
			direcciones.add(direccion);
		}
		return usuario;
	}
	
	public void actualizarUsuaurio(Usuario usuario) {
		if(buscar(usuario.getId()) == null) {
			em.merge(usuario);
		}
		
	}
	
	public Usuario login(String correo, String password) {
		String jpql = "SELECT u FROM Usuario u where u.correo = :correo and u.password = :password";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("correo", correo);
		query.setParameter("password", password);
		Usuario usuario = (Usuario) query.getSingleResult();
		
		return usuario;
	}
	
	public Usuario obtenerDirecciones(int id) {
		String jpql = "SELECT u FROM Usuario u JOIN FETCH u.direcciones where u.id = :id";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("id", id);
		Usuario u = (Usuario) query.getSingleResult();
		List<Direccion> direcciones = new ArrayList<>();
		for(Direccion d: u.getDirecciones()) {
			direcciones.add(d);
		}
		
		
		return u;
	}
	
	public Usuario tarjetas(int id) {
		String jpql = "SELECT u FROM Usuario u JOIN FETCH u.tarjetas where u.id = :id";
		Query query = em.createQuery(jpql, Usuario.class);
		query.setParameter("id", id);
		Usuario u = (Usuario) query.getSingleResult();
		List<Tarjeta> tarjetas = new ArrayList<>();
		for(Tarjeta t: u.getTarjetas()) {
			tarjetas.add(t);
		}
		
		return u;
	}

	
	
	

	
}


