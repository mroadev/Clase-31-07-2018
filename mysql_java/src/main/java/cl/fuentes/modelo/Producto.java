package cl.fuentes.modelo;

public class Producto {
	private int codProducto;
	private String producto;
	private int precio;
	
	public Producto () {
		
	}
	
	public Producto (int codProducto, String producto, int precio) {
		super();
		this.codProducto = codProducto;
		this.producto = producto;
		this.precio = precio;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
}

