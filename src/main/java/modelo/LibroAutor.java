package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "libro_autor")
public class LibroAutor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@ManyToOne
	private Libro libro;
	
	
	@ManyToOne
	private Autor autor;
	
	@Transient
	private int idBuscar;
	

	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Libro getLibro() {
		return libro;
	}


	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}


	public int getIdBuscar() {
		return idBuscar;
	}


	public void setIdBuscar(int idBuscar) {
		this.idBuscar = idBuscar;
	}


	

}
