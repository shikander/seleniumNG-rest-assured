package com.api.seleniumng.restassured.local.simple.examples;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test05_DELETE 
{
	@Test
	public void test_delete()
	{
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/2").
		then().
			statusCode(200).
			log().all();
	}
}
