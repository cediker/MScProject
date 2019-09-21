package testMethodController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import modelTestMethod.TestMethodDAO;

@WebServlet("/deleteTestMethodServlet")
public class deleteTestMethodServlet extends HttpServlet {

	  @Override
	  public void doGet(HttpServletRequest request,
			  HttpServletResponse response) throws ServletException, IOException {
		  
		//gets the parameter entered into the form by the user
		  String testmethod = request.getParameter("TMid");
		  
		 //creates an instance of the ProductionStandardDAO
		  TestMethodDAO dao = new TestMethodDAO();
		 //calls the method delete film and passes in the parameter
		  dao.deleteTestMethod(testmethod);
		  
	  }
}
