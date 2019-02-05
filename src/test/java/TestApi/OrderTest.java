package TestApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Models.Order;
import Models.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentManager;

public class OrderTest extends BaseTest {
	@Test(priority=1)
	public void addPetOrderTest() {
		ExtentManager.logStep("Endpoint to test: " + pw.getProp("baseUrl") + pw.getProp("petCreateOrderEndpoint"));
		Order o = new Order(1,24);
		String jsonToSend = o.toJson();
		ExtentManager.logStep("json string to be sent: " + jsonToSend);
		Response res = RestAssured.given().body(jsonToSend).post(pw.getProp("petCreateOrderEndpoint"));
		long createdId = res.jsonPath().getLong("id");
		ExtentManager.logStep("id to remove when clean: " + createdId);
		Order.addIdToRemove(createdId);
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
