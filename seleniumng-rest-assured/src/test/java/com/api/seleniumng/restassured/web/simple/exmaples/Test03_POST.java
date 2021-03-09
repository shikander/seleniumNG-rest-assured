package com.api.seleniumng.restassured.web.simple.exmaples;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class Test03_POST 
{
	
	@Test
	public void test_1_map()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "John Smith");
		map.put("job", "Software Engineer");
		
		System.out.println(map);		
		JSONObject request = new JSONObject(map);
		System.out.println(request);
		System.out.println(request.toJSONString());
	}
	
	@Test
	public void test_2_json()
	{		
		System.out.println("**************");
		
		JSONObject request = new JSONObject();
		request.put("name", "John Smith");
		request.put("job", "Software Engineer");
		
		System.out.println(request);
		System.out.println(request.toJSONString());
	}
	
	@Test
	public void test_3_post()
	{
		JSONObject request = new JSONObject();
		request.put("name", "John Smith");
		request.put("job", "Software Engineer");
		
		given().
			body(request.toJSONString()).
		when().
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}
	
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
			post("https://reqres.in/api/users").
		then().
			statusCode(201);
	}
}
