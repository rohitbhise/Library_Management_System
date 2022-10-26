

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.CallableStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BookReturnServlet
 */
@WebServlet("/BookReturnServlet")
public class BookReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    //String n= request.getParameter("member_name");
		    //String p= request.getParameter("book_name");
		    int x=Integer.parseInt(request.getParameter("book_id"));
		    int y=Integer.parseInt(request.getParameter("member_id"));
		    /*PreparedStatement ps=con.prepareStatement("call get_amount(?,?)");
		    //ps.setString(1, n);
		   // ps.setString(3, p);
		    ps.setInt(1, y);
		    ps.setInt(2, x);
		    */
		    String query = "{CALL get_amount(?,?)}";
		    CallableStatement stmt = (CallableStatement) con.prepareCall(query);
		    stmt.setInt(1,y);
		    stmt.setInt(2, x);
		    ResultSet rs = stmt.executeQuery();
		  
		    PreparedStatement ps=con.prepareStatement("update Books set status=? where Book_Id=? ");
		    ps.setString(1, "available");
		    
		    ps.setInt(2, x);
		    rs= ps.executeQuery();
		    
		    ps=con.prepareStatement("select * from Fine where Member_Id=? and Book_Id=?");
		    ps.setInt(1, y);
		    ps.setInt(2, x);
		    rs= ps.executeQuery();
		    
		    if(rs.next())
		    {
		    	out.println(rs.getString("Amount"));
		    	//out.println("<a href=IssueBook.jsp>TRY AGAIN</a>");
		    }
		    else
		    {   
		    	
		    	out.println("NO FINE BOOK RETURNED SUCCESSFULLY");
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
