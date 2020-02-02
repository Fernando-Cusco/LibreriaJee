package restful;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelotmp.CompartirTMP;
import negocio.CompartirON;

@Path("/compartir")
public class CompartirService {
	
	
	@Inject
	private CompartirON on;
	
	@POST
	@Path("/compatir")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Respuesta compartir(CompartirTMP com) {
		return on.compartir(com);
	}
	
	@GET
	@Path("/compartidos")
	@Produces({MediaType.APPLICATION_JSON})
	public List<Object> compartidos(@QueryParam("id") int id) {
		return null;
	}
	
	
}
