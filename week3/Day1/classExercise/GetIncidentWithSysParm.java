package week3.Day1.classExercise;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetIncidentWithSysParm {
	
	@Test
	public void getIncWithSysParm()
	{
		//Step 1: Requirement
		//Step 2: Endpoint
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		//Step 3: Construct the Req
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		RequestSpecification inputRequest = RestAssured.given()
												       .queryParam("sysparm_fields","number");
		//Step 4: Send the Req
		Response response = inputRequest.get();
		//Step 5: Validate Response
		response.prettyPrint();
	}

}
