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

@WebServlet("/deleteProductionStandard")
public class DeleteProductionStandardServlet extends HttpServlet {
	
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		//gets the parameter entered into the form by the user
		  String productionStandard = request.getParameter("productionStandard");
		  
		 //creates an instance of the ProductionStandardDAO
		  ProductionStandardDAO ProductionStandardsDAO = new ProductionStandardDAO();
		 //calls the method delete film and passes in the parameter
		  ProductionStandardsDAO.deleteProductionStandard(productionStandard);
		  
	  }
				 
}