package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "nombres son requerido")
	private String nombres;
	@NotNull(message = "correo es requerido")
	private String correo;
	@NotNull(message = "contraseña es requerido")
	private String password;
	@Temporal(TemporalType.DATE)
	private Date fecha;
	private boolean permiso;
	@NotNull
	private String telefono;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
	private List<Direccion> direcciones;

	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "usuario")
	private List<Tarjeta> tarjetas;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Compra> compras;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Voto> votos;

	public void agregarVoto(Voto voto) {
		if (votos == null) {
			votos = new ArrayList<Voto>();
		}
		votos.add(voto);
	}

	public void nuevaCompra(Compra compra) {
		if (compras == null) {
			compras = new ArrayList<Compra>();
		}
		compras.add(compra);
	}

	public Usuario() {
		super();
	}

	public void agregarDireccion(Direccion direccion) {
		if (direcciones == null) {
			direcciones = new ArrayList<Direccion>();
		}
		this.direcciones.add(direccion);
	}

	public void agregarTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null) {
			tarjetas = new ArrayList<>();
		}
		tarjetas.add(tarjeta);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean isPermiso() {
		return permiso;
	}

	public void setPermiso(boolean permiso) {
		this.permiso = permiso;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Tarjeta> getTarjetas() {
		return tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", correo=" + correo + ", password=" + password
				+ ", fecha=" + fecha + ", permiso=" + permiso + ", telefono=" + telefono + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
