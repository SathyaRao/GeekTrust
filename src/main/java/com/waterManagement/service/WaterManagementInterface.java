package com.waterManagement.service;

public interface WaterManagementInterface {
	public void setCommandCount(int num);
	public String[] getCommands(String[] arguments,int index);
	public void executeCommand(String command, String[] commandList);
	public void calculateBill();

	public void addGuests(String count);
	
	public int getGuests();
	
	public void allotWater(String bedrooms, String ratio);
	//public int getAllottedWater();
}
