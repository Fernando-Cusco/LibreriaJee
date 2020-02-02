package modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="compartidos")
public class Compartir {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Usuario comparte;
	
	@ManyToOne
	private Usuario recibe;
	@ManyToOne
	private Libro libro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Usuario getComparte() {
		return comparte;
	}
	public void setComparte(Usuario comparte) {
		this.comparte = comparte;
	}
	public Usuario getRecibe() {
		return recibe;
	}
	public void setRecibe(Usuario recibe) {
		this.recibe = recibe;
	}
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	@Override
	public String toString() {
		return "Compartir [id=" + id + ", comparte=" + comparte + ", recibe=" + recibe + ", libro=" + libro + "]";
	}
	
	
	
}
