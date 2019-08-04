package modelTestResult;

import java.util.ArrayList;

public class DatabaseTester {
public static void main(String[] args) {
		

		ArrayList<TestResult> test = new ArrayList<>();
		TestResultDAO dao = new TestResultDAO();
		
		
		test = dao.getAllTestResults();
		System.out.println(test);

	}
		
}
	
	

