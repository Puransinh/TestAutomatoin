package puransinh.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;

import puransinh.ExtentReports.ExtentReportsDemo;

public class Listeners extends BaseTest  implements ITestListener{
	  ExtentTest test;
	  ExtentReports reports= ExtentReportsDemo.config();
	  @Override
	    public void onTestStart(ITestResult result) {
	        test=reports.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        test.log(Status.PASS,"Test Passed");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	        test.fail(result.getThrowable());
	        try {
				driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
	        // You can also capture screenshots here
	        String filepath=null;
	        try {
				filepath=getScreenshot(result.getMethod().getMethodName(),driver);
				test.addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("Test Skipped: " + result.getName());
	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	        // This is for cases where tests fail but the failure is within the success percentage
	        System.out.println("Test Failed but within success percentage: " + result.getName());
	    }

	    @Override
	    public void onStart(org.testng.ITestContext context) {
	        System.out.println("Test Suite Started: " + context.getName());
	    }

	    @Override
	    public void onFinish(org.testng.ITestContext context) {
	        reports.flush();
	        
	    }    
}
