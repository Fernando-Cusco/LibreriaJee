package restful;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.Autor;
import modelo.Libro;
import negocio.LibroON;

@Path("/libros")
public class LibroService {
	
	
	@Inject
	private LibroON libro;
	
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> libros() {
		return libro.mostrarLibros();
	}
	
	@GET
	@Path("/buscar/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public Libro buscarLibro(@PathParam("id") int id) {
		return libro.buscarLibro(id);
	}
	
	
	@GET
	@Path("/similar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> buscarLibro(@QueryParam("key") String key) {
		return libro.buscarSimilar(key);
	}
	

}
