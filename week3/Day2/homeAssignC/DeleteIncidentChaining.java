package week3.Day2.homeAssignC;

import org.testng.annotations.Test;

public class DeleteIncidentChaining extends TestBaseClass{

	@Test(dependsOnMethods = {"week3.Day2.homeAssignC.CreateIncidentChain.createInc"})
	public void delInc()
	{
		response = request.delete("incident/" +sys_id);
		response.then().assertThat().statusCode(204);
		System.out.println(response.getStatusLine());
	}
}
