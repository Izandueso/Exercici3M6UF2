import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class IniciDeSessio {
	
	public static void main (String[] args) throws SQLException, ClassNotFoundException{
		
		String usuarioD = null;
		String passD = null;
		
		Scanner teclado = new Scanner(System.in);
		
		Connection connection = null;
		Statement stmt = null;
		
		System.out.println("Introdueix nom de usuari:");
		String usuari = teclado.next();
		
		System.out.println("Introdueix contraseña:");
		String contraseña = teclado.next();
		
		String SQL = "SELECT * FROM usuaris WHERE usuari='" + usuari + "' and contrasenya='" + contraseña+ "'";
		
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/usuaris", "root", "");

		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(SQL);
		
		try
		{	
			while(rs.next()){
				usuarioD = rs.getString("usuari");
				passD = rs.getString("contrasenya");
			}
		
			if(usuari.equals(usuarioD) && contraseña.equals(passD)){
				System.out.println("Login Correcto!");
			}else{
				System.out.println("Incorrecto");
			}
			
		} 
		catch (Exception e) {
			System.out.println("" + e.getMessage());
		}finally {
			try {
				stmt.close();
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}