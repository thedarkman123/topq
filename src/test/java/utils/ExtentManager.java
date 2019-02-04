package utils;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static ExtentTest getTestInstance() {
		return test;
	}
	
	public static void initializeTest(String testName) {
		if (extent == null) {
			getInstance();
		}
		test = extent.startTest(testName);
	}
	
	public static void endTest() {
		extent.endTest(test);
		extent.flush();
	}
	
	public static void logStep(String log) {
		test.log(LogStatus.INFO, log); 
	}
	
	public static void logPass(String log) {
		test.log(LogStatus.PASS, log + " PASSED"); 
	}
	
	public static void logFail(String testName,String error) {
		test.log(LogStatus.FAIL, testName + " Failed,exception: " + error);
	}
	
	public static ExtentReports getInstance() {
		if (extent == null) {	
			extent = new ExtentReports(
			System.getProperty("user.dir")
			+"\\target\\surefire-reports\\html\\extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")
		    +"\\src\\test\\resources\\extentConfig\\ReportsConfig.xml"));
		}
		
		return extent;
	}
}
