package com.api.seleniumng.restassured.local.simple.exmaples.excel;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Test01_POST
{
	static String excelPath = "./data/TestData.xlsx";
	
	XSSFWorkbook workbook;
	XSSFSheet sheet;	
	
	public String getCellData(int rowNum, int colNum)
	{
		try {		
			workbook = new XSSFWorkbook(excelPath);
			sheet = workbook.getSheet("Sheet1");
			
			DataFormatter formatter = new DataFormatter();
			
			Object value = formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
			System.out.println("Cell value is: " + value);
			
			return (String) value;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return null;
	}
	
	@Test
	public void test_post()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName", getCellData(1, 0));
		request.put("lastName", getCellData(1, 1));
		request.put("subjectId", getCellData(1, 2));
		
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
