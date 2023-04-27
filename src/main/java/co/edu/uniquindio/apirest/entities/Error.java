package co.edu.uniquindio.apirest.entities;

public class Error {

	private String campo;

	private String mensaje;

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Error() {
	}

	public Error(String campo, String mensaje) {
		super();
		this.campo = campo;
		this.mensaje = mensaje;
	}

}
