package TestApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Models.Order;
import Models.Pet;
import Models.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExtentManager;

public class PetTest extends BaseTest {

	@Test(priority=0)
	public void addPetTest() {
		ExtentManager.logStep("Endpoint to test: " + pw.getProp("baseUrl") + pw.getProp("petCreateEndpoint"));
		Pet p = new Pet("benny").addPhotoUrl("check").addTag("mark");
		String jsonToSend = p.toJson();
		ExtentManager.logStep("json string to be sent: " + jsonToSend);
		Response res = RestAssured.given().body(jsonToSend).post(pw.getProp("petCreateEndpoint"));
		long createdId = res.jsonPath().getLong("id");
		ExtentManager.logStep("id to remove when clean: " + createdId);
		Pet.addIdToRemove(createdId);
		String resBody = res.then().extract().asString();	
		ExtentManager.logStep("response json: " + resBody);
		int statusCode = res.statusCode();
		ExtentManager.logStep("Status code: " + res.statusCode());
		assertEquals(200, statusCode);
	}
	
	@AfterClass
	public void cleanup() {
		/*
		 * right now i clean all tests data created here,
		 * this can happen in each test class individually if necesssary
		 */
	}
	
	
	
	
	
}
