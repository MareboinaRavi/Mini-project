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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 String pk1=null;
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		
		try
		{
			
			Connection con=Dbconnect.connect();
			
			Statement st1=con.createStatement();
			
			String sr="select * from dpregister where name='"+name+"' and password='"+pwd+"'";
			
			ResultSet rs=st1.executeQuery(sr);
			while(rs.next())
			{
				
				pk1=rs.getString(7);
				i=1;
			}
			if(i==1)
			{
				response.sendRedirect("dpsrtkey.jsp?pk1="+pk1);
			}
			else
				
				response.sendRedirect("Error2.jsp");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	}


