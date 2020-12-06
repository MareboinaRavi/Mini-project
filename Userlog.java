package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.Dbconnect;

/**
 * Servlet implementation class Userlog
 */
@WebServlet("/Userlog")
public class Userlog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlog() {
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
	
		 int i=0;
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		String nme=null;
		String email=null;
		try
		{
			
			Connection con=Dbconnect.connect();
			
			Statement st1=con.createStatement();
			
			String sr="select * from duregister where name='"+name+"' and password='"+pwd+"'";
			
			ResultSet rs=st1.executeQuery(sr);
			while(rs.next())
			{
				 nme=rs.getString(1);
				 email=rs.getString(4);
				i=1;
			}
			if(i==1)
			{
				response.sendRedirect("duaccreq.jsp?nme="+nme+"&email="+email+"");
			}
			else
				
				response.sendRedirect("Error6.jsp");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
