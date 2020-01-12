package modelotmp;

public class DetalleTMP {

	private int cantidad;

	private int idLib;

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdLib() {
		return idLib;
	}

	public void setIdLib(int idLib) {
		this.idLib = idLib;
	}

	@Override
	public String toString() {
		return "DetalleTMP [cantidad=" + cantidad + ", idLib=" + idLib + "]";
	}

}
