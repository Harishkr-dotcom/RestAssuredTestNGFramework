package com.qa.RestUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {
	
	public static String getProperty(String propertyname) {
		
		String returnproperty=null;
		Properties property = new Properties();
		try {
			FileInputStream file = new FileInputStream(TestConstants.CONFIGPATH);
			property.load(file);
			returnproperty = property.getProperty(propertyname);
			if(returnproperty==null) {
				throw new Exception("Property named "+propertyname+ "not found");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return returnproperty;
		
	}

}
