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
	
	public Tarjeta buscarTarjeta(int id) {
		return em.find(Tarjeta.class, id);
	}
}
