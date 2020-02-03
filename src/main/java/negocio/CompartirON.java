package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CompartirDao;
import dao.LibroDao;
import dao.UsuarioDao;
import modelo.Compartir;
import modelo.Libro;
import modelo.Usuario;
import modelotmp.CompartirTMP;
import restful.Respuesta;

@Stateless
public class CompartirON {

	@Inject
	private CompartirDao dao;
	
	@Inject
	private LibroDao ldao;
	
	@Inject
	private UsuarioDao udao;
	
	public Respuesta compartir(CompartirTMP com) {
		Respuesta r = new Respuesta();
		try {
			Usuario comparte = udao.buscar(com.getUsuarioComparte());
			Usuario recibe = udao.buscar(com.getUsuarioRecibe());
			Libro l = ldao.buscarLibro(com.getLibro());
			Compartir compartir = new Compartir();
			compartir.setComparte(comparte);
			compartir.setRecibe(recibe);
			compartir.setLibro(l);
			l.compartirEnviar(compartir);
			dao.compartir(compartir);
			r.setId(1);
			r.setMensaje("Se ha compartido correctamente");
		} catch (Exception e) {
			r.setId(0);
			r.setMensaje("Error "+e.getMessage());
		}
		return r;
	}
	
	public List<CompartirTMP> compartidosMe(int id) {
		return dao.compartidosMe(id);
	}
	
	
}
