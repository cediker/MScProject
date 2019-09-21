package modelProductionStandard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProductionStandardDAO {

	/**
	 * this method forms a connection to the database
	 * 
	 * @return
	 */

	ProductionStandard oneProductionStandard = null;
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

	private ProductionStandard getNextProductionStandard(ResultSet rs) {
		ProductionStandard thisProductionStandard = null;
		try {
			thisProductionStandard = new ProductionStandard();
			thisProductionStandard.setProductionStandardID(rs.getString("ID"));
			thisProductionStandard.setDateCreated(rs.getString("dateCreated"));
			thisProductionStandard.setCreator(rs.getString("creator"));
			thisProductionStandard.setProductionStandardName(rs.getString("productionStandardName"));
			thisProductionStandard.setDescription(rs.getString("ProductionStandardDescription"));
			thisProductionStandard.setComment(rs.getString("comment"));
			thisProductionStandard.setTestMethod(rs.getString("testMethod"));
			thisProductionStandard.setMinimum(rs.getString("minimum"));
			thisProductionStandard.setMaximum(rs.getString("maximum"));
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return thisProductionStandard;
	}
	
	
	

	public ArrayList<ProductionStandard> getAllProductionStandards() {

		ArrayList<ProductionStandard> allProductionStandards = new ArrayList<ProductionStandard>();
		openConnection();
		// Create select statement and execute it
		try {
			String selectSQL = "select distinct ProductionStandardName from ProductionStandard;";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
		
			// Retrieve the results
			while (rs1.next()) {
				oneProductionStandard = getNextProductionStandardName(rs1);
				allProductionStandards.add(oneProductionStandard);
			}
			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		
		System.out.println(allProductionStandards);
		return allProductionStandards;
	}
	
	
	
	public ArrayList<ProductionStandard> getTestMethodsByProductionStandardName(String productionStandard) {
		
		openConnection();
		ArrayList<ProductionStandard> allProductionStandards = new ArrayList<>();
		// Create select statement and execute it
		try {
			String selectSQL = "SELECT DISTINCT TestMethod FROM ProductionStandard WHERE ProductionStandardName = '" + productionStandard + "';";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while (rs1.next()) {
				oneProductionStandard = getNextTestMethodName(rs1);
				allProductionStandards.add(oneProductionStandard);
			}
			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		return allProductionStandards;
	}
	
	
	
	
	
	public ArrayList<ProductionStandard> getProductionStandardByName(String productionStandard) {
		
		openConnection();
		ArrayList<ProductionStandard> allProductionStandards = new ArrayList<>();
		// Create select statement and execute it
		try {
			String selectSQL = "SELECT * FROM ProductionStandard WHERE ProductionStandardName = '" + productionStandard + "';";
			ResultSet rs1 = stmt.executeQuery(selectSQL);
			// Retrieve the results
			while (rs1.next()) {
				oneProductionStandard = getNextProductionStandard(rs1);
				allProductionStandards.add(oneProductionStandard);
			}
			stmt.close();
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
		return allProductionStandards;
	}
	


	
	
	
	public void insertProductionStandard(ProductionStandard pstd) {
		openConnection();
	
		// Create select statement
		try {
			String selectSQL = "INSERT INTO ProductionStandard (ProductionStandardName, ProductionStandardDescription, DateCreated, TestMethod, Maximum, Minimum) VALUES ('"+ pstd.getProductionStandardName() +"','" + pstd.getDescription() + "','"+ pstd.getDateCreated() + "','" + pstd.getTestMethod() + "','" + pstd.getMaximum()+ "','" + pstd.getMinimum() + "');";
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

	
	
	
	
	  //this method deletes a production standard 
	public void deleteProductionStandard(String ProductionStandard) {

		openConnection();
		// Create select statement and execute it
		try {
			String sql = "DELETE from ProductionStandard where ProductionStandardName = '" + ProductionStandard + "';";
			stmt.executeUpdate(sql);
			// closes SQL statement
			stmt.close();
			// closes connection
			closeConnection();
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
	
	
	
	
	private ProductionStandard getNextProductionStandardName(ResultSet rs) {
		ProductionStandard thisProductionStandard = null;
		try {
			thisProductionStandard = new ProductionStandard();
			thisProductionStandard.setProductionStandardName(rs.getString("productionStandardName"));

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return thisProductionStandard;
	}
	
	
	private ProductionStandard getNextTestMethodName(ResultSet rs) {
		ProductionStandard thisProductionStandard = null;
		try {
			thisProductionStandard = new ProductionStandard();
			thisProductionStandard.setTestMethod(rs.getString("testMethod"));

		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return thisProductionStandard;
	}
	
	
	
	
	
	
	
	
	
}



