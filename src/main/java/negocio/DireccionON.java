package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.DireccionDao;
import modelo.Direccion;

@Stateless
public class DireccionON {

	@Inject
	private DireccionDao dao;
	
	public Direccion buscarDireccion(int id) {
		return dao.buscarDireccion(id);
	}
}
