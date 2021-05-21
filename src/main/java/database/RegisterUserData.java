package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegisterUserData {

	static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	static final String JDBC_URL = "jdbc:derby:Mydb;create=true";

	public static void RegisterUser(String name, String lastName, String email, String password) {
		String query = "insert into users values( " + name + "," + lastName + "," + email + "," + password + ")";

		try  {Connection connection = DriverManager.getConnection(JDBC_URL);
		     Statement stmt = connection.createStatement();
			Class.forName(DRIVER);

			stmt.executeUpdate(query);
			connection.close();

		} catch (SQLException e) {
			System.out.println("SQLException in Occured RegisterUserData.java "+e);
		} catch (Exception e) {
			System.out.println("Exception Occured in RegisterUserData.java");
		}

	}

}
