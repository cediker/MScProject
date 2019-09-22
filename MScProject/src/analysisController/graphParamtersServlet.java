package analysisController;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelProductionStandard.ProductionStandard;
import modelProductionStandard.ProductionStandardDAO;
import modelTestResult.TestResult;
import modelTestResult.TestResultDAO;

@WebServlet("/graphParameters")
public class graphParamtersServlet extends HttpServlet {
	
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		//gets production standard parameter
		String productionStandard = request.getParameter("productionStandard");
		//gets test method parameter
		String testMethod = request.getParameter("testMethod");
		//declares test result variable
		String testResult = null;
		//declares a new instance of TestResultDAO
		TestResultDAO dao = new TestResultDAO();
		//declares a new array list
		ArrayList<TestResult> allTestResults = new ArrayList();
		//calls getTestResultsByPrdStdAndTestMethod and assigns the result to allTestResults
		allTestResults = dao.getTestResultsByPrdStdAndTestMethod(productionStandard, testMethod);
		
		//for loop 
		for(int i=0; i<allTestResults.size();i++){
			//loops through elements and gets the test result element
			testResult = allTestResults.get(i).getTestResult();
		}
		
		//sets attribute
		  request.setAttribute("TestResults", allTestResults);
		//declares output page 
		   String outputPage;
		    
		   response.setContentType("application/json");
		   outputPage = "/WEB-INF/results/jsonTestResults.jsp";
		    
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