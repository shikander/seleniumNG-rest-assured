package com.api.seleniumng.restassured.local.simple.examples;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test02_POST 
{
	
	@Test
	public void test_post()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Edan");
		request.put("lastName", "Collins");
		request.put("departmentId", 2);
		
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
