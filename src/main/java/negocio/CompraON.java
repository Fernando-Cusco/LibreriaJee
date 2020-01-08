package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.CompraDao;
import modelo.Compra;

@Stateless
public class CompraON {

	@Inject
	private CompraDao dao;
	
	public void nuevaCompra(Compra compra) {
		dao.nuevaCompra(compra);
	}
	
}
