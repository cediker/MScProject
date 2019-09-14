package modelTestResult;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import modelTestResult.TestResult;

/**
 * this class is the data access object
 * 
 * * @author Chrissie Ediker
 *
 */

public class TestResultDAO {

	/**
	 * this method forms a connection to the database
	 * 
	 * @return
	 */

	TestResult oneTestResult = null;
	Connection conn = null;
	Statement stmt = null;

	private void openConnection() {
		// loading jdbc driver for mysql
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (Exception e) {
			System.out.println(e);
		}

		// connecting to database
		try {
			// connection string for database, username , password
			conn = DriverManager.getConnection("jdbc:mysql://104.155.111.28:3306/QualityControl", "root", "Tullis200");
			stmt = conn.createStatement();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

	private void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private TestResult getNextTestResult(ResultSet rs) {
		TestResult thisTestResult = null;
		try {
			thisTestResult = new TestResult();
			thisTestResult.setjobNumber(rs.getString("jobNumber"));
			thisTestResult.setRoll(rs.getString("roll"));
			thisTestResult.setProductionStandard(rs.getString("productionStandard"));
			thisTestResult.setTestMethod(rs.getString("testMethod"));
			thisTestResult.setTestResult(rs.getString("testResult"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return thisTestResult;
	}


	
	public ArrayList<TestResult> getTestResultByJobNumber(int jobNumber) {
		ArrayList<TestResult> allTestResults = new ArrayList<TestResult>();
		openConnection();
		
		// Create select statement and execute it
		try {
			
			String selectSQL = "select * from TestResult where jobNumber = " + jobNumber + ";";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while (rs1.next()) {
				oneTestResult = getNextTestResult(rs1);
				allTestResults.add(oneTestResult);
			}
			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		return allTestResults;
	}
	
	
	public void insertTestResult(TestResult tr) {
	
		openConnection();
		Date today = Calendar.getInstance().getTime();
		String dateTime = today.toString();
		
		System.out.println("in insert test result");
		// Create select statement
		try {
			String selectSQL = "INSERT INTO TestResult (JobNumber, Roll, ProductionStandard, dateTimeSubmit, TestMethod, TestResult) VALUES ('"+ tr.getJobNumber() + "','" + tr.getRoll() + "','" +  tr.getProductionStandard() + "','" + dateTime + "','" + tr.getTestMethod() + "','"  + tr.getTestResult() + "');";
			// executes statement
			stmt.executeUpdate(selectSQL);
			// close statement
			stmt.close();
			// closes connection
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}

}

