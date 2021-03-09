package com.api.seleniumng.resassured.local.simple.exmaples.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test01_POST 
{
	@DataProvider(name="DataForPostRequest")
	public Object[][] dataForPostRequest()
	{
		Object[][] data = new Object[2][3];
		
		data[0][0] = "Albert";
		data[0][1] = "Einstein";
		data[0][2] = 2;
		
		data[1][0] = "Thomas";
		data[1][1] = "Edison";
		data[1][2] = 1;
		
		return data;
	}
	
	@Test(dataProvider = "DataForPostRequest")
	public void test_post(String firstName, String lastName, int subjectId)
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", firstName);
		request.put("lastName", lastName);
		request.put("subjectId", subjectId);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			post("/users").
		then().
			statusCode(201).
			log().all();
	}

}
