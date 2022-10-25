
import java.util.*;
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
 * Servlet implementation class BookIssueServlet
 */
@WebServlet("/BookIssueServlet")
public class BookIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    String n= request.getParameter("member_name");
		    String p= request.getParameter("book_name");
		    int x=Integer.parseInt(request.getParameter("book_id"));
		    int y=Integer.parseInt(request.getParameter("member_id"));
		    PreparedStatement ps=con.prepareStatement("insert into borrower values(?,?,?,curdate())");
		    //ps.setString(1, n);
		    ps.setString(3, p);
		    ps.setInt(1, x);
		    ps.setInt(2, y);
		    
		    
		    int rs= ps.executeUpdate();
		    if(rs==0)
		    {
		    	out.println("error pls try again");
		    	out.println("<a href=IssueBook.jsp>TRY AGAIN</a>");
		    }
		    else
		    {   
		    	 ps=con.prepareStatement("update Books set status=? where Book_Name=?");
				    //ps.setString(1, n);
				    ps.setString(1, "taken");
				    
				    ps.setString(2, p);
				     rs= ps.executeUpdate();
				     if(rs==0)
				     {
				    	 out.println("error pls try again");
					    out.println("<a href=IssueBook.jsp>TRY AGAIN</a>");
				     }
				     else
				     {
				    	 RequestDispatcher rd= request.getRequestDispatcher("admin_welcome.jsp");
					      rd.forward(request,response);
				     }
		    	
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
