package week3.Day2.homeAssignD;

import java.io.File;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ListBugGetMethod extends JiraTestBaseClass{

	@Test (dependsOnMethods = {"week3.Day2.homeAssignD.CreateBugPostMethod.createBug"})
	public void getBug()
	{
		//Step 4: Send the request using Http method
		response = request.get("issue/"+bug_Key);
		
		//Step 5: validate response
		
		response.then().assertThat().body("key", Matchers.containsString("RES-"));
		response.then().assertThat().statusCode(200).and().statusLine("HTTP/1.1 200 OK");
	}
	
	
}
