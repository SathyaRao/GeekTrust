package com.waterManagement;
import java.io.*;
import java.util.*;

import com.waterManagement.resources.Constants;
import com.waterManagement.service.WaterManagementService;

public class WaterManagement 
{
	
	public static void main( String[] args ) throws Exception
    {
		String filePath = args[Constants.ZERO];
		FileReader file = new FileReader(filePath);
		Scanner fileScanner = new Scanner(file);
		String[] arguments = new String[19];
		int commands = Constants.ZERO;
		
		WaterManagementService waterManagementService = new WaterManagementService();
		while(fileScanner.hasNext()){
			arguments[commands++] = fileScanner.next();
		}
        if (arguments.length > Constants.ZERO)
        {
        	waterManagementService.findTotalBill(arguments);
        }
        fileScanner.close();
    }

	
}
