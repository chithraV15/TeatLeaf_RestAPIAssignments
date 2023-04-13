package week3.Day2.homeAssignC;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class GetIncidentUsingChaining extends TestBaseClass
{

	@Test(dependsOnMethods = {"week3.Day2.homeAssignC.CreateIncidentChain.createInc"})
	public void getInc()
	{
		response = request.get("incident/" +sys_id);
		response.then().assertThat().body("result.number", Matchers.startsWith("INC"))
									.and().body("result.short_description", 
											Matchers.containsString("This is a short "
													+ "description from File for Assignment C"));
		response.then().assertThat().statusCode(200);
	}
}
