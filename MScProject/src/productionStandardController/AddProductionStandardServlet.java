package productionStandardController;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import barcode.CreateQRCode;
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
			//declares variables and sets them to null
			
			CreateQRCode.createQRCode(request.getParameter("productionStandardName"));
			 
			
			Enumeration<String> params = request.getParameterNames(); 
			while(params.hasMoreElements()){
			 String paramName = params.nextElement();
			 System.out.println("Parameter Name - "+paramName+", Value - "+request.getParameter(paramName));
			}
			
			
			int i = 2;
			while(request.getParameter("row["+i+"][test]")!= null){
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
				i++;
			}
		
			
		 }
	}
		

