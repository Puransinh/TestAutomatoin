package puransinh.TestComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	public WebDriver driver;
	public String getScreenshot(String testcasename,WebDriver driver) throws IOException {
		driver=this.driver;
		TakesScreenshot ts= (TakesScreenshot) driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File file=new File(System.getProperty("user.dir") + "//reports//"+ testcasename + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "//reports//"+ testcasename + ".png";
	}
	
@BeforeMethod
public  void initDriver() {
	
    driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
//	driver.manage().window().fullscreen();
	driver.get("https://rahulshettyacademy.com/client");
	
	

}

@AfterMethod
public void closeBrowser() {
	driver.quit();
}



}
