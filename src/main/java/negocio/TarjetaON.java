package negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import dao.TarjetaDao;
import dao.UsuarioDao;
import modelo.Tarjeta;
import modelo.Usuario;
import modelotmp.TarjetaTMP;
import restful.Respuesta;

@Stateless
public class TarjetaON {

	
	@Inject
	private TarjetaDao dao;
	
	@Inject
	private UsuarioDao daoUser;
	
	public Respuesta agregarTarjeta(TarjetaTMP tarjeta) {
		Respuesta respuesta = new Respuesta();
		try {
			Usuario usuario = daoUser.buscar(tarjeta.getIdUser());
			Tarjeta t = new Tarjeta();
			t.setUsuario(usuario);
			t.setNumero(tarjeta.getNumero());
			t.setVencimiento(tarjeta.getVencimiento());
			t.setCode(tarjeta.getCode());
			usuario.agregarTarjeta(t);
			dao.agregarTarjeta(t);
			respuesta.setId(1);
			respuesta.setMensaje("tarjeta agregada");
		} catch (Exception e) {
			respuesta.setId(0);
			respuesta.setMensaje("error "+e.getMessage());
		}
		return respuesta;
	}
	
	public Tarjeta buscarTarjeta(int id) {
		return dao.buscarTarjeta(id);
	}
}
