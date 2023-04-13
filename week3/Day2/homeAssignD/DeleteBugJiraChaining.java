package week3.Day2.homeAssignD;

import org.testng.annotations.Test;

public class DeleteBugJiraChaining extends JiraTestBaseClass{

	@Test (dependsOnMethods = {"week3.Day2.homeAssignD.CreateBugPostMethod.createBug"})
	public void deleteBug()
	{
		response = request.delete("issue/"+bug_Key);
		response.then().assertThat().statusCode(204).and().statusLine("HTTP/1.1 204 No Content");
	}
}
