package week3.Day2.homeAssignD;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class EditBugPutMethod extends JiraTestBaseClass{

	@Test(dependsOnMethods = {"week3.Day2.homeAssignD.CreateBugPostMethod.createBug"})
	public void putBug()
	{
		//If i give 
		request.given().body("{\r\n"
				+ "  \"fields\": {\r\n"
				+ "    \"summary\": \"Eighth bug creation in RES proj\"\r\n"
				+ "  }\r\n"
				+ "}");
		//Step 4: Send the request using Http method
		response = request.put("issue/"+bug_Key);
		
		//Step 5: validate response
		
		response.then().assertThat().statusCode(204);
		response.then().assertThat().statusLine("HTTP/1.1 204 No Content").and()
								.body("fields.summary", Matchers.containsString("Eighth bug"));
	}
}
