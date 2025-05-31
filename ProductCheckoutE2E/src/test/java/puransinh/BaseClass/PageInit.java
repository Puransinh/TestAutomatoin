package puransinh.BaseClass;

import java.sql.Driver;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class PageInit {

	public WebDriver driver;

	public WebDriver InitDriver() {
	
		driver=new FirefoxDriver();
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
		
	}
	
	@BeforeMethod
	public void loginPage() {
		driver=InitDriver();
		driver.get("http://www.saucedemo.com");
		
	}
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}
	
	public WebElement elementVisibility(By Findby,WebDriver driver) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement elementwait=wait.until(ExpectedConditions.visibilityOfElementLocated(Findby));
		return elementwait;
		
		
	}
}
