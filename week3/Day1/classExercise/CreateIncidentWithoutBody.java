package week3.Day1.classExercise;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateIncidentWithoutBody {

	@Test
	public void createInc()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resource
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		
		//Step 3: Contruct the Req (auth, params, body, header, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		
		//For a POST request "Content-Type" is mandatory
		RequestSpecification inputRequest = RestAssured.given()
											.contentType(ContentType.JSON);
		
		//Step 4: Send the Request
		Response response = inputRequest.post();
		
		//Step 5: Validate the Response
		response.prettyPrint();
		
	}
}
