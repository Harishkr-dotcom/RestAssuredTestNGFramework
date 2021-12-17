package com.qa.reports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.qa.RestUtils.TestConstants;

public class Log4jProperties {
	
	public static void propertFileCreater() throws IOException{
		Properties props = new Properties();
		FileOutputStream fis = new FileOutputStream(TestConstants.LOG4JPROP);
		props.setProperty("log4j.rootCategory", "debug, file");
		props.setProperty("log4j.appender.console", "org.apache.log4j.ConsoleAppender");
		props.setProperty("log4j.appender.console.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.console.layout.ConversionPattern", "%d{MM-dd-yyyy HH:mm:ss} %F %-5p [%t] %c{2} %L - %m%n");
		props.setProperty("log4j.appender.file", "org.apache.log4j.RollingFileAppender");
		props.setProperty("log4j.appender.file.File", "target/Logs/APILoags$"+TestConstants.getDateTimeString()+".log");
		props.setProperty("log4j.appender.file.MaxFileSize", "100mb");
		props.setProperty("log4j.appender.file.MaxBackupIndex", "10");
		props.setProperty("log4j.appender.file.layout", "org.apache.log4j.PatternLayout");
		props.setProperty("log4j.appender.file.layout.ConversionPattern", "%d{ISO8601} %5p [%t] %c{1}:%L - %m%n");
		props.setProperty("log4j.appender.file.Append", "false");
		
        //writing properites into properties file from Java
        props.store(fis, "Properties file generated from Java program");
        fis.close();
	}
	
	public static void main(String[] args) throws IOException {
		propertFileCreater();
		System.out.println("Hi");
	}

}
