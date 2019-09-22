package testMethodController;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelTestMethod.TestMethod;
import modelTestMethod.TestMethodDAO;



@WebServlet("/getAllTestMethods")
public class getAllTestMethods extends HttpServlet{
	
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
	    //creates a new instance of the TestMethodsDAO
		  TestMethodDAO TestMethodsDAO = new TestMethodDAO();
		  //creates an empty array list
		  ArrayList<TestMethod> allTestMethods = new ArrayList<TestMethod>();
		  
		  //calls method getAllTestMethods and assigns the result to all TestMethods
		  allTestMethods = TestMethodsDAO.getAllTestMethods();
		  //sets attribute
		  request.setAttribute("TestMethods", allTestMethods);
		  String outputPage;
		    
		  //sets content type
		  response.setContentType("application/json");
		  //sets output page
		  outputPage = "/WEB-INF/results/jsonTestMethods.jsp";
		    
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(outputPage);
		    dispatcher.include(request, response);
		    }
		  

		  public void doPost(HttpServletRequest request,
		                     HttpServletResponse response)
		      throws ServletException, IOException {
		    doGet(request, response);
		  }

}
