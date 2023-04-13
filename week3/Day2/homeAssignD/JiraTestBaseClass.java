package week3.Day2.homeAssignD;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraTestBaseClass {
	
	static RequestSpecification request = null;
	static Response response = null;
	static String bug_Key = null;
	
	@BeforeMethod
	public void setUp()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resource
		RestAssured.baseURI = "https://chithrav15.atlassian.net/rest/api/2/";
		//Step 3: Construct the Request (Auth, param, header, body, etc)
		RestAssured.authentication = RestAssured.preemptive().basic("chithra.kvr@gmail.com", "ATATT3xFfGF0t3m7gd24UoHUzjgUmSviy6q84WjzGCxnGcfxgVRd6G5Vg_GYCbEXnvbwW9hsGwqhKdn0YRCeTXW-xdGLflXND7PRI0SM-5CZSn8FjwDdONHKzbP7miV4n5Km0r3YjxrBUBOJemPfswiazS1baZhjPDomZ9vMvjuht_hWkZ22Ywo=FFBB6CE0");
		request = RestAssured.given().contentType(ContentType.JSON).log().all();
		//RestAssured.authentication = RestAssured.basic("chithra.kvr@gmail.com", "ATATT3xFfGF0t3m7gd24UoHUzjgUmSviy6q84WjzGCxnGcfxgVRd6G5Vg_GYCbEXnvbwW9hsGwqhKdn0YRCeTXW-xdGLflXND7PRI0SM-5CZSn8FjwDdONHKzbP7miV4n5Km0r3YjxrBUBOJemPfswiazS1baZhjPDomZ9vMvjuht_hWkZ22Ywo=FFBB6CE0");
		
									 
	}
	
	@AfterMethod
	public void tearDown()
	{
		response.then().log().all();
	}

}
