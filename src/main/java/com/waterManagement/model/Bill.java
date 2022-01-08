package com.waterManagement.model;

public class Bill extends Water{
	private   int totalWaterBill;
	private   int tankerWaterBill;
	private   int borewellWaterBill;
	private   int corporationWaterBill;

	public   int getTotalWaterBill() {
		return totalWaterBill;
	}
	public   void setTotalWaterBill(int totalWaterBill) {
		this.totalWaterBill = totalWaterBill;
	}
	public   int getTankerWaterBill() {
		return tankerWaterBill;
	}
	public   void setTankerWaterBill(int tankerWaterBill) {
		 this.tankerWaterBill = tankerWaterBill;
	}
	public   int getBorewellWaterBill() {
		return borewellWaterBill;
	}
	public   void setBorewellWaterBill(int boreWellWaterBill) {
		boreWellWaterBill = Integer.parseInt((Water.allottedWater/(Water.corporationWater+Water.borewellWater))*Water.borewellWater*1.5+"");
		 this.borewellWaterBill = boreWellWaterBill;
	}
	public   int getCorporationWaterBill() {
		return corporationWaterBill;
	}
	public   void setCorporationWaterBill(int corporationWaterBill) {
		corporationWaterBill = Integer.parseInt((Water.allottedWater/(Water.corporationWater+Water.borewellWater))*Water.corporationWater+"");
		 this.corporationWaterBill = corporationWaterBill;
	}
}
