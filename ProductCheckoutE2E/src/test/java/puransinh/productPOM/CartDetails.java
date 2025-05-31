package puransinh.productPOM;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.BaseClass.PageInit;

public class CartDetails extends PageInit {

	WebDriver driver;
	public CartDetails(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css ="a[class*='cart_link']")
	WebElement cartlink;
	By cartlist=By.className("cart_list");
	
	@FindBy(className = "cart_item")
	List<WebElement> cartiteam;
	
	By proudctname=By.className("inventory_item_name");
	By proudctdesc=By.className("inventory_item_desc");
	By productprice=By.className("inventory_item_price");

	public List<WebElement> cartData() {
		cartlink.click();
		elementVisibility(cartlist, driver);
		return cartiteam;
	}
	
	public String getprouctname(String proudct_name) {
		String proudct=cartData().getFirst().findElement(proudctname).getText();
				return proudct;
	}
	public String getprouctdesc(String proudct_name) {
		String proudctdetails=cartData().getFirst().findElement(proudctdesc).getText();
				return proudctdetails;
	}
	public String getprouctprice(String proudct_name) {
		String proudctpriceval=cartData().getFirst().findElement(productprice).getText();
				return proudctpriceval;
	}
}
