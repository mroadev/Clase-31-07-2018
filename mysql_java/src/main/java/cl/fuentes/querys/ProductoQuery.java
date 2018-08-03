package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;
import cl.fuentes.modelo.Producto;

public class ProductoQuery implements Crud<Producto>{

	private Mysqlconn con;
	
	public ProductoQuery(Mysqlconn con) {
		this.con = con;
	}

	@Override
	public void create(Producto objeto) {
		try{
			String sql = "insert into Producto (producto, precio) values ('" + objeto.getProducto() + "'," + objeto.getPrecio() + ")";
			
			System.out.println(sql);
			
			con.ejecutarUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Producto read(String codProducto) {
		Producto producto = new Producto();
		
		try{
			String sql = "select * from Producto where codProducto=" + codProducto + ";";
			
			System.out.println(sql);
			
			ResultSet rs = con.ejecutarQuery(sql);
			
			while (rs.next()){
				producto.setCodProducto(rs.getInt(1));
				producto.setProducto(rs.getString(2));
				producto.setPrecio(rs.getInt(3));
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return producto;
	}

	@Override
	public void update(Producto objeto) {
		try{
			String sql = "update Producto set producto='" + objeto.getProducto() + "', precio=" + objeto.getPrecio() + " where codProducto=" + objeto.getCodProducto() + ";";
			
			System.out.println(sql);
			
			con.ejecutarUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}

	@Override
	public void delete(String codProducto) {
		try{
			String sql = "delete from Producto where codProducto=" + codProducto + ";";
			
			System.out.println(sql);
			
			con.ejecutarUpdate(sql);
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
