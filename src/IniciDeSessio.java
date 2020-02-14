import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class IniciDeSessio {
	static String user;
	static String passwd;
	static String haIniciadoSesion;
	
	public IniciDeSessio(String user, String passwd) throws ClassNotFoundException, SQLException{
		this.user = user;
		this.passwd = passwd;

	}

	public String haIniciado() throws ClassNotFoundException, SQLException{
		Scanner teclado = new Scanner(System.in);
		Connection connection = null;
		Statement stmt = null;
		String SQL = "SELECT * FROM usuaris WHERE usuari = '" + user + "' AND contrasenya = '" + passwd+ "'";
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/usuaris", "root", "");

		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		
		try{
			if(rs.next()){
				return "Ha iniciado!";
			}else{
				System.out.println("wefwer");
			}
		} 
		
		catch (Exception e) {
			return e.getMessage();
			
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Login incorrecto";
	}
	
	public String haIniciado2() throws ClassNotFoundException, SQLException{
		Scanner teclado = new Scanner(System.in);
		Connection connection = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/usuaris", "root", "");

		PreparedStatement prep = (PreparedStatement) connection.prepareStatement("SELECT * FROM usuaris WHERE usuari = ? AND contrasenya = ?");
		prep.setString(1, user);
		prep.setString(2, passwd);
		stmt = connection.createStatement();
		ResultSet rs = prep.executeQuery();
		
		try{
			if(rs.next()){
				return "Ha iniciado!";
			}else{
				System.out.println("wefwer");
			}
		} 
		
		catch (Exception e) {
			return e.getMessage();
			
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "Login incorrecto";
	}
}