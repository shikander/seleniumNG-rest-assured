package com.api.seleniumng.resassured.local.simple.exmaples.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test03_DELETE 
{
	
	/*
	 * Provide the correct userid in the Object[] from db.json file
	 *  into testng.xml
	 */
	@Parameters({"userId"})
	@Test
	public void test_delete(int userId)
	{
		baseURI = "http://localhost:3000/";
		
		when().
			delete("/users/" + userId).
		then().
			statusCode(200).
			log().all();
	}

}
