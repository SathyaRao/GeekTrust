package com.waterManagement;

//import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import static org.junit.Assert.*;

import org.junit.Test;

import com.waterManagement.model.Water;
import com.waterManagement.service.WaterManagementService;
/**
 * Unit test for simple App.
 */
public class WaterManagementTest 
    //extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    
	WaterManagementService waterManagementService = new WaterManagementService();
	Water water = new Water();
    
	@Test
    public void calculateBillTest(){
    	waterManagementService.allotWater("3","5:4");
    	waterManagementService.addGuests("8");
    	waterManagementService.calculateTankerWaterCost(1500);
    	waterManagementService.calculateBill();
    	assertEquals(39733,WaterManagementService.totalWaterBill);
    }
    
	@Test
    public void addGuestsTest(){
    	waterManagementService.addGuests("5");
    	assertEquals(5,waterManagementService.getGuests());
    }
    
    @Test
    public void calculateTankerWaterCostTest(){
    	assertEquals(4000,waterManagementService.calculateTankerWaterCost(1500));
    }
    
    @Test
    public void allotWaterTest(){
    	waterManagementService.allotWater("2","3:7");
    	assertEquals(900,water.getAllottedWater());
    }
    
    @Test
    public void setCommandCountTest(){
    	waterManagementService.setCommandCount(4);
    	assertEquals(4,WaterManagementService.commandCount);
    }
    
    @SuppressWarnings("deprecation")
	@Test
    public void executeCommandTest(){
    	String[] commands = {"ALLOT_WATER", "3", "5:4", "ADD_GUESTS", "3", "ADD_GUESTS", "5"};
    	int index = 0;
    	String[] result = {"3", "5:4"};
    	assertEquals(result[0],waterManagementService.getCommands(commands,index)[0]);
    }
    
    @Test
    public void getCommandsTest(){
    	waterManagementService.allotWater("2","3:7");
    	assertEquals(900,water.getAllottedWater());
    }
    
    @Test
    public void findTotalBillTest(){
    	String[] commands = {"ALLOT_WATER", "3", "5:4", "ADD_GUESTS", "3", "ADD_GUESTS", "5", "BILL"};
    	waterManagementService.findTotalBill(commands);
    	assertEquals(1500,water.getAllottedWater());
    }
}
