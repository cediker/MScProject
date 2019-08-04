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

@WebServlet("/getTestResultByJobNumber")
public class getTestResultByJobNumber extends HttpServlet {


	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		  
		  //gets parameter jobNumber and assigns the value to the variable jobNumber
		  testResultDAO testResultDAO = new testResultDAO();
		  ArrayList<TestResult> testResult = new ArrayList<>();
		 
		  int jobNumber = Integer.parseInt(request.getParameter("id"));
		  
		  //calls method getTestResultByJobNumber()
		  testResult = testResultDAO.getTestResultByJobNumber(jobNumber);
		  
		  request.setAttribute("TestResults", testResult);
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
