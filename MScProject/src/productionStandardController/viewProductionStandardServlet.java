package productionStandardController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import converter.JSONConverter;
import modelProductionStandard.ProductionStandard;
import modelProductionStandard.ProductionStandardDAO;
import modelTestMethod.TestMethod;
import modelTestResult.TestResult;

@WebServlet("/viewProductionStandard")
public class viewProductionStandardServlet extends HttpServlet {
	
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		
		  String productionStandard = request.getParameter("productionStandard");
		  
		 
		  ProductionStandardDAO ProductionStandardsDAO = new ProductionStandardDAO();
		  ArrayList<ProductionStandard> allProductionStandards = new ArrayList<>();
		  
		  allProductionStandards = ProductionStandardsDAO.getProductionStandardByName(productionStandard);
		  
		  request.setAttribute("ProductionStandards", allProductionStandards);
		  
		   
		   String outputPage;
		    
		   response.setContentType("application/json");
		   outputPage = "/WEB-INF/results/jsonProductionStandards.jsp";
		    
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