package cl.fuentes.modelo;

public class Usuario {

	private int idusuario;
	private String usuario;
	private String clave;
	private String nombre;
	private String tipousuario;
	private String estado;
	
	
	public Usuario() {
		
	}
	
	public Usuario(int idusuario, String usuario, String clave, String nombre, String tipousuario, String estado) {
		super();
		this.idusuario = idusuario;
		this.usuario = usuario;
		this.clave = clave;
		this.nombre = nombre;
		this.tipousuario = tipousuario;
		this.estado = estado;
	}
	
	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public String getTipousuario() {
		return tipousuario;
	}

	public void setTipousuario(String tipousuario) {
		this.tipousuario = tipousuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
