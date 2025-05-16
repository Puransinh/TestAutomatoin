package puransinh.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import puransinh.TestComponents.BaseTest;
import puransinh.pageobject.loginPageObject;

public class LoginTest extends BaseTest{

	String useremail="sotaxog342@cotigz.com";
	String password="Hello@123";
	String invaliduseremail="sotaxogxxx@cotigz.com";
	@Test
	public void validUser() {
		
		loginPageObject login=new loginPageObject(driver);
		login.loginCred(useremail, password);
		assertEquals(driver.getTitle(), "Hello World");
		
			}
		
		
	
	@Test
	public void inValidUser() {
		loginPageObject login=new loginPageObject(driver);
		login.loginCred(invaliduseremail, password);
		
	}
	
}
