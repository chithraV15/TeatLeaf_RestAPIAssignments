package week3.Day1.homeAssignment;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllIncidentsWithSysParams {

	@Test
	public void getAllInc()
	{
		//Step 1: Requirement
		//Step 2: Endpoint with resources
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
		
		//Step 3: Contruct the Request (Params, Header, Body, auth, etc)
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
		
		//Creating a collection object for multiple params
		Map<String,String> mapValues = new HashMap<String,String>();
		mapValues.put("sysparm_fields", "sys_id,category");
		mapValues.put("category", "hardware");
		
		//Passing params using RequestSpecification class
		RequestSpecification inputRequest = RestAssured.given().queryParams(mapValues);
		
		//Step 4: Send the Req
		Response response = inputRequest.get();
		
		//Step 5: Validate the Response
		response.prettyPrint();
	}
}
