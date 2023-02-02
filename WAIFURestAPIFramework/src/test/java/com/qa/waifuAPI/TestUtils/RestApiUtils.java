package com.qa.waifuAPI.TestUtils;

import org.apache.commons.lang3.RandomStringUtils;

public class RestApiUtils {
	
	
	
	public static String uID()
	{
		String generatedString=RandomStringUtils.randomAlphanumeric(10);
	
	
		return(generatedString);
		
	}
	public static String text()
	{
	
		String generatedString=RandomStringUtils.randomAlphabetic(1);
		return("Hi"+generatedString);
		
	}
	public static String firstUser()
	{
	String generatedString=RandomStringUtils.randomAlphabetic(1);
	
		return("Tom"+generatedString);
		
	}
	public static String secondUser()
	{
	String generatedString=RandomStringUtils.randomAlphabetic(1);
	
		return("Sam"+generatedString);
		
	}
	public static String situation()
	{
	String generatedString=RandomStringUtils.randomAlphabetic(1);
	
		return("meeting"+generatedString);
		
	}
	

}
