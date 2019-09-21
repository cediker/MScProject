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




@WebServlet("/analysisTestMethodSelect")
public class analysisTestMethodSelectServlet extends HttpServlet {
	String productionStandard;
	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		  
		  String productionStandard = java.net.URLDecoder.decode(request.getParameter("productionStandard").toString(), StandardCharsets.UTF_8.name());
		  
		  ProductionStandardDAO dao = new ProductionStandardDAO();
		  
		  ArrayList<ProductionStandard> allProductionStandards = new ArrayList<>();
		  
		 
		  allProductionStandards = dao.getTestMethodsByProductionStandardName(productionStandard);
		  
	
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
