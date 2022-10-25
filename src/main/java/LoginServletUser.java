

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
 * Servlet implementation class LoginServletUser
 */
@WebServlet("/LoginServletUser")
public class LoginServletUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/DBMS_PROJECT","Rohit","sudhakaR123");
		    String n= request.getParameter("txtName");
		    String p= request.getParameter("txtPwd");
		    PreparedStatement ps=con.prepareStatement("select Member_Name from members where Member_Name=? and password=?");
		    ps.setString(1, n);
		    ps.setString(2, p);
		    ResultSet rs= ps.executeQuery();
		    if(rs.next())
		    {
		    	RequestDispatcher rd= request.getRequestDispatcher("User_Welcome.jsp");
		    	rd.forward(request,response);
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
