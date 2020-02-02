package modelotmp;

public class CompartirTMP {

	private int libro;
	
	private int usuarioComparte;
	
	private int usuarioRecibe;

	public int getLibro() {
		return libro;
	}

	public void setLibro(int libro) {
		this.libro = libro;
	}

	public int getUsuarioComparte() {
		return usuarioComparte;
	}

	public void setUsuarioComparte(int usuarioComparte) {
		this.usuarioComparte = usuarioComparte;
	}

	public int getUsuarioRecibe() {
		return usuarioRecibe;
	}

	public void setUsuarioRecibe(int usuarioRecibe) {
		this.usuarioRecibe = usuarioRecibe;
	}

	@Override
	public String toString() {
		return "CompartirTMP [libro=" + libro + ", usuarioComparte=" + usuarioComparte + ", usuarioRecibe="
				+ usuarioRecibe + "]";
	}
	
	
}
