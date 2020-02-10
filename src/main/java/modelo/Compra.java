package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "compras")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "fecha es requerido")
	private Date fecha;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Usuario usuario; // muchas Facturas o Compras un solo cliente

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "detalle_id")
	private List<Detalle> detalles; // una Factura o Compra muchos detalles

	private String descripcion;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Direccion direccion;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	private Tarjeta tarjeta;
	
	private double total;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<Detalle> detalles) {
		this.detalles = detalles;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Tarjeta getTarjeta() {
		return tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Double calcularTotal() {
		Double total = 0.0;
		for (int i = 0; i < detalles.size(); i++) {
			total += detalles.get(i).calcularSubtotal();
		}
		return total;
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", fecha=" + fecha + ", usuario=" + usuario + ", detalles=" + detalles
				+ ", descripcion=" + descripcion + "]";
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	
}
