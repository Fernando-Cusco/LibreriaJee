package restful;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import modelo.Detalle;
import modelotmp.DetalleTMP;

@Path("/compras")
public class CompraService {

	
	
	@POST
	@Path("/detalles")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public void detalles(List<DetalleTMP> detalles) {
		for (DetalleTMP detalle : detalles) {
			System.out.println("Detalles: "+detalle+" Libro: "+detalle.getIdLib());
		}
	}
	
}
