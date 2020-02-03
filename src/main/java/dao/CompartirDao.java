package dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Compartir;
import modelotmp.CompartirTMP;

public class CompartirDao {

	@Inject
	private EntityManager em;

	public void compartir(Compartir compartir) {
		em.persist(compartir);
	}

	public List<CompartirTMP> compartidosMe(int id) {
		String sql = "select DISTINCT com.libro_id, usu.nombres from compartidos com, usuarios usu where usu.id = com.comparte_id and com.recibe_id = "+id+";";
		Query query = em.createNativeQuery(sql);
		
		List<Object[]> c = query.getResultList();
		List<CompartirTMP> com = new ArrayList<CompartirTMP>();
		for (Object[] objects : c) {
			CompartirTMP ctmp = new CompartirTMP();
			ctmp.setLibro((int)objects[0]);
			ctmp.setNombreUsuario((String) objects[1]);
			com.add(ctmp);
		}
		return com;
	}

	// ;
}
