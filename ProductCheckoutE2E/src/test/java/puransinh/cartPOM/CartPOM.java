package puransinh.cartPOM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import puransinh.BaseClass.PageInit;

public class CartPOM extends PageInit {

	public CartPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "inventory_item")
	List<WebElement> productlist;
	

    By selectedproduct=By.className("inventory_item_name");
    By productdes=By.className("inventory_item_desc");
 
	By addtocart=By.className("btn_inventory");

	By productprice=By.className("inventory_item_price");

	
	public  WebElement findProduct(String productname) {
		
		try {
			elementVisibility(selectedproduct, driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement productretrival=productlist.stream().filter(product -> product.findElement(selectedproduct).
				getText().equalsIgnoreCase(productname)).findFirst().orElse(null);
		
		return productretrival;
	}
	
	public String getProductText(String prouduct) {
		
		WebElement product=findProduct(prouduct);
		String proudcttext=product.findElement(productdes).getText();

		return proudcttext;
 
		
	}
	
public String getProductprice(String prouduct) {
		
		WebElement product=findProduct(prouduct);
		String proudcttext=product.findElement(productprice).getText();
		product.findElement(addtocart).click();
		
		return proudcttext;
 
		
	}

}
