package modelo;

public class Detalle {

	private int id;
	private int cantidad;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + "]";
	}
	public double calcularSubtotal() {
		return 0.0;
	}
	
}
