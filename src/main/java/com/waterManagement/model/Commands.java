package com.waterManagement.model;

import java.util.HashSet;
import java.util.Set;

import com.waterManagement.resources.Constants;

public class Commands {
    private Set<String> commands = new HashSet<String>();
    public Commands() {
        this.commands.add(Constants.ALLOT_WATER);
        this.commands.add(Constants.BILL);
        this.commands.add(Constants.ADD_GUESTS);
    }
    public Set<String> getCommands(){
        return this.commands;
    }
}
