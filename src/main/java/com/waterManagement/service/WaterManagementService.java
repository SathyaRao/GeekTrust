package com.waterManagement.service;

import com.waterManagement.model.Bill;
import com.waterManagement.model.Rooms;
import com.waterManagement.model.Water;
import com.waterManagement.resources.Constants;

public class WaterManagementService implements WaterManagementInterface{
	protected static int guests = Constants.ZERO,bedroom = Constants.ZERO,corporationWater = Constants.ZERO,borewellWater = Constants.ZERO,allottedWater = Constants.ZERO;
	public static int commandCount = Constants.ZERO,totalWaterBill = Constants.ZERO;
	
	Water water = new Water();
	Rooms rooms = new Rooms();
	Bill bill = new Bill();
	
	public void findTotalBill(String[] arguments){
		String command = null;
		for (int i = 0;i<arguments.length;i++){
	    	if(arguments[i] == null){
	    		break;
	    	}
	    	String[] commandList = new String[arguments.length];
	    	if(arguments[i].equals(Constants.ALLOT_WATER) ||
	    			arguments[i].equals(Constants.ADD_GUESTS) ||
	    			arguments[i].equals(Constants.BILL)){
	    		command = arguments[i];
			}
	    	commandList = this.getCommands(arguments,i);
	    	i = i + WaterManagementService.commandCount;
	    	if(command != null){
	    		this.executeCommand(command,commandList);
	    		
	    	}
	    }
	}
	
	public void setCommandCount(int num){
		commandCount = num;
	}
	public String[] getCommands(String[] arguments,int index){
		String[] list = new String[arguments.length];
		int k = Constants.ZERO;
		for (int j = index+Constants.ONE;j<arguments.length;j++){
    		if(arguments[j] == null){
        		break;
        	}
    		if(!arguments[j].equals(Constants.ALLOT_WATER) &&
    				!arguments[j].equals(Constants.ADD_GUESTS) &&
    				!arguments[j].equals(Constants.BILL)){
        		if(arguments[j] != null){
        			list[k++] = arguments[j];
        		}
        	} else {
        		break;
        	}
    	}
		setCommandCount(k);
		return list;
	}
	public void executeCommand(String command, String[] commandList){
		if(command.equals(Constants.ALLOT_WATER)){
        	this.allotWater(commandList[Constants.ZERO], commandList[Constants.ONE]);
        } else if(command.equals(Constants.ADD_GUESTS)){
        	this.addGuests(commandList[Constants.ZERO]);
        } else if(command.equals(Constants.BILL)){
        	this.calculateBill();
        }
	}
	public void calculateBill() {
		int extraWater = Constants.ZERO, totalBill = Constants.ZERO;
		int allottedWater = water.getAllottedWater();
		double corporationWaterSum = Constants.ZERO, borewellWaterSum = Constants.ZERO;
		float ratio = (float)allottedWater/(corporationWater+borewellWater);
		corporationWaterSum = (ratio)*corporationWater;
		//
		borewellWaterSum = (ratio)*borewellWater*1.5;
		//
		totalBill = (int)(corporationWaterSum + borewellWaterSum);
		//
		if(guests>Constants.ZERO){
			extraWater = guests*Constants.TEN*Constants.THIRTY;
		}
		totalBill += calculateTankerWaterCost(extraWater);
		totalWaterBill = totalBill;
		System.out.println( (allottedWater + extraWater) + " " + totalBill);
	}

	public void addGuests(String count) {
		guests += Integer.parseInt(count);
	}
	
	public int getGuests() {
		return guests;
	}
	
	public int calculateTankerWaterCost(int extraWater) {
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
		water.setCorporationWater(Integer.parseInt(str[Constants.ZERO]));
		water.setBorewellWater(Integer.parseInt(str[Constants.ONE]));
		borewellWater = water.getBorewellWater();
		corporationWater = water.getCorporationWater();
		int members = rooms.getRooms(Integer.parseInt(bedrooms));
		water.setAllottedWater(members*Constants.TEN*Constants.THIRTY);
	}
}
