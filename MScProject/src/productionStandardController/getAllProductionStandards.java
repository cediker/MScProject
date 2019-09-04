package productionStandardController;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelProductionStandard.ProductionStandard;
import modelProductionStandard.ProductionStandardDAO;



@WebServlet("/getAllProductionStandards")
public class getAllProductionStandards extends HttpServlet{
	
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		  
		  System.out.println("Im here");
	    //creates a new instance of the ProductionStandardsDAO
		  ProductionStandardDAO ProductionStandardsDAO = new ProductionStandardDAO();
		  //creates an empty array list
		  ArrayList<ProductionStandard> allProductionStandards = new ArrayList<ProductionStandard>();
		  
		  //calls method getAllProductionStandards and assigns the result to all ProductionStandards
		  allProductionStandards = ProductionStandardsDAO.getAllProductionStandards();
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
