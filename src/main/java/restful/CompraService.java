package restful;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import modelotmp.DetalleCom;
//import modelo.Detalle;
import modelotmp.DetalleTMP;
import negocio.LibroON;

@Path("/compras")
public class CompraService {

	@Inject
	private LibroON libOn;
	
	@POST
	@Path("/detalles")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Double detalles(List<DetalleTMP> detalles) {
		Double subtotal = 0.0;
		List<DetalleCom> details = new ArrayList<DetalleCom>();
		for (DetalleTMP detalle : detalles) {
			DetalleCom det = new DetalleCom();
			det.setCantidad(detalle.getCantidad());
			det.setLibro(libOn.buscarLibro(detalle.getIdLib()));
			details.add(det);
		}
		for (DetalleCom detalleCom : details) {
			subtotal += detalleCom.calcularSubtotal(); 
		}
		return subtotal;
	}
	
}
