package week3.Day1.homeAssignment;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentBodyAsFile {

	@Test
	public void createIncWithFile()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resources
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		
		//Step 3: Contruct the Request (Params, Header, Body, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		
		/* Passing request body using RequestSpecification class & given method 
		 * For a post request content type is mandatory. 
		 * Creating a File class object to read the File.
		 */		
		File file = new File("./src/test/resources/homeAssign.json");
		RequestSpecification inputRequest = RestAssured.given()
											.body(file)
											.contentType(ContentType.JSON);
				
		//Step 4: Send the Request
		Response response = inputRequest.post();
		
		//Step 5: Validate the Response
		response.prettyPrint();
	}
}
