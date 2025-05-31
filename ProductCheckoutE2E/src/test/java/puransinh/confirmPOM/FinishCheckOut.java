package puransinh.confirmPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.BaseClass.PageInit;

public class FinishCheckOut extends PageInit {

	public FinishCheckOut(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="finish")
	WebElement finishbtn;
	
	By checkoutconfirm=By.id("checkout_complete_container");
	
	@FindBy(className = "complete-header")
	WebElement thankyoumsg;
	
	public String finishCheckOut() {
		finishbtn.click();
		elementVisibility(checkoutconfirm, driver);
		return thankyoumsg.getText();
		
	}
}
