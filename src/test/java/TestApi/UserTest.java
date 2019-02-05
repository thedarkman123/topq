package TestApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Models.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentManager;

public class UserTest extends BaseTest {
	@Test(priority=2)
	public void addUserTest() {
		//this one receive no body when creating user
		User u = new User("thedark", "ben", "ben", "benny@gmail.com", "blah", "056231231");
		String jsonToSend = u.toJson();
		ExtentManager.logStep("json string to be sent: " + jsonToSend);
		Response res = RestAssured.given().body(jsonToSend).post(pw.getProp("userCreateEndpoint"));
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
