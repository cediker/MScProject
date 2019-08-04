package model;

import java.util.ArrayList;
import modelDAO.testResultDAO;

public class DatabaseTester {
public static void main(String[] args) {
		

		ArrayList<TestResult> test = new ArrayList<>();
		testResultDAO dao = new testResultDAO();
		
		
		test = dao.getAllTestResults();
		System.out.println(test);

	}
		
}
	
	

