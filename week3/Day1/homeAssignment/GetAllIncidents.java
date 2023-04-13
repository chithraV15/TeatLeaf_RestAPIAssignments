package week3.Day1.homeAssignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllIncidents {

	@Test
	public void getAllInc()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resources
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		
		//Step 3: Contruct the Request (Params, Header, Body, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		
		//Step 4: Send the Req
		Response response = RestAssured.get();
		
		//Step 5: Validate the Response
		response.prettyPrint();
	}
}
