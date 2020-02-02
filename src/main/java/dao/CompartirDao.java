package dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import modelo.Compartir;

public class CompartirDao {

	@Inject
	private EntityManager em;
	
	public void compartir(Compartir compartir) {
		em.persist(compartir);
	}
	
	//select DISTINCT com.libro_id, com.comparte_id from compartidos com where com.recibe_id = 1;
}
