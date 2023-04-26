package stepDefinitions;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

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

public class MyStepDefinition {

	static RequestSpecification request = null;
	static Response response = null;
	
	@Given("endpoint set up")
	public void endpoint_set_up() {
	    RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/incident";
	}
	
	@And("provide the auth")
	public void provide_the_auth() {
	    RestAssured.authentication = RestAssured.basic("admin", "paSSword@15");
	}
	
	@When("pass the request body as {string}")
	public void pass_the_request_body_as(String filePath) {
		File file = new File(filePath);
	    request = RestAssured.given().contentType(ContentType.JSON)
	    				.body(file).log().all();
	}
	
	@Then("send the request")
	public void send_the_request() {
	    response = request.post();
	}
	
	@And("validate the response")
	public void validate_the_response() {
		
		try {
	    response.then().assertThat().body("result.number", Matchers
				.startsWith("INC")).and().body("result", Matchers.hasKey("correlation_id"));
		}
		catch(Exception e) {
			System.out.println("Validation error");
			response.then().log().all();
		}
	}
}
