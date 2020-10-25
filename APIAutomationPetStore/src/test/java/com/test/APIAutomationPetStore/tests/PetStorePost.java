package com.test.APIAutomationPetStore.tests;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.APIAutomationPetStore.utils.BaseClass;
import com.test.APIAutomationPetStore.utils.TestUtil;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;




public class PetStorePost extends BaseClass{
	 String filepath   =  "./jsonBodyPostRequest.json";


	@BeforeMethod
	public void initlization() {
		BaseClass.init();
	}


/*	@DataProvider
	public Object[][] getData(){
		Object testData[][] = TestUtil.getDataFromSheet("POSTData");
		return testData;
	} */

	@Test
	public void postNewPet() {
		RestAssured.baseURI     =     properties.getProperty("baseURI");
		File f = new File(filepath);
		FileReader fs = null;
		try {
			fs = new FileReader(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		JSONTokener jt = new JSONTokener(fs);
		JSONObject jo = new JSONObject(jt);
		Response   response =    RestAssured.given()
				.contentType(ContentType.JSON)
				.body(jo.toString())
				.when()
				.post("/pet");
		
		System.out.println(response.asString());
		Assert.assertEquals(200, TestUtil.RESPONSE_CODE_200);

	}
}
