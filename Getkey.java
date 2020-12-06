package servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Getkey
 */
@WebServlet("/Getkey")
public class Getkey extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Getkey() {
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
	
	String fn1=request.getParameter("fnnmee");
	
	System.out.println("getkeyfile value :"+fn1);
	
	String key=null;
	
	int i=0;
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
        
		Connection con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mjcc13_2019","root","root");
	
	Statement s1=con.createStatement();
	
	String query1="select * from block where filename='"+fn1+"'";
	
	ResultSet rs=s1.executeQuery(query1);
	
	while(rs.next())
	{
		key=rs.getString(6);
		i=1;
	}
	
	if(i==1)
	{
		
		response.sendRedirect("keydisp1.jsp?key="+key);
	
	}
	
	else
	{
		response.sendRedirect("nokey.jsp ");
	}
	}catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
