package hooks;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class MyBaseHookClass {
	
	
	@Before
	public void setUp()
	{
		RestAssured.baseURI = "https://dev65287.service-now.com/api/now/table/";
		RestAssured.authentication = RestAssured.basic("admin", "vh@LW!GjZt78");
	}
	
}
