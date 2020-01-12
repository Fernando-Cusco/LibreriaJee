package modelotmp;

import modelo.Libro;

public class DetalleCom {

	private int cantidad;
	
	private Libro libro;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "DetalleCom [cantidad=" + cantidad + ", libro=" + libro + "]";
	}
	
	
	public Double calcularSubtotal() {
		return cantidad * libro.getPrecio();
	}
	 
}
