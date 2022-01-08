package com.waterManagement.service;

import java.util.HashSet;
import java.util.Set;

import com.waterManagement.model.Bill;
import com.waterManagement.model.Commands;
import com.waterManagement.model.Rooms;
import com.waterManagement.model.Water;
import com.waterManagement.resources.Constants;

public class WaterManagementService implements WaterManagementInterface{
	Water water = new Water();
	Rooms rooms = new Rooms();
	Bill bill = new Bill();
	Commands commands = new Commands();
	Set<String> commandSet = new HashSet<String>();
	
	public void findTotalBill(String[] arguments){
		String command = null;
		
		commandSet = commands.getCommands();
		for (int i = 0;i<arguments.length;i++){
	    	if(arguments[i] == null){
	    		break;
	    	}
	    	String[] commandList = new String[arguments.length];
			if(commandSet.contains(arguments[i])){
	    		command = arguments[i];
			}
	    	commandList = commands.getCommands(arguments,i);
	    	i = i + commands.getCommandCount();
	    	if(command != null){
	    		this.executeCommand(command,commandList);
	    	}
	    }
	}

	public void executeCommand(String command, String[] commandList){
		if(command.equals(Constants.ALLOT_WATER)){
        	water.allotWater(commandList[Constants.ZERO], commandList[Constants.ONE]);
        } else if(command.equals(Constants.ADD_GUESTS)){
        	rooms.setGuests(commandList[Constants.ZERO]);
        } else if(command.equals(Constants.BILL)){
        	this.calculateBill();
        }
	}
	public void calculateBill() {
		int extraWater = Constants.ZERO, totalBill = Constants.ZERO;
		int guests = rooms.getGuests();
		int corporationWater = water.getCorporationWater();
		int borewellWater = water.getBorewellWater();
		int allottedWater = water.getAllottedWater();
		double corporationWaterSum = Constants.ZERO, borewellWaterSum = Constants.ZERO;
		float ratio = (float)allottedWater/(corporationWater+borewellWater);
		corporationWaterSum = (ratio)*corporationWater;
		borewellWaterSum = (ratio)*borewellWater*1.5;
		totalBill = (int)Math.ceil(corporationWaterSum + borewellWaterSum);
		if(guests>Constants.ZERO){
			extraWater = guests*Constants.TEN*Constants.THIRTY;
		}
		totalBill += water.calculateTankerWaterCost(extraWater);
		bill.setTotalWaterBill(totalBill);
		System.out.println( (allottedWater + extraWater) + " " + totalBill);
	}

}
