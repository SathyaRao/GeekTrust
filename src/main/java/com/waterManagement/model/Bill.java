package com.waterManagement.model;

public class Bill extends Water{
	private static int totalWaterBill;
	private static int tankerWaterBill;
	private static int borewellWaterBill;
	private static int corporationWaterBill;

	public static int getTotalWaterBill() {
		return totalWaterBill;
	}
	public static void setTotalWaterBill(int totalWaterBill) {
		Bill.totalWaterBill = totalWaterBill;
	}
	public static int getTankerWaterBill() {
		return tankerWaterBill;
	}
	public static void setTankerWaterBill(int tankerWaterBill) {
		Bill.tankerWaterBill = tankerWaterBill;
	}
	public static int getBorewellWaterBill() {
		return borewellWaterBill;
	}
	public static void setBorewellWaterBill(int boreWellWaterBill) {
		boreWellWaterBill = Integer.parseInt((Water.allottedWater/(Water.corporationWater+Water.borewellWater))*Water.borewellWater*1.5+"");
		Bill.borewellWaterBill = boreWellWaterBill;
	}
	public static int getCorporationWaterBill() {
		return corporationWaterBill;
	}
	public static void setCorporationWaterBill(int corporationWaterBill) {
		corporationWaterBill = Integer.parseInt((Water.allottedWater/(Water.corporationWater+Water.borewellWater))*Water.corporationWater+"");
		Bill.corporationWaterBill = corporationWaterBill;
	}
}
