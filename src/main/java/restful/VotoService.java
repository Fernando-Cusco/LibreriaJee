package restful;



import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.Libro;
import modelo.Usuario;
import modelo.Voto;
import negocio.VotoON;
@Path("/votos")
public class VotoService {
	@Inject
	private VotoON votoOn;
	@GET
    @Path("/votar")
    @Produces(MediaType.APPLICATION_JSON)
    public Respuesta addVoto(@QueryParam("usuario_id") int userId, @QueryParam("libro_id") int libroId) {
		return votoOn.realizarVoto(userId, libroId); 
    }

}
