package cl.fuentes.modelo;

public class Cliente {
	private int codCliente;
	private String nombreCliente;
	private String tipoCliente;
	
	// Constructores
	public Cliente () {
		
	}
	
	public Cliente (int codCliente, String nombreCliente, String tipoCliente) {
		super();
		this.codCliente = codCliente;
		this.nombreCliente = nombreCliente;
		this.tipoCliente = tipoCliente;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
	
}
