package model;

import java.io.Serializable;

/**
 * @author Chrissie Ediker
 */
public class TestResult implements Serializable {

	// declares private variables (accessible only within its own class)
	private int id;
	private int jobNumber;
	private String roll;
	private String productionStandard;
	private String grammageBasePaper;
	private String grammageRelease;
	private String coatWeightAdhesive;
	private String coatWeightCoating;
	private String coatWeightGumBarrier;
	private String grammageTotalSubstance;
	private String caliperBasePaper;
	private String caliperRelease;
	private String caliperTotal;
	private String tensileStrengthMachineDirection;
	private String tensileStrengthCrossDirection;
	private String tearingResistanceMachineDirection;
	private String tearingResistanceCrossDirection;
	private String moistureContent;
	private String opacity;
	private String pickingResistanceDennisonWax;
	private String waterAbsorptionCobb;
	private String pickingResistanceIGTmvo;
	private String pickingResistanceIGTlvo;
	private String inkAbsorbencyIGTStainLength;
	private String smoothnessBendtsen;
	private String burstStrength;
	private String porosityBendtsen;
	private String inkAbsorbencyKandNInk;
	private String surfaceStructureBlueMicroContourTest;
	private String stiffness;
	private String phosphorescentStrengthRamley;
	private String surfacepHofPaper;
	private String adhesionPropertiesManillaEnvelope;
	private String smoothnessParkerPrintSurf;
	private String wetExpansion;
	private String wetExpansionResult;
	private String brightnessD65R457Spectrophotometer;
	private String whitenessSpectrophotometer;
	private String l;
	private String a;
	private String b;
	private String relativeHumidityIntersheet;
	private String stretchMachineDirection;
	private String stretchCrossDirection;
	private String gloss;
	private String tearingResistanceSingleTearMachineDirection;
	private String tearingResistanceSingleTearCrossDirection;
	private String curlTest;
	private String ashContent;
	private String phosphorescentStrengthUSPSMethod;
	private String absorptionRedDyeTestTurpentineOil;
	private String inkAbsorbencyBlackPorometriqueInk;
	private String adhesionStrengthGlass;
	private String adhesiveStrengthUSPSCroxleyScript;
	private String adhesiveStrengthKraftEnvelope;
	private String moistureContentMM55online;
	private String chemicalReactionTest;
	private String adhesionPeel180degrees;
	private String adhesionReleaseForce180DegreesLowSpeed;
	private String adhesionLoopTack;
	private String fluorescenceMeasuringTestFLUOTEST;
	private String delaminationofSelfAdhesivePaper90Degrees;
	private String siliconeCoatingDistributionMethyleneBlueTest;
	private String pSAAdhesiveCoatWeightPolyesterFilm;
	private String siliconeSurfaceStructureCobbInkTest;
	private String helioTest;
	private String smoothnessBekk;
	private String breakingLengthMachineDirection;
	private String breakingLengthCrossDirection;
	private String shearTest;
	private String adhesionFastReleasetest;
	private String hotWaterAbsorptionCobb;
	private String heatSealEffectivenessTesting;
	private String formabilityCupStockVisualCheck;
	private String cupStockCoatingCoverageRedDyeTurpentine;
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setjobNumber(int jobNumber) {
		this.jobNumber = jobNumber;
	}

	public int getJobNumber() {
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

	public void setGrammageBasePaper(String grammageBasePaper) {
		if (grammageBasePaper == null) {
			this.grammageBasePaper = "-";
		} else {
			this.grammageBasePaper = grammageBasePaper;
		}

	}

	public String getGrammageBasePaper() {
		return grammageBasePaper;
	}
	
	public void setGrammageRelease(String grammageRelease) {
		if (grammageRelease == null) {
			this.grammageRelease = "-";
		} else {
			this.grammageRelease = grammageRelease;
		}

	}

	public String getGrammageRelease() {
		return grammageRelease;
	}
	
	
	public void setCoatWeightAdhesive(String coatWeightAdhesive) {
		if (coatWeightAdhesive == null) {
			this.coatWeightAdhesive = "-";
		} else {
			this.coatWeightAdhesive = coatWeightAdhesive;
		}

	}

	public String getCoatWeightAdhesive() {
			return coatWeightAdhesive;
		
	}
	
	public void setCoatWeightCoating(String coatWeightCoating) {
		if (coatWeightCoating == null) {
			this.coatWeightCoating = "-";
		} else {
			this.coatWeightCoating = coatWeightCoating;
		}

	}

	public String getCoatWeightCoating() {
		return coatWeightCoating;
	}
	
	public void setCoatWeightGumBarrier(String coatWeightGumBarrier) {
		if (coatWeightGumBarrier == null) {
			this.coatWeightGumBarrier = "-";
		} else {
			this.coatWeightGumBarrier = coatWeightGumBarrier;
		}

	}

	public String getCoatWeightGumBarrier() {
		return coatWeightGumBarrier;
	}

	public void setGrammageTotalSubstance(String grammageTotalSubstance) {
		if (grammageTotalSubstance == null) {
			this.grammageTotalSubstance = "-";
		} else {
			this.grammageTotalSubstance = grammageTotalSubstance;
		}

	}

	public String getGrammageTotalSubstance() {
		return grammageTotalSubstance;
	}
	
	public void setCaliperBasePaper(String caliperBasePaper) {
		if (caliperBasePaper == null) {
			this.caliperBasePaper = "-";
		} else {
			this.caliperBasePaper = caliperBasePaper;
		}

	}

	public String getCaliperBasePaper() {
		return caliperBasePaper;
	}
	
	public void setCaliperRelease(String caliperRelease) {
		if (caliperRelease == null) {
			this.caliperRelease = "-";
		} else {
			this.caliperRelease = caliperRelease;
		}

	}

	public String getCaliperRelease() {
		return caliperRelease;
	}
	
	public void setCaliperTotal(String caliperTotal) {
		if (caliperTotal == null) {
			this.caliperTotal = "-";
		} else {
			this.caliperTotal = caliperTotal;
		}

	}

	public String getCaliperTotal() {
		return caliperTotal;
	}
	
	public void setTensileStrengthMachineDirection(String tensileStrengthMachineDirection) {
		if (tensileStrengthMachineDirection == null) {
			this.tensileStrengthMachineDirection = "-";
		} else {
			this.tensileStrengthMachineDirection = tensileStrengthMachineDirection;
		}

	}

	public String getTensileStrengthMachineDirection() {
		return tensileStrengthMachineDirection;
	}
	
	public void setTensileStrengthCrossDirection(String tensileStrengthCrossDirection) {
		if (tensileStrengthCrossDirection == null) {
			this.tensileStrengthCrossDirection = "-";
		} else {
			this.tensileStrengthCrossDirection = tensileStrengthCrossDirection;
		}

	}

	public String getTensileStrengthCrossDirection() {
		return tensileStrengthCrossDirection;
	}
	
	public void setTearingResistanceMachineDirection(String tearingResistanceMachineDirection) {
		if (tearingResistanceMachineDirection == null) {
			this.tearingResistanceMachineDirection = "-";
		} else {
			this.tearingResistanceMachineDirection = tearingResistanceMachineDirection;
		}

	}

	public String getTearingResistanceMachineDirection() {
		return tearingResistanceMachineDirection;
	}
	
	public void setTearingResistanceCrossDirection(String tearingResistanceCrossDirection) {
		if (tearingResistanceCrossDirection == null) {
			this.tearingResistanceCrossDirection = "-";
		} else {
			this.tearingResistanceCrossDirection = tearingResistanceCrossDirection;
		}

	}

	public String getTearingResistanceCrossDirection() {
		return tearingResistanceCrossDirection;
	}
	
	public void setMoistureContent(String moistureContent) {
		if (moistureContent == null) {
			this.moistureContent = "-";
		} else {
			this.moistureContent = moistureContent;
		}

	}

	public String getMoistureContent() {
		return moistureContent;
	}
	
	public void setOpacity(String opacity) {
		if (opacity == null) {
			this.opacity = "-";
		} else {
			this.opacity = opacity;
		}

	}

	public String getOpacity() {
		return opacity;
	}
	
	public void setPickingResistanceDennisonWax(String pickingResistanceDennisonWax) {
		if (pickingResistanceDennisonWax == null) {
			this.pickingResistanceDennisonWax = "-";
		} else {
			this.pickingResistanceDennisonWax = pickingResistanceDennisonWax;
		}

	}

	public String getPickingResistanceDennisonWax() {
		return pickingResistanceDennisonWax;
	}
	
	public void setWaterAbsorptionCobb(String waterAbsorptionCobb) {
		if (waterAbsorptionCobb == null) {
			this.waterAbsorptionCobb = "-";
		} else {
			this.waterAbsorptionCobb = waterAbsorptionCobb;
		}

	}

	public String getWaterAbsorptionCobb() {
		return waterAbsorptionCobb;
	}
	
	public void setPickingResistanceIGTmvo(String pickingResistanceIGTmvo) {
		if (pickingResistanceIGTmvo == null) {
			this.pickingResistanceIGTmvo = "-";
		} else {
			this.pickingResistanceIGTmvo = pickingResistanceIGTmvo;
		}

	}

	public String getPickingResistanceIGTmvo() {
		return pickingResistanceIGTmvo;
	}
	
	public void setPickingResistanceIGTlvo(String pickingResistanceIGTlvo) {
		if (pickingResistanceIGTlvo == null) {
			this.pickingResistanceIGTlvo = "-";
		} else {
			this.pickingResistanceIGTlvo = pickingResistanceIGTlvo;
		}

	}

	public String getPickingResistanceIGTlvo() {
		return pickingResistanceIGTlvo;
	}
	
	public void setInkAbsorbencyIGTStainLength(String inkAbsorbencyIGTStainLength) {
		if (inkAbsorbencyIGTStainLength == null) {
			this.inkAbsorbencyIGTStainLength = "-";
		} else {
			this.inkAbsorbencyIGTStainLength = inkAbsorbencyIGTStainLength;
		}

	}

	public String getInkAbsorbencyIGTStainLength() {
		return inkAbsorbencyIGTStainLength;
	}
	
	

}



