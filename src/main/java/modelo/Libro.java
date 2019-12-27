package modelo;


import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "libros")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "titulo es requerido")
	private String titulo;
	private String descripcion;
	
	private String portada;
	@NotNull(message = "fecha publicacion es requerido")
	@Column(name = "fecha_publicion")
	private Date fechaPublicacion;
	@NotNull(message = "pagina es requerido")
	private int paginas;
	@NotNull(message = "precio es requerido")
	private double precio;
	@NotNull(message = "stock es requerido")
	private int stock;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	@JoinColumn(name = "libtaut_id")
	private List<LibroAutor> autores;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
	private List<Voto> votos;
	
	
	public void agregarAuto(LibroAutor libroAutor) {
		if(this.autores == null) {
			this.autores = new ArrayList<LibroAutor>();
		}
		this.autores.add(libroAutor);
	}
	
	public void agregarVoto(Voto voto) {
		if(votos == null) {
			votos = new ArrayList<Voto>();
		}
		votos.add(voto);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public List<Voto> getVotos() {
		return votos;
	}

	public void setVotos(List<Voto> votos) {
		this.votos = votos;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public int getPaginas() {
		return paginas;
	}
	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<LibroAutor> getAutores() {
		return autores;
	}

	public void setAutores(List<LibroAutor> autores) {
		this.autores = autores;
	}

	public int getId() {
		return id;
	}

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}
	
	
}
