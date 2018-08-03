package cl.fuentes.querys;

import java.sql.ResultSet;
import java.sql.SQLException;

import cl.fuentes.db.Mysqlconn;

public class LoginQuery {

	private Mysqlconn conn;
	
	public LoginQuery(Mysqlconn con){
		this.conn = con;
	}
	
	public boolean loginCheck(String usuario, String clave) {
		ResultSet rs;
		boolean resp = false;
		String txtsql = "SELECT * FROM usuario where usuario = '"
				+ usuario
				+ "' and clave = '"
				+ clave + "' ";
		try {
			rs = conn.ejecutarQuery(txtsql);
			if(rs.next()) {
				resp = true;
			}
		} catch (SQLException e) {
			System.out.println("Error al intentar consultar usuario"); 
		}
		return resp;
	}

}
