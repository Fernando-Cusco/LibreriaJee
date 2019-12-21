package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Direccion;
import modelo.Usuario;
import negocio.UsuarioON;

@ManagedBean
public class UsuarioMB {
	
	private Usuario usuario;
	
	@Inject
	private UsuarioON gestion;
	
	private List<Usuario> usuarios;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		listar();
		usuario.agregarDireccion(new Direccion());
	}
	
	public String crearUsuario() {
		gestion.crearUsuario(usuario);
		usuario = null;
		return null;
	}
	
	public String agregarDireccion() {
		this.usuario.agregarDireccion(new Direccion());
		return null;
	}
	
	public void listar() {
		usuarios = gestion.mostrarUsarios();
	}
	
	
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
