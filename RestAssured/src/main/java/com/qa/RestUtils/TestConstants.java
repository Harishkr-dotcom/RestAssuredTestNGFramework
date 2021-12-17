package com.qa.RestUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConstants {
	
	public static final String TEST_PROTOCAL = "https";
	public static final String DOMINE_URL = "://rahulshettyacademy.com";
	public static final String REPORTCONFIG = System.getProperty("user.dir")+"\\resources\\ReportsConfig.xml";
	public static final String REPORTDIR = System.getProperty("user.dir")+"\\target\\Reports\\GoogleAPIReport\\"+getDateTimeString()+"";
	public static final String CONFIGPATH = System.getProperty("user.dir")+"\\resources\\Config.properties";
	public static final String LOG4JPROP = System.getProperty("user.dir")+"\\resources\\log4j.properties";

	public static String getDateTimeString(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
	Date d = new Date();
	return dateFormat.format(d);	
	}

	public static String getDateTimeStringWithMiliSeconds(){
	DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss_sss");
	Date d = new Date();
	return dateFormat.format(d);	
	}

}
