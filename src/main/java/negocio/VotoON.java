package negocio;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.LibroDao;
import dao.UsuarioDao;
import dao.VotoDao;
import modelo.Libro;
import modelo.Usuario;
import modelo.Voto;
import modelotmp.VotoTMP;
import restful.Respuesta;

@Stateless
public class VotoON {

	@Inject
	private VotoDao dao;
	
	@Inject
	private UsuarioDao usuarioDao;
	
	@Inject
	private LibroDao libroDao;
	
	public void realizarVoto(Voto v) {
		
		dao.realizarVoto(v);
	}
	
	public Respuesta realizarVoto(int idUser, int idLibr) {
		Respuesta respuesta = new Respuesta();
		try {
			Usuario u = usuarioDao.buscar(idUser);
			Libro l = libroDao.buscarLibro(idLibr);
			Voto v = new Voto();
			v.setLib(l);
			v.setUser(u);
			u.agregarVoto(v);
			l.agregarVoto(v);
			dao.realizarVoto(v);
			respuesta.setId(1);
			respuesta.setMensaje("voto agregado");
			
		} catch (Exception e) {
			respuesta.setId(0);
			respuesta.setMensaje("error: "+e.getMessage());
		}
		return respuesta;
	}
	
	public List<VotoTMP> votos() {
		List<Object[]> lista = dao.votos();
		List<VotoTMP> votos = new ArrayList<VotoTMP>();
		for (Object[] l : lista) {
			VotoTMP lt = new VotoTMP();
			lt.setId((int) l[0]);
			lt.setTitulo((String) l[1]);
			lt.setLikes(((BigInteger)l[2]).intValue());
			votos.add(lt);
		}
		return votos;
	}
}
