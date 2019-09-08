package testResultController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import barcode.CreateQRCode;
import modelProductionStandard.ProductionStandard;
import modelProductionStandard.ProductionStandardDAO;
import modelTestResult.TestResult;
import modelTestResult.TestResultDAO;
	
	 
	@WebServlet("/AddTestResult")
	public class addTestResult extends HttpServlet {
		@Override 
		protected void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws IOException,ServletException{
		    this.doPost(request,response);
		}
			 public void doPost(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {	 
				//declares variables and sets them to null
				
				System.out.println("Production Standard: " + request.getParameter("value"));
				System.out.println("Job Number: " + request.getParameter("jobNumber"));
				System.out.println("Roll : " + request.getParameter("roll"));
				//CreateQRCode.createQRCode(request.getParameter("value"));
				 
				
				System.out.println(request.getParameter("items[0][name]"));
				
				Enumeration<String> params = request.getParameterNames(); 
				while(params.hasMoreElements()){
				 String paramName = params.nextElement();
				 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
				}
			
			 }
		}
			

