package converter;

import java.util.ArrayList;
import java.util.Iterator;
import com.google.gson.Gson;

import model.TestResult;
import modelDAO.testResultDAO;

public class JSONConverter {
	

	public class FilmToJSON {
		public void ArrayToJSON(TestResult tr) {

			// Creates a new array list object
			ArrayList<TestResult> allfilms = new ArrayList<>();

			testResultDAO dao = new testResultDAO();
			allfilms = dao.getAllTestResults();
			// Iterate through all test results using toString()
		
			for (Iterator<TestResult> iterator = allfilms.iterator(); iterator.hasNext();) {
				TestResult tres = (TestResult) iterator.next();
				System.out.println(tres.toString());
				Gson gson = new Gson();
				String tresJSON = gson.toJson(tres);
				System.out.println(tresJSON);
		}
			
	}
	}
}
