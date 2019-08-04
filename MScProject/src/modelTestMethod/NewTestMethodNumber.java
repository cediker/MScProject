package modelTestMethod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NewTestMethodNumber {
	Connection conn;
	Statement stmt;

	

	public void insertTestMethod() {
		
		String maxTestMethodID = "SELECT MAX(TestMethodID) FROM TestMethod;";

		try {
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
				String newTestMethodNo = "TM-" + intData;
				System.out.println(newTestMethodNo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
