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
	
	


	public void setjobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setRoll(String roll) {
		if (roll == null) {
			this.roll = "-";
		} else {
			this.roll = roll;
		}
	}

	public String getRoll() {
		return roll;
	}

	public void setProductionStandard(String productionStandard) {
		if (productionStandard == null) {
			this.productionStandard = "-";
		} else {
			this.productionStandard = productionStandard;
		}
	}

	public String getProductionStandard() {
		return productionStandard;
	}

	public void setDateTimeSubmit(String dateTimeSubmit) {
		if (dateTimeSubmit == null) {
			this.dateTimeSubmit = "-";
		} else {
			this.dateTimeSubmit = dateTimeSubmit;
		}

	}

	public String getDateTimeSubmit() {
		return dateTimeSubmit;
	}
	
	public void setTestMethod(String testMethod) {
		if (testMethod == null) {
			this.testMethod = "-";
		} else {
			this.testMethod = testMethod;
		}

	}

	public String getTestMethod() {
		return testMethod;
	}
	
	
	public void setTestResult(String testResult) {
		if (testResult == null) {
			this.testResult = "-";
		} else {
			this.testResult = testResult;
		}

	}

	public String getTestResult() {
		return testResult;
	}
	
}



