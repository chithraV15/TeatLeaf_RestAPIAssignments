package week3.Day2.homeAssignC;

import java.io.File;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBaseClass {
	
	//Global variables
	static RequestSpecification request = null;
	static Response response = null;
	static String sys_id = null;
	
	@BeforeMethod
	public void setUp()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resources
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/";
		//Step 3: Contruct the Request (Params, Header, Body, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
	}
	
	@AfterMethod
	public void tearDown()
	{
		response.then().log().all();
	}
	
	
	

}
