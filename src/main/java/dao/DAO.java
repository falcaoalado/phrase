package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public abstract class DAO {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;

	public void open() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBPHRASE?useSSL=false", "root", "1234");
	}

	public void close() throws Exception {
		this.connection.close();
	}
}
