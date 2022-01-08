package com.waterManagement.model;

import com.waterManagement.resources.Constants;

public class Water {
	protected static int borewellWater;
	protected static int corporationWater;
	protected static int tankerWater;
	protected static int allottedWater;
	
	public int getBorewellWater() {
		return borewellWater;
	}
	public void setBorewellWater(int borewellWater) {
		Water.borewellWater = borewellWater;
	}
	public int getCorporationWater() {
		return corporationWater;
	}
	public void setCorporationWater(int corporationWater) {
		Water.corporationWater = corporationWater;
	}
	public int getTankerWater() {
		return tankerWater;
	}
	public void setTankerWater(int tankerWater) {
		Water.tankerWater = tankerWater;
	}
	public int getAllottedWater() {
		return allottedWater;
	}
	public void setAllottedWater(int allottedWater) {
		Water.allottedWater = allottedWater;
	}

	public int calculateTankerWaterCost(int extraWater){
		int rate = Constants.ZERO, surplus = Constants.ZERO;
		if(extraWater>Constants.THREE_THOUSAND){
			surplus = extraWater - Constants.THREE_THOUSAND;
			rate += surplus * Constants.EIGHT;
			extraWater -= surplus;
		} 
		if(extraWater>Constants.THOUSAND_FIVE_HUNDRED && extraWater <=Constants.THREE_THOUSAND){
			surplus = extraWater - Constants.THOUSAND_FIVE_HUNDRED;
			rate += surplus * Constants.FIVE;
			extraWater -= surplus;
		} 
		if(extraWater>Constants.FIVE_HUNDRED && extraWater <=Constants.THOUSAND_FIVE_HUNDRED){
			surplus = extraWater - Constants.FIVE_HUNDRED;
			rate += surplus * Constants.THREE;
			extraWater -= surplus;
		} 
		if(extraWater>Constants.ZERO && extraWater <=Constants.FIVE_HUNDRED){
			rate += extraWater*Constants.TWO;
		}
		return rate;
	}
	
}
