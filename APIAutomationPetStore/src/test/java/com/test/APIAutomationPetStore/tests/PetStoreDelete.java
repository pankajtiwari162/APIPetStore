package com.test.APIAutomationPetStore.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.APIAutomationPetStore.utils.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

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
				.delete("https://petstore.swagger.io/v2/pet/4042");

		System.out.println(response.statusCode());		
	}
}
