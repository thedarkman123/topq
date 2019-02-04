package TestApi;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Models.Pet;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.ExtentManager;

public class PetTest extends BaseTest {

	@Test(priority=0)
	public void addPet() {
		//just for testing sake, no dynamic stuff happen
		Pet p = new Pet("benny").addPhotoUrl("check").addTag("mark");
		String jsonToSend = p.toJson();
		ExtentManager.logStep("created json: " + jsonToSend);
		Response res = RestAssured.given().body(jsonToSend).post("/pet");
		String resBody = res.then().extract().asString();	
		ExtentManager.logStep("response json: " + resBody);
		int statusCode = res.statusCode();
		ExtentManager.logStep("Status code: " + res.statusCode());
		assertEquals(200, statusCode);
	}
	
	@Test(priority=1)
	public void addPetOrder() {
		ExtentManager.logStep("step 1");
	}
	
	@AfterMethod
	public void clean() {
		//System.out.println("clean");
	}
}
