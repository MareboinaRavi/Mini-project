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
 * Servlet implementation class Valid1
 */
@WebServlet("/Valid1")
public class Valid1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valid1() {
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
		
		String pub=request.getParameter("pk");
		String scr=request.getParameter("sk");
		
		try
		{
			
			Connection con=Dbconnect.connect();
			
			Statement st1=con.createStatement();
			
			String sr="select * from dpregister where pk='"+pub+"' and sk='"+scr+"'";
			
			ResultSet rs=st1.executeQuery(sr);
			while(rs.next())
			{	
				i=1;
			}
			if(i==1)
			{
				response.sendRedirect("dpupload.jsp?publickey:"+pub);
			}
			else
				
				response.sendRedirect("Error3.jsp");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
			
	}


