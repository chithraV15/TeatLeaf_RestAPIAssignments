package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MyStepDef {
	
	public static RequestSpecification request = null;
	public static Response response = null;
	public static String sys_id = null;
	
	@Given("set the endpoint")
	public void set_the_endpoint() {
	    RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/";
	}
	
	@And("add the auth")
	public void add_the_auth() {
	    RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
	}
	
	@And("contruct the request")
	public void contruct_the_request() {
	    request = RestAssured.given().contentType(ContentType.JSON).log().all();
	}
	
	@Given("send the post request")
	public void send_the_post_request() {
	    request.given().body("{\r\n"
	    		+ "    \"short_description\": \"Cucumber Tags Request inc creation\",\r\n"
	    		+ "    \"description\": \"Tags incident creation for cucumber assignment 2.\"\r\n"
	    		+ "}");
	    response = request.post("incident");
	}
	
	@Then("validate the response for post")
	public void validate_the_response_for_post() {
		
		sys_id = response.jsonPath().get("result.sys_id");
		response.then().assertThat().statusCode(201).log().all();
	   
	}
	
	//Code for Change request table
	@When ("send the request for crTable")
	public void send_the_request_for_crTable() {
		request.given().body("{\r\n"
				+ "    \"short_description\": \"This short descp for chg req table\",\r\n"
				+ "    \"description\": \"Description given for chg req table.\"\r\n"
				+ "}");
		response = request.post("change_request");
	}
	
	//code for change req table
	@Then ("validate the response for crTable")
	public void validate_the_response_for_crTable() {
		response.then().assertThat().statusCode(201).log().all();
	}
	
	//send get request
	@Given("send the get request")
	public void send_the_get_request() {
	   response = request.get("incident/"+sys_id);
	   
	}
	
	//validate get request
	@Then("validate the response for get")
	public void validate_the_response_for_get() {
		response.then().assertThat().statusCode(200).log().all();
	}
		
	@Given("send the get request for all incidents")
	public void send_the_get_request_for_all_incidents() {
	    response = request.get("incident");
	}
	
	@Then("validate the response for getAll")
	public void validate_the_response_for_get_all() {
		response.then().assertThat().statusCode(200).log().all();
	}
	
	@Given("send the put request")
	public void send_the_put_request() {
	    request.given().body("{\r\n"
	    		+ "    \"short_description\": \"Put update on Cucumber tags request.\"\r\n"
	    		+ "}");
	    response = request.put("incident/"+sys_id);
	}
	
	@Then("validate the response for put")
	public void validate_the_response_for_put() {
	    response.then().assertThat().statusCode(200).log().all();
	}
	
	@Given("send the delete request")
	public void send_the_delete_request() {
	    response = request.delete("incident/"+sys_id);
	}
	
	@Then("validate the response for delete")
	public void validate_the_response_for_delete() {
		response.then().assertThat().statusCode(204).log().all();
	}
	
}
