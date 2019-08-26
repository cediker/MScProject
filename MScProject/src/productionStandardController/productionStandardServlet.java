package productionStandardController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelProductionStandard.productionStandard;

@WebServlet("/productionStandardServlet")
public class productionStandardServlet extends HttpServlet{
	@Override 
	protected void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws IOException,ServletException{
	    this.doPost(request,response);
	}
		 public void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {	 
			 	
			 productionStandard pstd = new productionStandard();
			 pstd.setProductionStandardName(request.getParameter("productionStandardName"));
			 pstd.setDescription(request.getParameter("description"));
 
			System.out.println(request.getParameter("productionStandardName"));
			System.out.println(request.getParameter("description"));
			
			ArrayList<HashMap<String, String>> ar = new ArrayList<HashMap<String, String>>();
			
			
		for(int i=2; i<21;i++){
			HashMap<String, String> data = new LinkedHashMap<>();
			
			String testMethod = request.getParameter("row["+i+"][test]");
			String min = request.getParameter("row["+i+"][min]");
			String max = request.getParameter("row["+i+"][max]");
			
			data.put("test", testMethod);
			data.put("min", min);
			data.put("max", max);
			
			ar.add(data);
		}
			
			System.out.println(ar);
		
			
		 }
	}
		

