package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CategoriaDao;
import modelo.Categoria;

@Stateless
public class CategoriaON {

	@Inject
	private CategoriaDao dao;
	
	public void crearCategoria(Categoria categoria) {
		this.dao.crearCategoria(categoria);
	}
	
	public Categoria buscar(int id) {
		return dao.buscar(id);
	}
	
	public Categoria buscarCategoria(String nombre) {
		return dao.buscarCategoria(nombre);
	}
	
	public List<Categoria> mostrarCategorias() {
		return dao.mostrarCategorias();
	}
	
}
