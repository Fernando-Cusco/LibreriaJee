package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Direccion;


public class DireccionDao {

	@Inject
	private EntityManager em;
	
	public Direccion buscarDireccion(int id) {
		return em.find(Direccion.class, id);
	}
}
