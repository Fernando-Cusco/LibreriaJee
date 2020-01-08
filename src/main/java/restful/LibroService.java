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
import modelotmp.LibroTMP;
import negocio.AutorON;
import negocio.LibroON;

@Path("/libros")
public class LibroService {
	
	
	@Inject
	private LibroON libro;
	
	@Inject
	private AutorON autor;
	
	@GET
	@Path("todos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> libros() {
		return libro.mostrarLibros();
	}
	
	@GET
	@Path("/buscar/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public LibroTMP buscarLibro(@PathParam("id") int id) {
		List<Autor> autores = new ArrayList<Autor>();
		LibroTMP tmp = new LibroTMP();
		Libro l = libro.buscarLibro(id);
		tmp.setId(l.getId());
		tmp.setTitulo(l.getTitulo());
		tmp.setDescripcion(l.getDescripcion());
		tmp.setPortada(l.getPortada());
		tmp.setFechaPublicacion(l.getFechaPublicacion());
		tmp.setPaginas(l.getPaginas());
		tmp.setPrecio(l.getPrecio());
		tmp.setStock(l.getStock());
		for(int i =0; i < l.getAutores().size(); i++) {
			autores.add(l.getAutores().get(i).getAutor());
		}
		tmp.setAutores(autores);
		return tmp;
	}
	
	
	@GET
	@Path("/similar")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Libro> buscarLibro(@QueryParam("key") String key) {
		return libro.buscarSimilar(key);
	}
	
	@GET
	@Path("/autor")
	@Produces(MediaType.APPLICATION_JSON)
	public Autor libroautor() {
		return autor.libroautor(0);
	}
	

}
