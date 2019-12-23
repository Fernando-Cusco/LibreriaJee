package restful;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import modelo.Direccion;
import modelo.Usuario;
import modelotmp.UsuarioTMP;
import negocio.UsuarioON;

@Path("/usuario")
public class UsuarioService {
	
	@Inject
	private UsuarioON user;
	
	
	@POST
	@Path("/login")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public UsuarioTMP login(Usuario usuario) {
		UsuarioTMP u = new UsuarioTMP();
		try {
			usuario = user.login(usuario.getCorreo(), usuario.getPassword());
			u.setId(usuario.getId());
			u.setCorreo(usuario.getCorreo());
			u.setPassword(usuario.getPassword());
		} catch (Exception e) {
			u = null;
		}
		return u;
	}
	
	@POST
	@Path("/registro")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta registrar(Usuario usuario) {
		System.out.println("LLEGANDO ESTOS DAOTS "+usuario.toString());
		Respuesta r = new Respuesta();
		try {
			user.crearUsuario(usuario);
			r.setId(200);
			r.setMensaje("Usuario: "+usuario.getNombres()+" creado exitosamente");
		} catch (Exception e) {
			r.setId(400);
			r.setMensaje("Error");
			
		}
		return r;
	}
	
	
}
