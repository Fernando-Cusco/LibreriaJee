package restful;




import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.Libro;
import modelo.Usuario;
import modelo.Voto;
import modelotmp.UsuarioTMP;
import negocio.LibroON;
import negocio.UsuarioON;
import negocio.VotoON;

@Path("/usuario")
public class UsuarioService {
	
	@Inject
	private UsuarioON user;
	@Inject
	private LibroON libs;
	@Inject
	private VotoON vots;
	
	
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
		Libro l = libs.buscarLibro(idl);
		Usuario u = user.buscar(idu);
		System.out.println("Usuario: "+u.toString());
		System.out.println("Libro: "+l.toString());
		Voto v = new Voto();
		//v.agregarLibro(l);
		//v.agregarUsuario(u);
		vots.realizarVoto(v);
		
	}
	
	
	
}
