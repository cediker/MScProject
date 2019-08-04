package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelTestResult.TestResult;
import modelTestResult.testResultDAO;
	
	 
	@WebServlet("/getAllTestResults")
	public class getAllTestResults extends HttpServlet {
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
	    //creates a new instance of the TestResultsDAO
		  testResultDAO TestResultsDAO = new testResultDAO();
		  //creates an empty array list
		  ArrayList<TestResult> allTestResults = new ArrayList<TestResult>();
		  
		  //calls method getAllTestResultss and assigns the result to all TestResultss
		  allTestResults = TestResultsDAO.getAllTestResults();
		    request.setAttribute("TestResults", allTestResults);
		    String outputPage;
		    
		    
		     response.setContentType("application/json");
		     outputPage = "/WEB-INF/results/json.jsp";
		    
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
