package modelTestMethod;

//imports
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class TestMethodDAO {



		/**
		 * this method forms a connection to the database
		 * 
		 * @return
		 */

		TestMethod oneTestMethod = null;
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

		private TestMethod getNextTestMethod(ResultSet rs) {
			TestMethod thisTestMethod = null;
			try {
				thisTestMethod = new TestMethod();
				thisTestMethod.setTestMethodId(rs.getString("TestMethodId"));
				thisTestMethod.setDocumentNumber(rs.getString("DocumentNumber"));
				thisTestMethod.setDocumentTitle(rs.getString("DocumentTitle"));
				thisTestMethod.setUnit(rs.getString("Units"));
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();

			}
			
			return thisTestMethod;
		}

		public ArrayList<TestMethod> getAllTestMethods() {

			ArrayList<TestMethod> allTestMethods = new ArrayList<TestMethod>();
			openConnection();
			// Create select statement and execute it
			try {
				String selectSQL = "select * from TestMethod;";
				ResultSet rs1 = stmt.executeQuery(selectSQL);
			
				// Retrieve the results
				while (rs1.next()) {
					oneTestMethod = getNextTestMethod(rs1);
					allTestMethods.add(oneTestMethod);
				}
				stmt.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}
			
			return allTestMethods;
		}
		
		public ArrayList<TestMethod> getTestMethodByJobNumber(int jobNumber) {
			ArrayList<TestMethod> allTestMethods = new ArrayList<TestMethod>();
			openConnection();
			
			// Create select statement and execute it
			try {
				
				String selectSQL = "select * from TestMethod where DocumentTitle Like " + "%"+ jobNumber + "%;";
				ResultSet rs1 = stmt.executeQuery(selectSQL);
				// Retrieve the results
				while (rs1.next()) {
					oneTestMethod = getNextTestMethod(rs1);
					allTestMethods.add(oneTestMethod);
				}
				stmt.close();
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}
			return allTestMethods;
		}


		
		
		
		public void insertTestMethod(TestMethod tm) {
			String newTestMethodNo = null;
			openConnection();
		
			try {
				String maxTestMethodID = "SELECT MAX(TestMethodID) FROM TestMethod;";
				// executes the SQL query
				ResultSet rs1 = stmt.executeQuery(maxTestMethodID);
				// loop to return SQL result set
				while (rs1.next()) {
					// assigns the result of the SQL query to the variable result
					String result = rs1.getString(1);
					//removes the prefix TM- with nothing and parses the result to an integer
					int intData = Integer.parseInt(result.replace("TM-", ""));
					//increments the integer by 1
					intData++;
					//concatenates the prefix TM- with the new integer
					newTestMethodNo = "TM-" + intData;
					
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			
			// Create select statement
			try {
				String selectSQL = "INSERT INTO TestMethod (TestMethodId, DocumentNumber, DocumentTitle, Units) VALUES ('"+ newTestMethodNo +"','" + tm.getDocumentNumber() + "','" + tm.getDocumentTitle() + "','" + tm.getUnit() + "');";
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

		
		
		
		
		  //this method deletes a test method based on ID
		public void deleteTestMethod(String testMethodId) {

			openConnection();
			// Create select statement and execute it
			try {
				String sql = "DELETE from testMethodId where id = " + testMethodId + ";";
				stmt.executeUpdate(sql);
				// closes SQL statement
				stmt.close();
				// closes connection
				closeConnection();
			} catch (SQLException se) {
				System.out.println(se);
			}
		}
	}



