package com.qa.RestUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class RequestSpecification {
	
	public static io.restassured.specification.RequestSpecification req;
	
	public static  io.restassured.specification.RequestSpecification requestSpecifications() throws IOException{
		if(req==null)
		{
		PrintStream log =new PrintStream(new FileOutputStream("logging.txt"));
		 req=new RequestSpecBuilder().setBaseUri(ReadProperty.getProperty("URI")).addQueryParam("key", "qaclick123")
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		 return req;
		}
		return req;
	}

}
