package restful;


import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.Libro;
import modelo.Tarjeta;
import modelo.Usuario;
import modelo.Voto;
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
	
	@GET
	@Path("/votar/{idu:[0-9][0-9]*}/{idl:[0-9][0-9]*}")
	@Produces({MediaType.APPLICATION_JSON})
	public void votar(@PathParam("idu") int idu, @PathParam("idl") int idl) {
		Usuario u = new Usuario();
		Libro l = new Libro();
		u.agregarVoto(new Voto());
		l.agregarVoto(new Voto());
	}
	
//	@GET
//	@Path("/tarjetas/{id:[0-9][0-9]*}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Usuario> tarjetas(@QueryParam("id") int id) {
//		return user.tarjetas(id);
//	}
	
	
}
