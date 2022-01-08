package com.waterManagement.model;

import com.waterManagement.resources.Constants;

public class Water {
	private int borewellWater;
	private int corporationWater;
	private int tankerWater;
	private int allottedWater;
	Rooms rooms = new Rooms();
	
	public int getBorewellWater() {
		return this.borewellWater;
	}
	public void setBorewellWater(int borewellWater) {
		this.borewellWater = borewellWater;
	}
	public int getCorporationWater() {
		return this.corporationWater;
	}
	public void setCorporationWater(int corporationWater) {
		this.corporationWater = corporationWater;
	}
	public int getTankerWater() {
		return this.tankerWater;
	}
	public void setTankerWater(int tankerWater) {
		this.tankerWater = tankerWater;
	}
	public int getAllottedWater() {
		return this.allottedWater;
	}
	public void setAllottedWater(int allottedWater) {
		this.allottedWater = allottedWater;
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
	public void allotWater(String bedrooms, String ratio) {
		String[] str = ratio.split(":");
		this.setCorporationWater(Integer.parseInt(str[Constants.ZERO]));
		this.setBorewellWater(Integer.parseInt(str[Constants.ONE]));
		int members = rooms.getRooms(Integer.parseInt(bedrooms));
		this.setAllottedWater(members*Constants.TEN*Constants.THIRTY);
	}
	
}
