package puransinh.loginPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.BaseClass.PageInit;

public class LoginPOM extends PageInit{

	
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "input[placeholder='Username']")
	WebElement username;

	@FindBy(css="input[placeholder='Password']")
	WebElement password;
	
	@FindBy(className ="submit-button")
	WebElement submit;
	

	By landingpage=By.className("app_logo");
	
	public boolean loginPage(String name,String pwd) {
		username.sendKeys(name);
		
		password.sendKeys(pwd);
		
		submit.click();
		boolean islandingpage=elementVisibility(landingpage, driver).isDisplayed();
		return islandingpage;
		
		
		}
}
