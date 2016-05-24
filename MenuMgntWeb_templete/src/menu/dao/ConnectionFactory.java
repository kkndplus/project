package menu.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import menu.util.exception.NamooMenuException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	private String driver;
	private String url;
	private String user;
	private String password;

	private ConnectionFactory() {
		//
		loadProperties();

		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new NamooMenuException("드라이버를 로딩하기 위한 클래스를 찾을 수 없습니다. : " + driver);
		}
	}

	private void loadProperties() {
		//
		Properties prop = new Properties();
		InputStream is = this.getClass().getResourceAsStream("jdbc.properties");

		try {
			prop.load(is);
			this.driver = prop.getProperty("database.driver");
			this.url = prop.getProperty("database.url");
			this.user = prop.getProperty("database.user");
			this.password = prop.getProperty("database.password");
		} catch (IOException e) {
			throw new NamooMenuException("데이터베이스 정보 로딩중 오류가 발생했습니다.");
		}
	}

	public static ConnectionFactory getInstance() {
		//
		return instance;
	}

	public Connection createConnection() {
		//
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new NamooMenuException("데이터베이스 접속중 오류가 발생했습니다.");
		}
	}
}
