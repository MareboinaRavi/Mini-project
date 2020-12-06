package servlet;

import implementation.Implmnt1;
import interfaces.Interfaciii;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register1
 */
@WebServlet("/Register1")
public class Register1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register1() {
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
		
		String name=request.getParameter("username");
		String pwd=request.getParameter("password");
		String cpwd=request.getParameter("cpassword");
		
		String mailid=request.getParameter("mailid");
		
		String city=request.getParameter("slct");
		String addrs=request.getParameter("address");
		
		ArrayList<String> a=new ArrayList<String>();
		a.add(name);
		a.add(pwd);
		a.add(cpwd);
		
		a.add(mailid);
		a.add(city);
		a.add(addrs);
		
		Interfaciii in=new Implmnt1();
		int i=in.dpregister(a);
		
		if(i==1)
		{
			response.sendRedirect("dppubkey.jsp?mailid= "+mailid);
		}
		else
			
			response.sendRedirect("Error1.jsp");
		
	}

}
