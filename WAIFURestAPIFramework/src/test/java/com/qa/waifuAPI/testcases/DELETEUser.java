package com.qa.waifuAPI.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waifuAPI.testbase.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DELETEUser extends BaseTest {
	RequestSpecification httpRequest;
	 Response response;
	 @BeforeClass
	 public void deleteUser() throws InterruptedException
	 {
		 logger.info("***********************DeleteUser*******************");
	     RestAssured.baseURI="https://waifu.p.rapidapi.com/v1";
	     httpRequest=RestAssured.given()
	    		     .header("X-RapidAPI-Key","ece75f7538msha5d1535561fa866p122932jsn35d5efd02f6a")
					  .header("X-RapidAPI-Host","waifu.p.rapidapi.com");
	     response=httpRequest.request(Method.GET,"/user/all/count");
	     
	     
	     Thread.sleep(3000);
	     JsonPath jsonPathEvaluator=response.jsonPath();
			//capture id
			String userID=jsonPathEvaluator.get("[0].id");
			response= httpRequest.request(Method.DELETE,"/user/id/"+userID);
	 }
	 @Test(priority=1)
		void statusCode()
		{
			logger.info("*************StatusCode******************");
			int statusCode=response.getStatusCode();
			logger.info("StatusCode==>" +statusCode);
			Assert.assertEquals(statusCode,404);
			
		}
	 @Test(priority=2)
	 public void checkResponseTime()
	 {
	 	logger.info("************ResponseTime******************");
	 	long responseTime=response.getTime();
	 	logger.info("Response Time is==>"+responseTime);

	     if(responseTime>2000)
	     	logger.warn("Response Time Is greater than 2000");
	     Assert.assertTrue(responseTime<10000);
	 } 
	 @Test(priority=3)
	 public void statusLine()
	 {
	 	logger.info("*************StatusLine******************");
	 	String statusLine=response.getStatusLine();
	 	logger.info("statusLine is ==>" +statusLine);
	 	Assert.assertEquals(statusLine,"HTTP/1.1 404 Not Found");
	 	
	 }
	
	 @Test(priority=4)
	 public void checkserverType()
		{
			logger.info("*************ServerType******************");
			String serverType=response.header("server");
			logger.info("serverType==>" +serverType);
			Assert.assertEquals(serverType,"RapidAPI-1.2.8");
			
		}
	
	 

}
