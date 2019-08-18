package productionStandardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/productionStandardServlet")
public class productionStandardServlet extends HttpServlet{

		 public void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {	 
			 	
			System.out.println("I'm in the servlet");
		
			
			 System.out.println(request.getParameter("productionStandardName"));
			 System.out.println(request.getParameter("description"));
			 
			 String[] array;
			 
			 array = request.getParameterValues("row");
			 
			 for(int i=0; i<array.length; i++){
				 System.out.println(array[i]);
			 }
			 
		  }
	}
		

