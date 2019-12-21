package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


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
}

