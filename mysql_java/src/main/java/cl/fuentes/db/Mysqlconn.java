package cl.fuentes.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;


public class Mysqlconn {

	public Mysqlconn(String server, String db, String usuario, String password) {
		this.server = server;
		this.db = db;
		this.usuario = usuario;
		this.password = password;
	}

	private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    private String server;
    private String db;
    private String usuario;
    private String password;
    
    public void open() throws Exception{
    	try {
            Class.forName("com.mysql.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql://" + server + "/"+ db +"?user="+ usuario +"&password="+ password);
            System.out.println("Conexion establecida");
		} catch (Exception e) {
			throw e;
		}
    }
    
    public ResultSet ejecutarQuery(String sqlScript) throws SQLException{
    	
    	preparedStatement = connect.prepareStatement(sqlScript);
    	resultSet = preparedStatement.executeQuery();
    	setResultSet(resultSet);
    	System.out.println("Query ejecutada");
    	return resultSet;
    	
    } 

    public void ejecutarUpdate(String sqlScript) throws SQLException{
    	
    	preparedStatement = connect.prepareStatement(sqlScript);
    	preparedStatement.executeUpdate();
    	System.out.println("Query actualizada");

    }
    
    public void close() throws Exception{
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
            System.out.println("Conexion cerrada");
        } catch (Exception e) {
        	throw e;
        }
    }

    public void obtenerColumnas(ResultSet resultSet) throws SQLException {

    	System.out.println("Las columnas de la tabla son: ");
        System.out.println("Tabla: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Columna " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
    
    public void mostrarQuery(ResultSet resultSet) throws SQLException {

    	ResultSetMetaData metadata = resultSet.getMetaData();
        int columnCount = metadata.getColumnCount();    
        for (int i = 1; i <= columnCount; i++) {
            System.out.println(metadata.getColumnName(i) + ", ");      
        }
        System.out.println();
        while (resultSet.next()) {
            String row = "";
            for (int i = 1; i <= columnCount; i++) {
                row += resultSet.getString(i) + ", ";          
            }
            System.out.println(row);
        }
    }
    
	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	public void setPreparedStatement(PreparedStatement preparedStatement) {
		this.preparedStatement = preparedStatement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
