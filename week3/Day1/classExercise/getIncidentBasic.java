package week3.Day1.classExercise;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class getIncidentBasic {

	@Test
	public void getInc()
	{
		//Step 1: Requirement (Usually it is given in realtime)
		
		//Step 2: Endpoint
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		
		//Step3: Contruct the Request (params/auth)
		RestAssured.authentication = RestAssured.basic("admin","vh@LW!GjZt78");
		
		//Step 4: Send the Request (Http Method)
		Response resp = RestAssured.get();
		
		//Step 5: Validate the response
		resp.prettyPrint();
		
	}
}
