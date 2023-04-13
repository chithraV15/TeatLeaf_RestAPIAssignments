package week3.Day2.classExercise;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteInc {

	@Test
	public void deleteInc()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resource
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident/db5f3a47db026110766ab7e8f496197e";
		
		//Step 3: Contruct the Request (params, body, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
				
		//Step 4: Send the req
		Response response = RestAssured.delete();
		
		//Step 5: Validate the Response
		response.prettyPrint();
		
	}
}
