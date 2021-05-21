package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserData {
	
//	stmt.executeUpdate("create table users( name varchar(15) not null , last_name varchar(15) not null , email varchar(20) not null , password varchar(12) not null , primary key(email))");
//	stmt.executeUpdate("create table data(username varchar(15) , password varchar(15) , link varchar(25) , email varchar(20) references users(email))");
//	stmt.executeUpdate("create table users( name varchar(15) not null , last_name varchar(15) not null , email varchar(20) not null , password varchar(12) not null , primary key(email))");
//	stmt.executeUpdate("create table data(username varchar(15) , password varchar(15) , link varchar(25) , email varchar(20) references users(email))");


	
    private static final  String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String JDBC_URL = "jdbc:derby:Mydb;create=true";  
	private static  Connection connection ;
	private static ResultSet resultset;
	private static Statement stmt;
	public static PreparedStatement pstmt;
	public static UserData user = new UserData();
	
	private UserData()  {
		try {
			Class.forName(DRIVER);
			
		connection = DriverManager.getConnection(JDBC_URL);
		}catch(SQLException e) {
			System.out.println("SQLException Caught while creating connection");
		}
	catch(Exception e) {
			System.out.println("UserData Exception Occured ");
		}
	}
	
	public static UserData getObject() {
		return user;
	}
	
	public void insertData(String name ,String last_name ,String email ,String password)throws SQLException{
	//	stmt = connection.createStatement();
	//	stmt.executeUpdate("insert into users values("+name+","+last_name+","+email+","+password+")");
		pstmt = connection.prepareStatement("insert into users values(?,?,?,?)");
		pstmt.setString(1, name);
		pstmt.setString(2, last_name);
		pstmt.setString(3, email);
		pstmt.setString(4, password);
		pstmt.executeUpdate();
		
		
		//System.out.println("Data Inserted in insertData UserData "+pstmt.executeUpdate());
		
		
	}
	
	
	public void updateName(String name , String email)throws SQLException {		
		stmt = connection.createStatement();
		stmt.executeUpdate("update users set name='"+name+"' where email='"+email+"'");	
	}
	
    public void updateLastName(String LastName , String email)throws SQLException {
    	stmt = connection.createStatement();
		stmt.executeUpdate("update users set name='"+LastName+"' where email='"+email+"'");
	}
	
	
	public String getName(String mail) throws SQLException {
		pstmt = connection.prepareStatement("select name from users where email='"+mail+"'");
		ResultSet result = pstmt.executeQuery();
		if(result.next())
			return result.getString("name");
		
		return null;
	}
	
	public String getLastName(String mail) throws SQLException {
		pstmt = connection.prepareStatement("select last_name from users where email='"+mail+"'");
		ResultSet result = pstmt.executeQuery();
		if(result.next())
			return result.getString("last_name");
	
		return null;
	}
	
	public String getPassword(String mail)throws SQLException {
		
		pstmt = connection.prepareStatement("select password from users where email='"+mail+"'");
		ResultSet result = pstmt.executeQuery();
		if(result.next()) {
			return result.getString("password");
			}
		
		return null;
		
	}
	
	
	
	public boolean isUserAvailable(String mail){
		try {
			//stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			stmt = connection.createStatement();
			resultset = stmt.executeQuery("select name from users where email='"+mail+"'");
			
				return resultset.next();
			
			//return resultset.isBeforeFirst();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Some exception caught in UserData class in isUserAvailable()");
			e.printStackTrace();
		}
		return false;
		
	}
	
	public void insertNewRecord(String email , String link ,String username ,String password) throws SQLException {
		
//		stmt = connection.createStatement();
//		stmt.executeUpdate("insert into data values("+username+","+password+","+link+","+email+")");
		pstmt = connection.prepareStatement("insert into data values(?,?,?,?)");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		pstmt.setString(3, link);
		pstmt.setString(4, email);
		pstmt.executeUpdate();
		
	}
	
	
	public ResultSet getData(String email) throws SQLException {
		pstmt = connection.prepareStatement("select link , username ,password from data where email='"+email+"'");
		ResultSet result = pstmt.executeQuery();
		
		return result;
	}
	
	
}
