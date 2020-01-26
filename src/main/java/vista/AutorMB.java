package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Autor;
import negocio.AutorON;

@ManagedBean
public class AutorMB {
	
	@Inject
	private AutorON gestion;
	
	private Autor autor;
	
	private List<Autor> autores;
	
	@PostConstruct
	public void init() {
		this.autor = new Autor();
		listar();
	}

	public String agregarAutor() {
		this.gestion.crearAutor(autor);
		this.autor = null;
		return null;
	}
	
	public void listar() {
		this.autores = this.gestion.mostrarAutores();
	}
	
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	
	
}
