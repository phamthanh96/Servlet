/**
 *Copyright(C) Luvina
 *ConnectionDatabase.java, Oct 1, 2019, Pham Thanh
 */
package model.logic;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import util.*;

/**
 * @author Pham Thanh
 *
 */
public class ConnectionDatabase {
	private Common common= new Common();
	private String DRIVER="";
	private String URL="";
	private String USER="";
	private String PASS= "";
	
	protected Connection connect;
	/**
	 *Tìm đến driver connection
	 * @throws ClassNotFoundException không tìm thấy Driver
	 * @throws IOException 
	 */
	public ConnectionDatabase() throws ClassNotFoundException, IOException{

			try {
				Properties properties= common.loadProperties("database.properties");
				DRIVER= properties.getProperty("DRIVER");
				URL= properties.getProperty("URL");
				USER= properties.getProperty("USER");
				PASS =properties.getProperty("PASS");
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				throw new ClassNotFoundException("==========" +common.getErrorMessage("ERROR_DRIVER")+"==========");
			} catch (IOException e) {
				throw new IOException();
			}
	}
	
	/**
	 * Phương thức tạo kết nối đến CSDL
	 * @throws SQLException
	 */
	public void openConnect() throws SQLException {
		try {
			connect=DriverManager.getConnection(URL, USER, PASS);
		} catch (SQLException e) {
			throw new SQLException("======="+common.getErrorMessage("ERROR_OPEN_CONNECT")+"======");
		}
	}
	
	/**
	 * Phương thức đóng kết nối với CSDL
	 * @throws SQLException 
	 */
	public void closeConnect() throws SQLException {
		try {
			if(connect != null || !connect.isClosed()) {
				connect.close();
			}
		} catch (SQLException e) {
			throw new SQLException("========= " + common.getErrorMessage("ERROR_CLOSE_CONNECT") + " =========");
		}
	
	}

}