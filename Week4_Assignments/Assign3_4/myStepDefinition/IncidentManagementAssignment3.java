package myStepDefinition;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import org.hamcrest.Matchers;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class IncidentManagementAssignment3 {
	
	public static RequestSpecification request = null;
	public static Response response = null;
	public static String sys_id = null;
	public static String randomDescp = null; 
		
	//Create Inc - Post req code follows
	
	@Given("add the description as {string} and category as {string}")
	public void add_the_description_as_and_category_as(String descp, String categ) {
	    request = RestAssured.given().contentType(ContentType.JSON)
	    							 .body("{\r\n"
	    							 		+ "    \"description\": \""+descp+"\",\r\n"
	    							 		+ "    \"category\": \""+categ+"\"\r\n"
	    							 		+ "}").log().all();
	}
	
	@When("send the create request")
	public void send_the_create_request() {
	    response = request.post("incident");
	    sys_id = response.jsonPath().get("result.sys_id");
	}
	//validating response using data table
	@Then("validate the response for below")
	public void validate_the_response_for_below(DataTable dTable) {
	    //converting dataTable as a Map entry for <K,V> pair
		Map<String,String> mapValues = dTable.asMap();
		//Entry is a collection view of Map. Converting entire Map above to each entrySet
	    for(Entry<String,String> eachEntry : mapValues.entrySet()) {
	    	response.then().body(eachEntry.getKey(), Matchers.containsString(eachEntry.getValue()));
	    }
		response.then().assertThat().statusCode(201).
	    				and().body("result.task_effective_number", Matchers.hasLength(10));
	}
	
	//Put request scenario code follows
	
	@Given("add the random digit in body")
	public void add_the_random_digit_in_body() {
		String randomAlphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		Random random = new Random();
		int length = 6;
		for(int i=0;i<=length;i++)
		{
			int index = random.nextInt(randomAlphaNum.length());
			char randomChar = randomAlphaNum.charAt(index);
			builder.append(randomChar);
		}
		String randomString = builder.toString();
		System.out.println(randomString);
	//Assigning generated string to instance variable
		randomDescp = randomString;
		request.given().body("{\r\n"
				+ "    \"description\": \""+randomString+"\"\r\n"
				+ "}");
    	}
	
	@When("send the put request")
	public void send_the_put_request() {
	  response = request.put("incident/"+sys_id);
	}
	
	@Then("validate the response for update request")
	public void validate_the_response_for_update_request() {
	    response.then().assertThat().statusCode(200).and()
	    				.body("result.description", Matchers.equalTo(randomDescp)).log().all();
	}
	
	//Delete Req Scenario code follows
	@When("send the delete request")
	public void send_the_delete_request() {
	    response = request.delete("incident/"+sys_id);
	}
	
	@Then("validate the response for delete request")
	public void validate_the_response_for_delete_request() {
	    response.then().assertThat().statusCode(204).log().all();
	}
	
	@And ("verify the deleted inc")
	public void verify_the_deleted_inc()
	{
		response = request.get("incident/"+sys_id);
		response.then().assertThat().body("error.detail", 
				Matchers.equalToIgnoringWhiteSpace("Record doesn't exist or ACL restricts the record retrieval")).log().all();
	}

}
