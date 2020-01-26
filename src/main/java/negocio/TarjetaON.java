package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TarjetaDao;
import modelo.Tarjeta;

@Stateless
public class TarjetaON {

	
	@Inject
	private TarjetaDao dao;
	
	public void agregarTarjeta(Tarjeta tarjeta) {
		dao.agregarTarjeta(tarjeta);
	}
}
