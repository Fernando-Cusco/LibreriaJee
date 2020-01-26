package modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "direcciones")
public class Direccion implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message = "ciudad es requerdio")
	private String ciudad;
	@NotNull(message = "calle es requerdio")
	private String calles;
	
	
	
	
	public Direccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCalles() {
		return calles;
	}
	public void setCalles(String calles) {
		this.calles = calles;
	}
	@Override
	public String toString() {
		return "Direccion [id=" + id + ", ciudad=" + ciudad + ", calles=" + calles + "]";
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
