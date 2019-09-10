package testResultController;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import barcode.CreateQRCode;



	
	 
	@WebServlet("/AddTestResult")
	public class addTestResult extends HttpServlet {
		@Override 
		protected void doGet(HttpServletRequest request,HttpServletResponse response) 
		throws IOException,ServletException{
		    this.doPost(request,response);
		}
			 public void doPost(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException {	 
				
				String productionStandard = "Production Standard: " + request.getParameter("value");
				String jobNumber = "Job Number: " + request.getParameter("jobNumber");
				String roll = "Roll : " + request.getParameter("roll");
				
				CreateQRCode.createQRCode(jobNumber + ":"+ roll);
				
				//gets the HTTP encoded test parameter String
				String tr =	request.getParameter("testResult").toString();
				
				//split the URL on &
				String[] parts = tr.split("&");
				
				//declares array list
				ArrayList<String> myArray= new ArrayList<String>();
				
				//loops through parts array to decode each section
				for (String part : parts) {
					
				    try {
				    	//decodes the URL split data
					    String test = java.net.URLDecoder.decode(part, StandardCharsets.UTF_8.name());
					    myArray.add(test);
					    
					} catch (UnsupportedEncodingException e) {   
					}  
				}
			
			    //declares hashMap      
				Map<String,String> map = new HashMap<>();               
				
				//loops through array list, splits it using '=' and puts String sides into hashmap
				for (int i=0; i<myArray.size();i++){
					String str = myArray.get(i);
					String[] entry = str.split("=");                  
				    map.put(entry[0].trim(), entry[1].trim()); 
				}
				//works out map size and divides it by two
				int mapSize = (map.size()/2);
				
				//loops to add variables to database
				for (int j=0; j<mapSize;j++){
					System.out.println(productionStandard);
					System.out.println(jobNumber);
					System.out.println(roll);
				    System.out.println(map.get("items["+j+"][name]"));
				    System.out.println(map.get("items["+j+"][value]"));
				}
					
			
			 }
		}
			

