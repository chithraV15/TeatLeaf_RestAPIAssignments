package week3.Day2.homeAssignC;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class CreateIncidentChain extends TestBaseClass{
	
	@Test
	public void createInc()
	{
		//Send the request to create incident Table
		File file = new File("./src/test/resources/body.json");
		request.given().body(file);
		response = request.post("incident");
		
		//Validate the response
		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201).and()
							.body("result.number", Matchers.containsString("INC"));
	}

	
}
