package puransinh.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.TestComponents.BaseTest;

public class loginPageObject extends BaseTest{
    WebDriver driver;
	
    public loginPageObject(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	
    }
    
    	@FindBy(id="userEmail")
    	WebElement usermail;
    	
    	@FindBy(id="userPassword")
    	WebElement userpassword;
    	
    	@FindBy(id="login")
    	WebElement login;
    	
    	@FindBy(css ="app-dashboard[class*='ng-star-inserted']")
    	List<WebElement> mainpage;
    	public void loginCred(String useremail, String password) {
    		
    		usermail.sendKeys(useremail);
    		userpassword.sendKeys(password);
    		login.click();
    	
    	}
    	
    	public List<WebElement> mainPage() {
    		return mainpage;
    	}
    	
    	
    
	
}
