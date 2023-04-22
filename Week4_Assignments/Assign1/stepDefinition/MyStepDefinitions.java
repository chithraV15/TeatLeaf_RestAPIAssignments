package stepDefinition;

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

public class MyStepDefinitions {
	
	RequestSpecification request = null;
	Response response = null;
	
	@Given("set the endpoint")
	public void set_the_endpoint() {
	    RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/";
	}
	
	@And("add the auth")
	public void add_the_auth() {
	   RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
	}
	
	@And("add the queryParams as {string} and {string}")
	public void add_the_query_params_as_and(String s1, String s2) {
	    request = RestAssured.given().contentType(ContentType.JSON)
	    							 .queryParam(s1,s2).log().all();
	}
	
	@When("post the request with short description as {string} and category as {string}")
	public void post_the_request_with_short_description_as_and_category_as(String short_descp, String category) {
	    response = request.body("{\r\n"
	    		+ "    \"short_description\": \""+ short_descp +"\",\r\n"
	    		+ "    \"category\": \""+ category +"\"\r\n"
	    		+ "}").post("incident");
	}
	
	@Then("validate the response for {string} and {string} and {string}")
	public void validate_the_response_for_and_and(String value, String short_descp, String category) {
	    
		response.then().log().all();
			
		
		  if(value == "1") 
		  { response.then().assertThat().body("result.category",
		  Matchers.equalTo(category)); 
		  } 
		  else if(value == "2") 
		  {
		  response.then().assertThat().body("result.category",
		  Matchers.not("software,inquiry")); 
		  } 
		  else {
		  response.then().assertThat().body("result.short_description",
		  Matchers.notNullValue()); 
		  }
		 
	}


}
