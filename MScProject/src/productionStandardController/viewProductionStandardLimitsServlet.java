package productionStandardController;

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


@WebServlet("/viewProductionStandardLimitsServlet")
public class viewProductionStandardLimitsServlet extends HttpServlet {
	String productionStandard;
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		 //gets production standard parameter
		  String part = request.getParameter("productionStandard").toString();
		 //gets test method parameter
		  String part1 = request.getParameter("testMethod").toString();
		  //decodes parameters and assigns the result to String variables
		  String productionStandard = java.net.URLDecoder.decode(part, StandardCharsets.UTF_8.name());
		  String testMethod = java.net.URLDecoder.decode(part1, StandardCharsets.UTF_8.name());
		 
		  //creates a new instance of ProductionStandardDAO
		  ProductionStandardDAO ProductionStandardsDAO = new ProductionStandardDAO();
		  //declares a new array list
		  ArrayList<ProductionStandard> allProductionStandards = new ArrayList<>();
		  
		  //calls getProductionStandardTestMethodByName and assigns the result to allProductionStandards
		  allProductionStandards = ProductionStandardsDAO.getProductionStandardTestMethodByName(productionStandard, testMethod);
		
		  //sets attribute
		  request.setAttribute("ProductionStandards", allProductionStandards);
		  
		   //declares output page
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