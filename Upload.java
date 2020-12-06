package servlet;

import implementation.Implmnt1;
import interfaces.Interfaciii;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.text.BasicTextEncryptor;

import com.oreilly.servlet.multipart.FilePart;
import com.oreilly.servlet.multipart.MultipartParser;
import com.oreilly.servlet.multipart.Part;

/**
 * Servlet implementation class Upload
 */
@WebServlet("/Upload")
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		System.out.println("Upload Servlet Page");
		
		HttpSession h=request.getSession();
		String pkval=(String)h.getAttribute("pkey");
		System.out.println("pkval:"+pkval);
		
		int status=0;		
		
		Part part = null;
		
		FilePart filePart = null;		
		
		String key=null;
		
		String filename =null;
		
		String type = null;
		
		double fileSize=0.0;
		
		String filecontent="";
		
		
		String encryptedcontent="";
		String decryptedcontent="";
		
		
		MultipartParser mpp=new MultipartParser(request, 999999999);
		
		
        String realpath=getServletContext().getRealPath("/");
        
        System.out.println("RealPath ::"+realpath);
        
        
        String subpath=realpath.substring(0,realpath.indexOf("."));
        
        System.out.println("subpath ::"+subpath);
        
       
        String mainpath=subpath+"MJCC13_2019\\WebContent\\uploaddata\\File\\";
        
        while((part=mpp.readNextPart())!=null)
		{
			if(part.isFile())
			{
				filePart =(FilePart) part;
				
				filename= ((com.oreilly.servlet.multipart.FilePart) filePart).getFileName();
				
				System.out.println("filename:"+filename);
				
					
				mainpath=mainpath+filename;
				
				File uploadedFile = new File(mainpath);
				
				type =  ((com.oreilly.servlet.multipart.FilePart) filePart).getContentType();
				
				System.out.println("filetype:"+type);
				
				
				fileSize =  ((com.oreilly.servlet.multipart.FilePart) filePart).writeTo(uploadedFile);
				
				System.out.println("fileSize:"+fileSize);
				
				
				FileInputStream fileInputStream=new FileInputStream(uploadedFile);
				byte[] b=new byte[fileInputStream.available()];
				fileInputStream.read(b);
				String reading=new String(b);
				
				filecontent=filecontent+reading;
				
				System.out.println("filecontent:"+filecontent);
				
				
				//Encryption Technique:
			
				BasicTextEncryptor enc=new BasicTextEncryptor();
				
				/*IF WANTED DYNAMIC PASSWORD USE RANDOM KEY GENERATION 
				CONCEPT TO AVOID STATIC PASSWORD FOR MORE SECURITY*/
				
				Random ran=new Random();
				String s21="abcdefghijklmnopqrstuvwxyz";
				String s2="0123456789";
				char c1=s21.charAt(ran.nextInt(s21.length()));
				char c2=s2.charAt(ran.nextInt(s2.length()));
				char c3=s21.charAt(ran.nextInt(s21.length()));
				char c4=s2.charAt(ran.nextInt(s2.length()));
				 key=""+c3+c2+c4+c1;
				System.out.println("key : "+key);
							
				enc.setPassword(key);
				encryptedcontent=enc.encrypt(filecontent);
				decryptedcontent=enc.decrypt(encryptedcontent);
				
				System.out.println("ENCRYPT DATA:"+encryptedcontent);
				//System.out.println("DECRYPT DATA:"+decryptedcontent);

				//Code for creating Encrypted data to file
				
				String encpath=subpath+"MJCC13_2019\\WebContent\\uploaddata\\EncFile\\";
				
				FileOutputStream f1=new FileOutputStream(new File(encpath+filename));
			
					f1.write(encryptedcontent.getBytes());			
			}
			  
			ArrayList obj=new ArrayList();
			obj.add(pkval);
			obj.add(filename);
			obj.add(type);
			obj.add(fileSize);
			obj.add(filecontent);
			obj.add(encryptedcontent);
			obj.add(key);
			
			
		 //System.out.println("upload arrayobj : "+obj);
			
		 Interfaciii in=new Implmnt1();
		     
	     status=in.fileupload(obj);
		
		}
	if(status==1)
	{
		response.sendRedirect("dpuploadsucc.jsp");
		
	}
	else
	{
		response.sendRedirect("Error4.jsp");
	}

		
	}
		
	}


