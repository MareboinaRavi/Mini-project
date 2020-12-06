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
 * Servlet implementation class Instant
 */
@WebServlet("/Instant")
public class Instant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Instant() {
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
	
		String deckey=request.getParameter("deckey");
		System.out.println("Original deckey:"+deckey);
		String inskey=request.getParameter("inskey");
		System.out.println("Original inskey:"+inskey);
		String filname=null;
		int i=0;
		
		try
		{
			
			Connection con=Dbconnect.connect();
			
			Statement st1=con.createStatement();
			
			String sr="select filename from upload where filekey='"+deckey+"' and instantkey='"+inskey+"'";
			
			ResultSet rs=st1.executeQuery(sr);
			while(rs.next())
			{
				
				filname=rs.getString(1);
				i=1;
			}
			
			if(i==1)
			{
				
				response.sendRedirect("download1.jsp?filname="+filname);
			}
			else
				
				response.sendRedirect("Error7.jsp");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
