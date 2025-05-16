package puransinh.ExtentReports;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	 static ExtentReports reports;
    @BeforeMethod
	public static ExtentReports config() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
    	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
    	
    	reporter.config().setReportName("Ecommerce Web Automatoin Test");
    	reporter.config().setDocumentTitle("Test Results");
    	
    	reports=new ExtentReports();
    	reports.attachReporter(reporter);
    	reports.setSystemInfo("Tester", "Puransinh Rao");

		return reports;
		
	}
	@Test
	public void InitDriver() {
		reports.createTest("Driver Init");
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		System.out.println(driver.getTitle());
		driver.close();
		driver.quit();
		reports.flush();
		
		
	}
	
}
