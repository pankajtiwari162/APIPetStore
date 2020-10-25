package com.test.APIAutomationPetStore.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.APIAutomationPetStore.utils.BaseClass;
import com.test.APIAutomationPetStore.utils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetAllAvailablePets extends  BaseClass{
	
	@BeforeMethod
	public void initilization() {
		BaseClass.init();
	}
	

	
 @Test
  public void getAllAvailablePets() {
	 RestAssured.baseURI     =     properties.getProperty("baseURI");
	 RequestSpecification   requestspec = RestAssured.given();
	 Response   actualResponse = requestspec.get("pet/findByStatus?status=available");
	  Assert.assertEquals(actualResponse.getStatusCode(), TestUtil.RESPONSE_CODE_200);
	  if(actualResponse.asString().contains("pending") || actualResponse.asString().contains("sold")) {
		  Assert.assertTrue(false, "Response contains status pending or sold");
	  }
	  else
	  {
		  Assert.assertTrue(true);
	  }
	  
  }
	
}
