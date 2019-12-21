package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.AutorDao;
import modelo.Autor;

@Stateless
public class AutorON {

	@Inject
	private AutorDao gestion;
	
	public void crearAutor(Autor autor) {
		this.gestion.crearAutor(autor);
	}
	
	public Autor buscarAutor(String nombres) {
		return this.gestion.buscarAutor(nombres);
	}
	
	public List<Autor>mostrarAutores() {
		return this.gestion.mostrarAutores();
	}
	
}
