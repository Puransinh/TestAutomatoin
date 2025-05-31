package puransinh.checkoutPOM;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.BaseClass.PageInit;

public class CheckOutDetails extends PageInit {
 
	public CheckOutDetails(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="checkout")
	WebElement checkoutbtn;
	
	@FindBy(id="first-name")
	WebElement first_name;
	
	@FindBy(id="last-name")
	WebElement last_name;
	
	By checkoutinfo=By.className("checkout_info_container");
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement continuebtn;
	

	
	By checkoutsummary=By.id("checkout_summary_container");
	
	@FindBy(className = "inventory_item_name")
	WebElement productname;
	
	@FindBy(className = "inventory_item_price")
	WebElement productprice;
	
	@FindBy(className = "inventory_item_desc")
	WebElement productdesc;
	
	@FindBy(className = "summary_subtotal_label")
	WebElement productsubtotal;
	
	ArrayList<String> checkoutdata=new ArrayList<String>();
	public ArrayList<String> checkOut() throws InterruptedException {
		Thread.sleep(3000);;
		checkoutbtn.click();
		elementVisibility(checkoutinfo, driver);
		first_name.sendKeys("Puran Rao");
		last_name.sendKeys("Rao");
		postalcode.sendKeys("10008");
		continuebtn.click();
		
		elementVisibility(checkoutsummary, driver);
		String prodname=productname.getText();
		String prodprice=productprice.getText();
		String proddesc=productdesc.getText();
		String prodsubtotal=productsubtotal.getText();
		checkoutdata.add(prodname);
		checkoutdata.add(prodprice);
		checkoutdata.add(proddesc);
		checkoutdata.add(prodsubtotal);
		
		return checkoutdata ;
		
	}
}


