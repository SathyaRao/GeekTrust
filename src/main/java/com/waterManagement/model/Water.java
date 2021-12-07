package com.waterManagement.model;

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
	
}
