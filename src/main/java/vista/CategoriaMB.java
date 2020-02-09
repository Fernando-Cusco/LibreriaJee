package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Categoria;
import negocio.CategoriaON;

@ManagedBean
public class CategoriaMB {

	@Inject
	private CategoriaON on;
	
	private Categoria categoria;
	
	private List<Categoria> categorias;
	
	@PostConstruct
	public void init() {
		this.categoria = new Categoria();
		listar();
	}
	
	public String agregarCategoria() {
		this.on.crearCategoria(categoria);
		this.categoria = null;
		return null;
	}
	
	public void listar() {
		this.categorias = this.on.mostrarCategorias();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
}
