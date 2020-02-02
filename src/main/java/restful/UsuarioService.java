package restful;




import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelo.Direccion;
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
		Usuario use = new Usuario();
		UsuarioTMP u = new UsuarioTMP();
		try {
			use = user.login(usuario.getCorreo(), usuario.getPassword());
			u.setId(use.getId());
			u.setCorreo(use.getCorreo());
			u.setPassword(use.getPassword());
		} catch (Exception e) {
			u.setCorreo(e.getMessage());
		}
		return u;
	}
	
	@POST
	@Path("/registro")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta registrar(UsuarioTMP u) {
		System.out.println("LLEGANDO ESTOS DAOTS "+u.toString());
		Respuesta r = new Respuesta();
		try {
			Usuario usuario = new Usuario();
			usuario.setNombres(u.getNombres());
			usuario.setFecha(u.getFecha());
			usuario.setCorreo(u.getCorreo());
			usuario.setPassword(u.getPassword());
			usuario.setTelefono(u.getTelefono());
			List<Direccion> direcciones = u.getDirecciones();
			for (Direccion direccion : direcciones) {
				Direccion d = new Direccion();
				d.setCiudad(direccion.getCiudad());
				d.setCalles(direccion.getCalles());
				d.setUsuario(usuario);
				usuario.agregarDireccion(d);
			}
			user.crearUsuario(usuario);
			r.setId(200);
			r.setMensaje("Usuario: "+usuario.getNombres()+" creado exitosamente");
		} catch (Exception e) {
			
			r.setId(400);
			r.setMensaje("Error "+e.getMessage());
			e.printStackTrace();
			
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
