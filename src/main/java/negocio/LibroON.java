package negocio;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.LibroDao;
import modelo.Libro;
import modelotmp.LibroTMP;

@Stateless
public class LibroON {

	@Inject
	private LibroDao librodao;

	public void crearLibro(Libro libro) {
		this.librodao.crearLibro(libro);
	}

	public List<Libro> mostrarLibros() {
		return this.librodao.mostrarLibros();
	}

	public Libro buscar(int id) {
		return librodao.buscar(id);
	}

	public Libro buscarLibro(int id) {
		return librodao.buscarLibro(id);
	}

	public List<Libro> buscarSimilar(String key) {
		return librodao.buscarSimilar(key);
	}

	public List<LibroTMP> librosMasVendidos() {
		List<Object[]> lista = librodao.librosMasVendidos();
		List<LibroTMP> libros = new ArrayList<LibroTMP>();
		for (Object[] l : lista) {
			LibroTMP lt = new LibroTMP();
			lt.setId((int) l[0]);
			lt.setTitulo((String) l[1]);
			lt.setPaginas((int) l[2]);
			lt.setCantidad(((BigDecimal)l[3]).intValue());
			libros.add(lt);

		}

		return libros;
	}

}
