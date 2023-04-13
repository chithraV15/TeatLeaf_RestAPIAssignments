package week3.Day2.homeAssignD;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBugPostMethod extends JiraTestBaseClass{

	@Test
	public void createBug()
	{
		File file = new File("./src/test/resources/jiraBody.json");
		request.given().body(file);
		//Step 4: Send the request using Http method
		response = request.post("issue/");
		
		//Step 5: validate response
		bug_Key = response.jsonPath().get("key");
		System.out.println("Bug Id in Jira is:" +bug_Key);
		response.then().assertThat().statusCode(201);
		response.then().assertThat().statusLine("HTTP/1.1 201 Created");
	}
}
