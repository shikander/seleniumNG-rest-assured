package com.api.seleniumng.resassured.local.simple.examples;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test04_PUT 
{
	@Test
	public void test_post()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Amir");
		request.put("lastName", "Walls");
		request.put("departmentId", 1);
		
		baseURI = "http://localhost:3000/";
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			header("Content-Type", "application/json").
			body(request.toJSONString()).
		when().
			put("/users/1").
		then().
			statusCode(200).
			log().all();
	}


}
