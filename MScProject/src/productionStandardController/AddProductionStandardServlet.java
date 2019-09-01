package productionStandardController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelProductionStandard.ProductionStandard;
import modelProductionStandard.ProductionStandardDAO;

@WebServlet("/productionStandardServlet")
public class AddProductionStandardServlet extends HttpServlet{
	@Override 
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws IOException,ServletException{
	    this.doPost(request,response);
	}
		 public void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {	 
			 	
	
 
			System.out.println(request.getParameter("productionStandardName"));
			System.out.println(request.getParameter("description"));
			
			
			String TestMethod = null;
			String min = null;
			String max = null;
			
		for(int i=2; i<21;i++){
			ProductionStandard pstd = new ProductionStandard();
			pstd.setProductionStandardName(request.getParameter("productionStandardName"));
			pstd.setDescription(request.getParameter("description"));
			Date today = Calendar.getInstance().getTime();
			pstd.setDateCreated(today.toString());
		 	pstd.setTestMethod(request.getParameter("row["+i+"][test]"));
			pstd.setMinimum(request.getParameter("row["+i+"][min]"));
			pstd.setMaximum(request.getParameter("row["+i+"][max]"));
			
			//creates instance of ProductionStandardDAO
			ProductionStandardDAO dao = new ProductionStandardDAO();
			//calls the method insert ProductionStandard
			dao.insertProductionStandard(pstd);
		}
			
		
			
		 }
	}
		

