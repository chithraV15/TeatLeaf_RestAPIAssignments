package week3.Day2.homeAssignA;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PutPatchDeleteRequest {

	@Test
	public void putInc()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resources
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table"
								+ "/incident/d7992fcbdb826110766ab7e8f4961957";
		
		//Step 3: Contruct the Request (Params, Header, Body, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		
		/* Passing request body using RequestSpecification class & given method 
		 * For a post request content type is mandatory. 
		 * Passing body as string
		 * Capturing logs for request using .log()
		 */		
		RequestSpecification inputRequest = RestAssured.given()
											.body("{\r\n"
													+ "    \"short_description\": \"This is a put req to update and perform assertion.\"\r\n"
													+ "}")
											.contentType(ContentType.JSON)
											.log().all();
				
		//Step 4: Send the Put Request
		Response response = inputRequest.put();
				
		/*
		 * //Step 5: Validate the Response 
		 * instead just printing the response with "response.prettyPrint();"
		 * We are validating the response code using assertion & Matchers
		 * Also printing logs for response
		 */
		String incNumber = response.jsonPath().getString("result.number");
		System.out.println("Incident number for the request is:" +incNumber);
		response.then().assertThat().statusCode(200).log().all();
		
	}
	
	@Test
	public void patchInc()
	{

				RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table"
										+ "/incident/d7992fcbdb826110766ab7e8f4961957";
				RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
				RequestSpecification inputRequest = RestAssured.given()
													.body("{\r\n"
															+ "    \"short_description\": \"This is a patch req to update and perform assertion.\"\r\n"
															+ "}")
													.contentType(ContentType.JSON)
													.log().all();
						
				//Step 4: Send the patch request 
				Response response = inputRequest.patch();
				
				//verifying resp.body contains the string
				response.then().assertThat().body("result.short_description", 
						Matchers.containsString("update and perform assertion"));
				//verifying response body has number
				response.then().assertThat().body("result.number", 
						Matchers.equalTo("INC0010023"));
				//verifying status code and capturing logs for response
				response.then().assertThat().statusCode(200).log().all();
	}
	
	@Test
	public void deleteInc()
	{

		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table"
								+ "/incident/d7992fcbdb826110766ab7e8f4961957";
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		RequestSpecification inputRequest = RestAssured.given()
											.contentType(ContentType.JSON)
											.log().all();
		//Sending a Delete request
		Response response = inputRequest.delete();
		String statusLine = response.getStatusLine();
		System.out.println("Status line for the request is:" +statusLine);
		response.then().assertThat().statusCode(204);
		response.then().assertThat().log().all();
	}
}
