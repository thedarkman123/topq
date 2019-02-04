package TestApi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import utils.PropertiesWrapper;


public class BaseTest {
	
	protected PropertiesWrapper pw = new PropertiesWrapper("OR");
	@BeforeMethod
	public void setup() {
		//baseTest
		RestAssured.baseURI = pw.getProp("baseUrl");
		//allowhttps
		RestAssured.useRelaxedHTTPSValidation();
		//work with jsons
		RequestSpecification requestSpecification = new RequestSpecBuilder()
				.addHeader("Content-Type", "application/json")
				.addHeader("api_key", "special-key")
				.build();
		RestAssured.requestSpecification = requestSpecification;
	}
	
	
}
