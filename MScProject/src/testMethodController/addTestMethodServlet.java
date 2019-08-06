package testMethodController;


import java.io.IOException;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelTestMethod.TestMethodDAO;
import modelTestMethod.TestMethod;

/**
 * Servlet implementation class AddTestMethod 
 */
@WebServlet("/addTestMethodServlet")
public class addTestMethodServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		 	//creates new TestMethod object
		 
		
		 
		 
		 	TestMethod newTestMethod = new TestMethod();
		 	newTestMethod.setTestMethodId("TM000");
			newTestMethod.setDocumentNumber(request.getParameter("documentNumber"));
			newTestMethod.setDocumentTitle(request.getParameter("documentTitle"));
			newTestMethod.setUnit(request.getParameter("unit"));
			//creates instance of TestMethodDAO
			TestMethodDAO dao = new TestMethodDAO();
			//calls the method insert TestMethod
		
			
			 System.out.println(request.getParameter("Id"));
			 System.out.println(request.getParameter("documentNumber"));
			 System.out.println(request.getParameter("documentTitle"));
			 System.out.println(request.getParameter("unit"));
			 
			 
			 
			dao.insertTestMethod(newTestMethod);
			
			response.getWriter().println("TestMethod added!");
		 
	  }
}
	
