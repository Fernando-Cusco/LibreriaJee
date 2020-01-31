package modelotmp;

public class DetalleTMP {

	private int cantidad;

	private int idLib;
	
	private int idUsuario;
	
	private int idTarjeta;
	
	private int idDireccion;

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
	
	

	public int getIdTarjeta() {
		return idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getIdDireccion() {
		return idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	@Override
	public String toString() {
		return "DetalleTMP [cantidad=" + cantidad + ", idLib=" + idLib + ", idUsuario=" + idUsuario + "]";
	}

	

}
