package modelProductionStandard;

import java.io.Serializable;

public class productionStandard implements Serializable {
	
	//declares private variables (accessible only within its own class)
	private String productionStandardID;
	private String productionStandardName;
	private String description;
	private String test1;
	private String test2;
	private String test3;
	private String test4;
	private String test5;
	private String test6;
	private String test7;
	private String test8;
	private String test9;
	private String test10;
	private String test11;
	private String test12;
	private String test13;
	private String test14;
	private String test15;
	private String test16;
	private String test17;
	private String test18;
	private String test19;
	private String test20;
	private String comment;
		
	/**
	 * sets productionStandardID
	 * @param productionStandardID allows the user to set the productionStandardID of a production standard
	 */
	public void setProductionStandardID(String productionStandardID) {
		if (productionStandardID == null) {
			this.productionStandardID = "-";
		} else {
			this.productionStandardID = productionStandardID;
		}
	}
	
	/**
	 * gets current productionStandardID
	 * @return returns productionStandardID
	 */
	public String getProductionStandardID() {
		return productionStandardID;
	}
	
	
	
	/**
	 * sets productionStandardName
	 * @param productionStandardName allows the user to set the productionStandardName of a production standard
	 */
	
	public void setProductionStandardName(String productionStandardName) {
		if (productionStandardName == null) {
			this.productionStandardName = "-";
		} else {
			this.productionStandardName = productionStandardName;
		}
	}
	/**
	 * gets current productionStandardName
	 * @return returns productionStandardName
	 */
	public String getProductionStandardName() {
		return productionStandardName;
	}
	
	
	/**
	 * sets description
	 * @param description allows the user to set the productionStandardID of a production standard
	 */
	public void setDescription(String description) {
		if (description == null) {
			this.description = "-";
		} else {
			this.description = description;
		}
	}
	
	/**
	 * gets current description
	 * @return returns description
	 */
	public String getDescription() {
		return description;
	}
	
	
	/**
	 * sets test1
	 * @param test1 allows the user to set the test1 a production standard
	 */
	public void setTest1(String test1) {
		if (test1 == null) {
			this.test1 = "-";
		} else {
			this.test1 = test1;
		}
	}
	/**
	 * gets current test1
	 * @return returns test1
	 */
	public String getTest1() {
		return test1;
	}

	
	/**
	 * sets test2
	 * @param test2 allows the user to set the test2 a production standard
	 */
	public void setTest2(String test2) {
		if (test2 == null) {
			this.test2 = "-";
		} else {
			this.test2 = test2;
		}
	}
	/**
	 * gets current test2
	 * @return returns test2
	 */
	public String getTest2() {
		return test2;
	}
	


}



