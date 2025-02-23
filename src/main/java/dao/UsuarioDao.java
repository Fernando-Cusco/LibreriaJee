package dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Compra;
import modelo.Direccion;
import modelo.Tarjeta;
import modelo.Usuario;
import modelo.Voto;

public class UsuarioDao {
	
	@Inject
	private EntityManager em;
	
	public void agregarUsuario(Usuario usuario) {
		em.persist(usuario);
	}
	
	public List<Object[]> listarUsuarios() {
		List<Object[]> id = new ArrayList<>();
		String sql = "SELECT usu.id, usu.nombres FROM usuarios usu";
		Query query = em.createNativeQuery(sql);
		id = query.getResultList();
		return id;
	}
	
	public List<Usuario> mostrarUsuarios() {
		String jqpl = "SELECT u FROM Usuario u";
		Query query = em.createQuery(jqpl, Usuario.class);
		List<Usuario> usuarios = query.getResultList();
		for (Usuario usuario : usuarios) {
			usuario.getDirecciones().size();
//			usuario.setCompartidosEnviados(null);
//			usuario.setCompartidosRecibidos(null);
//			usuario.setCompras(null);
//			usuario.setTarjetas(null);
			
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
	
	public List<Compra> misCompras(int id) {
		String jpql = "SELECT c FROM Compra c JOIN FETCH c.detalles  where c.usuario.id = :id";
		Query query = em.createQuery(jpql, Compra.class);
		query.setParameter("id", id);
		List<Compra> compras = query.getResultList();
		for (int i = 0; i < compras.size(); i++) {
			compras.get(i).getDetalles();
			//compras.get(i).setUsuario(null);
			
		}
		
		return compras;
	}

	
	
	

	
}


