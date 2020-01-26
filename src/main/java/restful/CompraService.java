package restful;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import modelo.Compra;
import modelo.Detalle;
import modelo.Tarjeta;
import modelo.Usuario;
import modelotmp.DetalleCom;
//import modelo.Detalle;
import modelotmp.DetalleTMP;
import negocio.CompraON;
import negocio.DireccionON;
import negocio.LibroON;
import negocio.TarjetaON;
import negocio.UsuarioON;

@Path("/compras")
public class CompraService {

	@Inject
	private LibroON libOn;
	
	@Inject
	private UsuarioON userOn;
	
	@Inject
	private CompraON compraOn;

	@Inject
	private TarjetaON tarjetaOn;
	
	@Inject
	private DireccionON direccionOn;
	
	@POST
	@Path("/detalles")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Double detalles(List<DetalleTMP> detalles) {
		Double subtotal = 0.0;
		List<DetalleCom> details = new ArrayList<DetalleCom>();
		for (DetalleTMP detalle : detalles) {
			DetalleCom det = new DetalleCom();
			det.setCantidad(detalle.getCantidad());
			det.setLibro(libOn.buscarLibro(detalle.getIdLib()));
			details.add(det);
		}
		for (DetalleCom detalleCom : details) {
			subtotal += detalleCom.calcularSubtotal(); 
		}
		
		return subtotal;
	}
	
	@POST
	@Path("/factura")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	public Double factura(List<DetalleTMP> detalles) {
		System.out.println(detalles.size()+" size");
		Usuario u = new Usuario();
		Double total = 0.0;
		List<Detalle> dts = new ArrayList<Detalle>();
		for (DetalleTMP detalle : detalles) {
			u = userOn.buscar(detalle.getIdUsuario());
			Detalle d = new Detalle();
			d.setCantidad(detalle.getCantidad());
			d.setLibro(libOn.buscarLibro(detalle.getIdLib()));
			dts.add(d);
		}
		
		Compra c = new Compra();
		c.setDescripcion("Facturando tus productos");
		c.setDetalles(dts);
		c.setFecha(new Date());
		c.setUsuario(u);
		c.setDireccion(direccionOn.buscarDireccion(1));
		c.setTarjeta(tarjetaOn.buscarTarjeta(1));
		total = c.calcularTotal();
		u.nuevaCompra(c);
		compraOn.nuevaCompra(c);
		
		System.out.println(c.toString()+" "+total);
		return total;
	}
	
	@GET
	@Path("datospago")
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario datosPago(@QueryParam("id") int id) {
		return userOn.datosPago(id);
	}
	
	@GET
	@Path("tarjetas")
	@Produces({MediaType.APPLICATION_JSON})
	public Usuario tarjetas(@QueryParam("id") int id) {
		return userOn.tarjetas(id);
	}
	
	
	@POST
	@Path("agregarTarjeta")
	@Produces({MediaType.APPLICATION_JSON})
	public void agregarTarjeta(Tarjeta tarjeta) {
		Usuario usuario = userOn.buscar(tarjeta.getId());
		Tarjeta t = new Tarjeta();
		t.setUsuario(usuario);
		t.setNumero(tarjeta.getNumero());
		t.setVencimiento(tarjeta.getVencimiento());
		t.setCode(tarjeta.getCode());
		usuario.agregarTarjeta(t);
		tarjetaOn.agregarTarjeta(t);
	}
	
	
}
