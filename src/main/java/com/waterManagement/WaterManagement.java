package com.waterManagement;
//import org.json.*;
import java.io.*;
import java.util.*;

import com.waterManagement.service.WaterManagementService;

public class WaterManagement 
{
	
	public static void main( String[] args ) throws Exception
    {
		String filePath = args[0];
		FileReader file = new FileReader(filePath);
		Scanner fileScanner = new Scanner(file);
		String[] arguments = new String[19];
		int commands = 0;
		
		WaterManagementService waterManagementService = new WaterManagementService();
		while(fileScanner.hasNext()){
			arguments[commands++] = fileScanner.next();
		}
        if (arguments.length > 0)
        {
        	waterManagementService.findTotalBill(arguments);
        }
        fileScanner.close();
    }

	
}
