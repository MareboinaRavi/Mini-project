package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
/**
 * Servlet implementation class Usrequest
 */
@WebServlet("/Request")
public class Request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("SERVLET REQUEST");
		String name=request.getParameter("unme");
		String pwd=request.getParameter("email");
		System.out.println("reqname:"+name);
		System.out.println("reqpwd:"+pwd);
		 
		String status="invalid";
		
		
			 try {
				Class.forName("com.mysql.jdbc.Driver");
		
			    Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mjcc13_2019","root","root");
				
			 	PreparedStatement ps11=con.prepareStatement("insert into userrequest values(?,?,?)");
			 	ps11.setString(1, name);
			 	ps11.setString(2, pwd);
			 	ps11.setString(3, status);
			 	int i=ps11.executeUpdate();
			 
			 	if(i==1)
			 		response.sendRedirect("search.jsp");
			 	else
			 		response.sendRedirect("notvalid.jsp");
			 	
			 }catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
	}

}
