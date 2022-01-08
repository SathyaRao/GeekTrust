package com.waterManagement.model;

import java.util.HashSet;
import java.util.Set;

import com.waterManagement.resources.Constants;

public class Commands {
    private Set<String> commands = new HashSet<String>();
    private int commandCount = Constants.ZERO;
	Set<String> commandSet = new HashSet<String>();
    		
    public Commands() {
        this.commands.add(Constants.ALLOT_WATER);
        this.commands.add(Constants.BILL);
        this.commands.add(Constants.ADD_GUESTS);
    }
    public Set<String> getCommands(){
        return this.commands;
    }
    public void setCommandCount(int num){
		this.commandCount = num;
	}
    public int getCommandCount(){
		return this.commandCount;
	}
	public String[] getCommands(String[] arguments,int index){
		commandSet = this.getCommands();
		String[] list = new String[arguments.length];
		int k = Constants.ZERO;
		for (int j = index+Constants.ONE;j<arguments.length;j++){
			if(!commandSet.contains(arguments[j])){
        		if(arguments[j] != null){
        			list[k++] = arguments[j];
        		}
        	} else {
        		break;
        	}
    	}
		this.setCommandCount(k);
		return list;
	}
}
