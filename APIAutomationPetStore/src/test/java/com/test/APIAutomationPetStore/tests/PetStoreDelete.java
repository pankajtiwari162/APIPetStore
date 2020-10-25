package com.test.APIAutomationPetStore.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.APIAutomationPetStore.utils.BaseClass;
import com.test.APIAutomationPetStore.utils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PetStoreDelete extends BaseClass {

	@BeforeMethod
	public void intilization() {
		BaseClass.init();
	}
	
	
	
	@Test
	public void deletePet() {
		RestAssured.baseURI     =     properties.getProperty("baseURI");
		Response   response =    RestAssured.given()
				.contentType(ContentType.JSON)	
				.when()
				.delete("/pet/4042");

		RequestSpecification   requestspec = RestAssured.given();
		 Response   actualResponse = requestspec.get("pet/findByStatus?status=sold");
		  Assert.assertEquals(actualResponse.getStatusCode(), TestUtil.RESPONSE_CODE_200);
		  if(actualResponse.asString().contains("4042")) {
			  Assert.assertTrue(false, "Pet created in post request not deleted");
		  }
		  else
		  {
			  Assert.assertTrue(true);
		  }
		  
	  }

	}

