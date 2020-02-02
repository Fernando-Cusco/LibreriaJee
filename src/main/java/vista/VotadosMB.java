package vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelotmp.VotoTMP;
import negocio.VotoON;

@ManagedBean
public class VotadosMB {

	@Inject
	private VotoON on;
	
	private List<VotoTMP> vots;
	
	@PostConstruct
	public void init() {
		vots = new ArrayList<VotoTMP>();
		cargar();
	}
	
	public void cargar() {
		vots = on.votos();
	}

	public List<VotoTMP> getVots() {
		return vots;
	}

	public void setVots(List<VotoTMP> vots) {
		this.vots = vots;
	}

	
	
}
