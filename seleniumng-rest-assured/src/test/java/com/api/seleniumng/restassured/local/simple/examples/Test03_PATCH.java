package com.api.seleniumng.restassured.local.simple.examples;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test03_PATCH 
{
	@Test
	public void test_patch()
	{
		JSONObject request = new JSONObject();
		
		request.put("lastName", "John");
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			patch("/users/1").
		then().
			statusCode(200).
			log().all();
	}


}
