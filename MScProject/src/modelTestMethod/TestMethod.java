package modelTestMethod;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
	 * @author Chrissie Ediker
	 */

	public class TestMethod implements Serializable {
	
		//declares private variables (accessible only within its own class)
		private String testMethodId;
		private String documentNumber;
		private String documentTitle;
		private String unit;
			
		/**
		 * sets testMethodId
		 * @param testMethodId allows the user to set the testMethodId of a test
		 */
		public void setTestMethodId(String testMethodId) {
			if (testMethodId == null) {
				this.testMethodId = "-";
			} else {
				this.testMethodId = testMethodId;
			}
		}
		
		/**
		 * gets current testMethodId
		 * @return returns testMethodId
		 */
		public String getTestMethodId() {
			return testMethodId;
		}
		/**
		 * sets documentNumber
		 * @param documentNumber allows the user to set the documentNumber of a test method
		 */
		
		public void setDocumentNumber(String documentNumber) {
			if (documentNumber == null) {
				this.documentNumber = "-";
			} else {
				this.documentNumber = documentNumber;
			}
		}
		/**
		 * gets current documentNumber
		 * @return returns documentNumber
		 */
		public String getDocumentNumber() {
			return documentNumber;
		}
		/**
		 * sets documentTitle
		 * @param documentTitle allows the user to set the documentTitle a test method
		 */
		public void setDocumentTitle(String documentTitle) {
			if (documentTitle == null) {
				this.documentTitle = "-";
			} else {
				this.documentTitle = documentTitle;
			}
		}
		/**
		 * gets current documentTitle
		 * @return returns documentTitle
		 */
		public String getDocumentTitle() {
			return documentTitle;
		}

		
		public void setUnit(String unit) {
			if (unit == null) {
				this.unit = "-";
			} else {
				this.unit = unit;
			}
		}
		
		/**
		 * gets current unit
		 * @return returns unit
		 */
		public String getUnit() {
			return unit;
		}
		/**
		 * The toString() method returns a String of all test method attributes
		 */
		public String toString() {
			return "Test Method ID: " + this.getTestMethodId() + " Document Number: " + this.documentNumber + " Document Title: "
					+ this.getDocumentTitle();
		}
		/**
		 * The toTextString() method returns a String of all film attributes with separation delimiters
		 * @return String of all film attributes with separation delimiters
		 */
		public String toTextString() {
			return this.getTestMethodId() + "/&*" + this.getDocumentNumber() + "/&*"
					+ this.getDocumentTitle()+ "$$$";
		}

	}


