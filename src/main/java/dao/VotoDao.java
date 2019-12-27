package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Voto;

public class VotoDao {

	
	@Inject
	private EntityManager em;
	
	public void realizarVoto(Voto v) {
		em.persist(v);
		
	}
	
	
	
}
