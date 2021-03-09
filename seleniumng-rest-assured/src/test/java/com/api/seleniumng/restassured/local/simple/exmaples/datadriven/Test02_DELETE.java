package com.api.seleniumng.restassured.local.simple.exmaples.datadriven;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test02_DELETE 
{
	
	/*
	 * Provide the correct userid in the Object[] from db.json file
	 *  
	 */
	@DataProvider(name = "DataForDelete")
	public Object[] dataForDelete()
	{
		return new Object[] {10, 6};
	}
	
	@Test(dataProvider = "DataForDelete")
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
