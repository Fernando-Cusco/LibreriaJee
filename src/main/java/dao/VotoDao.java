package dao;


import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import modelo.Voto;

public class VotoDao {

	
	@Inject
	private EntityManager em;
	
	public void realizarVoto(Voto v) {
		em.persist(v);
	}
	
	public List<Object[]> votos() {		
		String sql = "select l.id, l.titulo, sum(v.lib_id) from votos v, libros l where l.id = v.lib_id group by l.id, l.titulo;";
		Query query = em.createNativeQuery(sql);
		List<Object[]> votos = query.getResultList();
		for (Object[] object : votos) {
			System.out.println(object[0]);
			System.out.println(object[1]);
			System.out.println(object[2]);
		}
		return votos;
	}
	
	//
	
}
