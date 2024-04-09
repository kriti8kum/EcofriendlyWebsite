package eco.friendly;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class com extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

    
	try {
		
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 String url = "jdbc:mysql://localhost:3306/myshpoing";

           String username = "root";
           String password = "Kjha890";

           try (Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement ps = con.prepareStatement("insert into star(email, password) values (?,?)")) {
                 
               String username1 = request.getParameter("email");
               String password11 = request.getParameter("password");

               // Basic input validation (you might want to improve this)
                
                   ps.setString(1, username1);
                   ps.setString(2, password11);

                   int rowsAffected = ps.executeUpdate();
                   System.out.println("Rows affected: " + rowsAffected);
               } 

           
       } catch (SQLException e) {
           e.printStackTrace(); // Handle the exception more gracefully in a production environment
       } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
}
}



}


