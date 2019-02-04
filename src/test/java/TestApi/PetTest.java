package TestApi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.ExtentManager;

public class PetTest extends BaseTest {

	@Test(priority=0)
	public void addPet() {
		ExtentManager.logStep("step 1");
//		   Response res = RestAssured.given().when().get("pet/1");
//		   String resBody = res.then().extract().asString();
//		   System.out.println(resBody);		
		
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
