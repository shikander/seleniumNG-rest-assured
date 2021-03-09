package com.api.seleniumng.restassured.local.simple.examples;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Test01_GET 
{
	@Test
	public void test_get()
	{
		baseURI = "http://localhost:3000/";
		
		given().
			get("/departments").
		then().
			statusCode(200).
			log().all();		
			
	}

}
