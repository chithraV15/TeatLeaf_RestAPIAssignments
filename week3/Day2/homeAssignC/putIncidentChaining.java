package week3.Day2.homeAssignC;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class putIncidentChaining extends TestBaseClass
{

	@Test(dependsOnMethods = {"week3.Day2.homeAssignC.CreateIncidentChain.createInc"})
	public void putInc()
	{
		request.given().body("{\r\n"
				+ "    \"short_description\": \"Put update in chaining concept assignment.\"\r\n"
				+ "}");
		response = request.put("incident/" +sys_id);
		
		//Validating response
		
		response.then().assertThat().statusCode(200).and().body("result.short_description", 
				Matchers.containsString("chaining concept assignment"));
		
		
	}
}
