package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Tarjeta;

public class TarjetaDao {

	@Inject
	private EntityManager em;
	
	public void agregarTarjeta(Tarjeta tarjeta) {
		em.persist(tarjeta);
	}
}
