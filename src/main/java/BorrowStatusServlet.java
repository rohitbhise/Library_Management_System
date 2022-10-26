

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


@WebServlet("/BorrowStatusServlet")
public class BorrowStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    //String n= request.getParameter("member_id");
		    //String p= request.getParameter("payment_status");
		   // int x=Integer.parseInt(request.getParameter("book_id"));
		    int y=Integer.parseInt(request.getParameter("member_id"));
		    PreparedStatement ps=con.prepareStatement("select * from Borrower where Member_Id=?");
		   // ps.setString(2, p);
		    ps.setInt(1, y);
		    
		    
		    
		    ResultSet rs= ps.executeQuery();
		    if(rs.next())
		    {
		    	out.println("<h1 align=center>YOU HAVE BORRWED BOOKS:</h1>");
		    	out.print("book id"+"  ");
		    	out.println("borrowed date"+"  ");
		    	
		    	out.print(rs.getInt("Book_Id")+" ");
		    	out.println(rs.getString("Borrow_date")+" ");
		    	//out.println("<a href=IssueBook.jsp>TRY AGAIN</a>");
		    	
		    }
		    else
		    {   
		    	out.print("NO BORROWED BOOKS");
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
