package TestApi;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Models.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentManager;

public class UserTest extends BaseTest {
	@Test(priority=2)
	public void addUserTest() {
		ExtentManager.logStep("Endpoint to test: " + pw.getProp("baseUrl") + pw.getProp("userCreateEndpoint"));
		String userName = "thedark"; //this can be randomized (like all the other data) later if needed
		User u = new User(userName, "ben", "ben", "benny@gmail.com", "blah", "056231231");
		String jsonToSend = u.toJson();
		ExtentManager.logStep("Username to remove when clean " + userName);
		User.addUsernameToRemove(userName);
		ExtentManager.logStep("json string to be sent: " + jsonToSend);
		Response res = RestAssured.given().body(jsonToSend).post(pw.getProp("userCreateEndpoint"));
		int statusCode = res.statusCode();
		ExtentManager.logStep("Status code: " + res.statusCode());
		assertEquals(200, statusCode);
	}
	
	@AfterClass
	public void cleanup() {
		System.out.println(User.getCreatedUserNames());	
	}
	
}
