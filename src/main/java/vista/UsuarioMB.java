package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import modelo.Direccion;
import modelo.Usuario;
import negocio.UsuarioON;

@ManagedBean
@ViewScoped
public class UsuarioMB {

	private boolean updated;
	private String id;

	private Usuario usuario;
	
	
	
	@Inject
	private UsuarioON gestion;

	private List<Usuario> usuarios;
	

	@PostConstruct
	public void init() {
		
		usuario = new Usuario();
		
		updated = false;
		
		usuario.agregarDireccion(new Direccion(usuario));
		listar();
	}

	public String crearUsuario() {
		System.out.println("ACUTLIZAR "+updated);
		if (updated) {
			System.out.println(updated);
			gestion.actualizarUsuaurio(usuario);
		} else {
			gestion.crearUsuario(usuario);
		}
		usuario = null;

		return null;
	}

	public String agregarDireccion() {
		usuario.agregarDireccion(new Direccion(usuario));
		return null;
	}

	public void listar() {
		usuarios = gestion.mostrarUsarios();
	}

	public String eliminar(int id) {
		gestion.eliminar(id);
		listar();
		return null;
	}

	public String redirect(Usuario usuario) {
		return "usuarios?faces-redirect=true&id=" + usuario.getId()+"&updated=true";
	}

	public void buscar() {
		if (id != null) {
			usuario = gestion.buscar(Integer.parseInt(id));
		} else {
			return;
		}
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isUpdated() {
		return updated;
	}

	public void setUpdated(boolean updated) {
		this.updated = updated;
	}


	public UsuarioON getGestion() {
		return gestion;
	}

	public void setGestion(UsuarioON gestion) {
		this.gestion = gestion;
	}
	
	
	
}
