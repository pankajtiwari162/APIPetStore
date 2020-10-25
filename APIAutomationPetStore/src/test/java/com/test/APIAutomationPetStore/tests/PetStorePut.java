package com.test.APIAutomationPetStore.tests;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.test.APIAutomationPetStore.utils.BaseClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class PetStorePut extends BaseClass {

	@BeforeMethod
	public void initilization() {
		BaseClass.init();
	}
	
	
	
	@Test
	public void updateStatus() {
		RestAssured.baseURI     =     properties.getProperty("baseURI");
		File file = new File("./jsonBodyPutRequest.json");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);

		Response   response =    RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.put("/pet");

		System.out.println(response.statusCode());
		System.out.println(response.asString());
	}

}
