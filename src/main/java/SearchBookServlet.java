

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchBookServlet
 */
@WebServlet("/SearchBookServlet")
public class SearchBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    String n= request.getParameter("book_name");
		    //String p= request.getParameter("author");
		   // int x=Integer.parseInt(request.getParameter("book_id"));
		    //int y=Integer.parseInt(request.getParameter("member_id"));
		    PreparedStatement ps=con.prepareStatement("select * from Books where Book_Name=?");
		    ps.setString(1, n);
		   // ps.setString(2, p);
		    
		    
		    
		    ResultSet rs= ps.executeQuery();
		    if(rs.next())
		    {
		    	out.println("book present in library status is "+rs.getString("status"));
		    }
		    else
		    {
		    	out.println("Login failed");
		    	out.println("<a href=login.jsp>TRY AGAIN</a>");
		    }
		    	
		    
		   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	}

}
}
