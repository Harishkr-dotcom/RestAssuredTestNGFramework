package com.qa.RestUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class JSONUtils {
	
	public static <T> T createPOJOfomJSON(String JSONFile, Class<T>tclass) throws IOException{
		ObjectMapper mapper = getObjectMapper();
		try {
			//byte[] jsonData = IOUtils.toByteArray(JSONUtils.class.getResourceAsStream(JSONFile));
			return mapper.readValue(new File(JSONFile),tclass );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ObjectMapper getObjectMapper(){
		ObjectMapper mapper = (new ObjectMapper()).enable(SerializationFeature.INDENT_OUTPUT).registerModule(new JavaTimeModule()).setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		return mapper;
	}

}
