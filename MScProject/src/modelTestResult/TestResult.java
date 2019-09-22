package modelTestResult;

import java.io.Serializable;

/**
 * @author Chrissie Ediker
 */
public class TestResult implements Serializable {

	// declares private variables (accessible only within its own class)
	private String jobNumber;
	private String roll;
	private String productionStandard;
	private String dateTimeSubmit;
	private String testMethod;
	private String testResult;
	
	

/**
 * sets jobNumber
 * @param jobNumber allows the user to set the jobNumber of a TestResult
 */
	public void setjobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	
	/**
	 * gets current jobNumber
	 * @return returns jobNumber
	 */
	public String getJobNumber() {
		return jobNumber;
	}
	
	
	/**
	 * sets roll
	 * @param roll allows the user to set the roll of a TestResult
	 */
	public void setRoll(String roll) {
		if (roll == null) {
			this.roll = "-";
		} else {
			this.roll = roll;
		}
	}

	/**
	 * gets current roll
	 * @return returns roll
	 */
	public String getRoll() {
		return roll;
	}

	/**
	 * sets ProductionStandard
	 * @param ProductionStandard allows the user to set the ProductionStandard of a TestResult
	 */
	public void setProductionStandard(String productionStandard) {
		if (productionStandard == null) {
			this.productionStandard = "-";
		} else {
			this.productionStandard = productionStandard;
		}
	}

	
	/**
	 * gets current ProductionStandard
	 * @return returns ProductionStandard
	 */
	public String getProductionStandard() {
		return productionStandard;
	}
	
	/**
	 * sets DateTimeSubmit
	 * @param DateTimeSubmit allows the user to set the DateTimeSubmit of a TestResult
	 */
	public void setDateTimeSubmit(String dateTimeSubmit) {
		if (dateTimeSubmit == null) {
			this.dateTimeSubmit = "-";
		} else {
			this.dateTimeSubmit = dateTimeSubmit;
		}

	}
	
	
	/**
	 * gets current DateTimeSubmit
	 * @return returns DateTimeSubmit
	 */
	public String getDateTimeSubmit() {
		return dateTimeSubmit;
	}
	
	/**
	 * sets TestMethod
	 * @param TestMethod allows the user to set the TestMethod of a TestResult
	 */
	public void setTestMethod(String testMethod) {
		if (testMethod == null) {
			this.testMethod = "-";
		} else {
			this.testMethod = testMethod;
		}

	}

	
	/**
	 * gets current TestMethod
	 * @return returns TestMethod
	 */
	public String getTestMethod() {
		return testMethod;
	}
	
	
	/**
	 * sets TestResult
	 * @param TestResult allows the user to set the TestResult of a TestResult
	 */
	public void setTestResult(String testResult) {
		if (testResult == null) {
			this.testResult = "-";
		} else {
			this.testResult = testResult;
		}

	}

	/**
	 * gets current TestResult
	 * @return returns TestResult
	 */
	public String getTestResult() {
		return testResult;
	}
	
}



