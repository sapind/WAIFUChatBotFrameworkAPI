package com.qa.waifuAPI.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.waifuAPI.testbase.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class GETUserDialog extends BaseTest{
	@BeforeClass
	public void getUserDialogs() throws InterruptedException
	{
		logger.info("*************GetUsersDialog**************");
		RestAssured.baseURI="https://waifu.p.rapidapi.com/v1";
		httpRequest=RestAssured.given()
				.header("X-RapidAPI-Key","ece75f7538msha5d1535561fa866p122932jsn35d5efd02f6a")
				.header("X-RapidAPI-Host","waifu.p.rapidapi.com");
				
		response=httpRequest.request(Method.GET,"/user/dialog/json/"+userID);
		System.out.println(response.asString());
	
		Thread.sleep(3000);
	}
	//Start Validations
			@Test(priority=1)
			void statusCode()
			{
				logger.info("*************StatusCode******************");
				int statusCode=response.getStatusCode();
				logger.info("StatusCode==>" +statusCode);
				Assert.assertEquals(statusCode,200);
				
			}
			@Test(priority=2)
			public void checkResponseBody()
			{
				logger.info("*************ResponseBody******************");
				String responseBody=response.getBody().asString();
				logger.info("responseBody==>" +responseBody);
				Assert.assertEquals(responseBody.contains(userID),true);
				
				
			}
			@Test(priority=3)
			public void checkResponseTime()
			{
				logger.info("************ResponseTime******************");
				long responseTime=response.getTime();
				logger.info("Response Time is==>"+responseTime);

			    if(responseTime>2000)
			    	logger.warn("Response Time Is greater than 2000");
			    Assert.assertTrue(responseTime<10000);
			} 
			@Test(priority=4)
			public void statusLine()
			{
				logger.info("*************StatusLine******************");
				String statusLine=response.getStatusLine();
				logger.info("statusLine is ==>" +statusLine);
				Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");
				
			}
			@Test(priority=5)
			public void contentType()
			{
				logger.info("*************ContentType******************");
				String contentType=response.getContentType();
				logger.info("contentType is==>" +contentType);
				Assert.assertEquals(contentType,"application/json");
				
			}
			@Test(priority=6)
			public void checkserverType()
			{
				logger.info("*************ServerType******************");
				String serverType=response.header("server");
				logger.info("serverType==>" +serverType);
				Assert.assertEquals(serverType,"RapidAPI-1.2.8");
				
			}

}
