package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.VotoDao;
import modelo.Voto;

@Stateless
public class VotoON {

	@Inject
	private VotoDao dao;
	
	
	public void realizarVoto(Voto v) {
		dao.realizarVoto(v);
	}
	
}
