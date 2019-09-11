package modelProductionStandard;

import java.io.Serializable;
/**
 * 
 * @author chrissieediker
 *
 */
public class ProductionStandard implements Serializable {
	
	//declares private variables (accessible only within its own class)
	private String productionStandardID;
	private String dateCreated;
	private String creator;
	private String productionStandardName;
	private String description;
	private String comment;
	private String testMethod;
	private String minimum;
	private String maximum;

	
		
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
	 * sets dateCreated
	 * @param dateCreated allows the user to set the date of creation of a production standard
	 */
	public void setDateCreated(String dateCreated) {
		if (dateCreated == null) {
			this.dateCreated = "-";
		} else {
			this.dateCreated = dateCreated;
		}
	}
	
	/**
	 * gets current dateCreated
	 * @return returns dateCreated
	 */
	public String getDateCreated() {
		return dateCreated;
	}
	
	
	
	/**
	 * sets creator
	 * @param creator allows the user to set the creator of a production standard
	 */
	public void setCreator(String creator) {
		if (creator == null) {
			this.creator = "-";
		} else {
			this.creator = creator;
		}
	}
	
	/**
	 * gets current creator
	 * @return returns creator
	 */
	public String getCreator() {
		return creator;
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
	 * sets comment
	 * @param comment allows the user to set the comment of a production standard
	 */
	public void setComment(String comment) {
		if (comment == null) {
			this.comment = "-";
		} else {
			this.comment = comment;
		}
	}
	/**
	 * gets current comment
	 * @return returns comment
	 */
	public String getComment() {
		return comment;
	}
	
	
	/**
	 * sets testMethod
	 * @param testMethod allows the user to set the testMethod of a production standard
	 */
	public void setTestMethod(String testMethod) {
		if (testMethod == null) {
			this.testMethod = "-";
		} else {
			this.testMethod = testMethod;
		}
	}
	/**
	 * gets current testMethod
	 * @return returns testMethod
	 */
	public String getTestMethod() {
		return testMethod;
	}

	
	/**
	 * sets minimum
	 * @param minimum allows the user to set the minimum of a production standard
	 */
	public void setMinimum(String minimum) {
		if (minimum == null) {
			this.minimum = "-";
		} else {
			this.minimum = minimum;
		}
	}
	/**
	 * gets current minimum
	 * @return returns minimum
	 */
	public String getMinimum() {
		return minimum;
	}
	
	
	
	/**
	 * sets maximum
	 * @param maximum allows the user to set the maximum of a production standard
	 */
	public void setMaximum(String maximum) {
		if (maximum == null) {
			this.maximum = "-";
		} else {
			this.maximum = maximum;
		}
	}
	/**
	 * gets current maximum
	 * @return returns maximum
	 */
	public String getMaximum() {
		return maximum;
	}
	


}



