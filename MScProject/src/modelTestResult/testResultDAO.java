package modelTestResult;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * this class is the data access object
 * 
 * * @author Chrissie Ediker
 *
 */

public class testResultDAO {

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
			// connection string for demos database, username demos, password
			// demos
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/QualityControl", "root", "Tullis200");
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
			thisTestResult.setId(rs.getInt("ID"));
			thisTestResult.setjobNumber(rs.getInt("jobNumber"));
			thisTestResult.setRoll(rs.getString("roll"));
			thisTestResult.setProductionStandard(rs.getString("productionStandard"));
			thisTestResult.setGrammageBasePaper(rs.getString("grammageBasePaper"));
			thisTestResult.setGrammageRelease(rs.getString("grammageRelease"));
			thisTestResult.setCoatWeightAdhesive(rs.getString("coatWeightAdhesive"));
			thisTestResult.setCoatWeightCoating(rs.getString("coatWeightCoating"));
			thisTestResult.setCoatWeightGumBarrier(rs.getString("coatWeightGumBarrier"));
			thisTestResult.setGrammageTotalSubstance(rs.getString("grammageTotalSubstance"));
			thisTestResult.setCaliperBasePaper(rs.getString("caliperBasePaper"));
			thisTestResult.setCaliperRelease(rs.getString("caliperRelease"));
			thisTestResult.setCaliperTotal(rs.getString("caliperTotal"));
			thisTestResult.setTensileStrengthMachineDirection(rs.getString("tensileStrengthMachineDirection"));
			thisTestResult.setTensileStrengthCrossDirection(rs.getString("tensileStrengthCrossDirection"));
			thisTestResult.setTearingResistanceMachineDirection(rs.getString("tearingResistanceMachineDirection"));
			thisTestResult.setTensileStrengthCrossDirection(rs.getString("tensileStrengthCrossDirection"));
			thisTestResult.setMoistureContent(rs.getString("moistureContent"));
			thisTestResult.setOpacity(rs.getString("opacity"));
			thisTestResult.setPickingResistanceDennisonWax(rs.getString("pickingResistanceDennisonWax"));
			thisTestResult.setWaterAbsorptionCobb(rs.getString("waterAbsorptionCobb"));
			thisTestResult.setPickingResistanceIGTmvo(rs.getString("pickingResistanceIGTmvo"));
			thisTestResult.setPickingResistanceIGTlvo(rs.getString("pickingResistanceIGTlvo"));
			thisTestResult.setInkAbsorbencyIGTStainLength(rs.getString("inkAbsorbencyIGTStainLength"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return thisTestResult;
	}

	public ArrayList<TestResult> getAllTestResults() {

		ArrayList<TestResult> allTestResults = new ArrayList<TestResult>();
		openConnection();
		// Create select statement and execute it
		try {
			String selectSQL = "select * from TestResult;";
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


/*	public void insertFilm(Film myFilm) {

		openConnection();
		// Create select statement
		try {
			String selectSQL = "INSERT INTO films (id, title, year, director, stars, review) VALUES ('" + myFilm.getId()
					+ "','" + myFilm.getTitle() + "','" + myFilm.getYear() + "','" + myFilm.getDirector() + "','"
					+ myFilm.getStars() + "','" + myFilm.getReview() + "');";
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

	*//**
	 * this method deletes a film based on ID
	 * 
	 * @param id film ID from within database
	 *//*
	public void deleteFilm(int id) {

		openConnection();
		// Create select statement and execute it
		try {
			String sql = "DELETE from films where id = " + id + ";";
			stmt.executeUpdate(sql);
			// closes SQL statement
			stmt.close();
			// closes connection
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}*/
}
