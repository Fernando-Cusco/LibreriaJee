package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.UsuarioDao;
import modelo.Usuario;

@Stateless
public class UsuarioON {
	
	@Inject
	private UsuarioDao dao;
	
	public void crearUsuario(Usuario usuario) {
		this.dao.agregarUsuario(usuario);
	}
	
	public List<Usuario> mostrarUsarios() {
		return dao.mostrarUsuarios();
	}
	
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	public Usuario buscar(int id) {
		return dao.search(id);
	}
	
	public void actualizarUsuaurio(Usuario usuario) {
		dao.actualizarUsuaurio(usuario);
	}
	
	public Usuario login(String correo, String password) {
		return dao.login(correo, password);
	}
	
	public Usuario obtenerDirecciones(int id) {
		return dao.obtenerDirecciones(id);
	}
	
	public Usuario tarjetas(int id) {
		return dao.tarjetas(id);
	}
	
//	public List<Usuario> tarjetas(int id) {
//		return dao.tarjetas(id);
//	}
}
