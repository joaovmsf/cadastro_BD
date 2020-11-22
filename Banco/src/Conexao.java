import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexao {

	public static void main(String[] args) {
		
	try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			
			String url = "jdbc:sqlserver://localhost:1433;databaseName=EXERCICIOS";
			String user = "sa";
			String password = "Jo@nca52486";
			
			
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexão efetuada!");
			
			
			Statement stmt = conn.createStatement();
			
//Solicitando aos dados do banco
			
			ResultSet rs = stmt.executeQuery("select * from cidade");
						
			while(rs.next()) {
				
				System.out.println(rs.getString("nome"));
				
			}
			
			rs.close();			
			stmt.close();
			conn.close();
						
				
		} 	catch(Exception e) {
				System.out.println(e.getMessage());
		}
	}
}