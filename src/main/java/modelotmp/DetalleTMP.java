package modelotmp;

public class DetalleTMP {

	private int cantidad;

	private int idLib;
	
	private int idUsuario;

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

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "DetalleTMP [cantidad=" + cantidad + ", idLib=" + idLib + ", idUsuario=" + idUsuario + "]";
	}

	

}
