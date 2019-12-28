package restful;

import java.util.ArrayList;

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
	VotoON votoOn;
	@GET
    @Path("/votar")
    @Produces(MediaType.APPLICATION_JSON)
    public Voto addVoto(@QueryParam("usuario_id") int userId, @QueryParam("libro_id") int libroId) {
        Voto v = new Voto();
        Libro l = new Libro();
        Usuario u= new Usuario();
        l.setId(libroId);
        u.setId(userId);

        v.setLib(l);
        v.setUser(u);
		votoOn.realizarVoto(v); 
       /* member.setName("Andres2");
        if (member == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return member;*/
		return v;
    }

}
