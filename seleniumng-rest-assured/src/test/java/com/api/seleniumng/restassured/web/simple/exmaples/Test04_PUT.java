package com.api.seleniumng.restassured.web.simple.exmaples;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test04_PUT 
{
	@Test
	public void test_4_post_withHeaders()
	{
		JSONObject request = new JSONObject();
		request.put("name", "John Smith");
		request.put("job", "Software Engineer");
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("https://reqres.in/api/users/2").
		then().
			statusCode(200).
			log().all();
	}

}
