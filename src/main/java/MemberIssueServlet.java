

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberIssueServlet
 */
@WebServlet("/MemberIssueServlet")
public class MemberIssueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    String n= request.getParameter("member_name");
		    String p= request.getParameter("payment_status");
		   // int x=Integer.parseInt(request.getParameter("book_id"));
		    //int y=Integer.parseInt(request.getParameter("member_id"));
		    PreparedStatement ps=con.prepareStatement("insert into Members(Member_Name,Join_Date,Payment_Status) values(?,curdate(),?);");
		    ps.setString(2, p);
		    ps.setString(1, n);
		    
		    
		    
		    int rs= ps.executeUpdate();
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
		    	
		    
		   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}

}
}
