package puransinh.main;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import puransinh.BaseClass.PageInit;
import puransinh.cartPOM.CartPOM;
import puransinh.checkoutPOM.CheckOutDetails;
import puransinh.confirmPOM.FinishCheckOut;
import puransinh.loginPOM.LoginPOM;
import puransinh.productPOM.CartDetails;

public class Main extends PageInit {

	@Test(dataProvider="getproductname")
	public void loginTest(HashMap<String,String> input) throws InterruptedException {
		
		LoginPOM login=new LoginPOM(driver);
		boolean islogin=login.loginPage(input.get("username"),input.get("password"));
		CartPOM cartpage=new CartPOM(driver);
		assertEquals(true, islogin);
		}
	
	@Test(dataProvider = "getproductname")
	public void cartdetails(HashMap<String,String> input) throws InterruptedException {
		LoginPOM login=new LoginPOM(driver);
		boolean islogin=login.loginPage(input.get("username"),input.get("password"));
		CartPOM cartpage=new CartPOM(driver);
		CartDetails caratdetails=new CartDetails(driver);
		String product_name=input.get("productname");
		String actual_product_price=cartpage.getProductprice(product_name);
		String actual_product_desc=cartpage.getProductText(product_name);
		
		String cart_product_price=caratdetails.getprouctprice(product_name);
		String cart_product_desc=caratdetails.getprouctdesc(product_name);

		String cart_product_name=caratdetails.getprouctname(product_name);
		
		assertEquals(actual_product_desc, cart_product_desc);
		assertEquals(actual_product_price, cart_product_price);
		assertEquals(product_name, cart_product_name);
		
	}
	
	@Test(dataProvider = "getproductname")
	public void checkouttest(HashMap<String,String> input) throws InterruptedException {
		LoginPOM login=new LoginPOM(driver);
		boolean islogin=login.loginPage(input.get("username"),input.get("password"));
		CartPOM cartpage=new CartPOM(driver);
		CartDetails caratdetails=new CartDetails(driver);
		String product_name=input.get("productname");
		String actual_product_price=cartpage.getProductprice(product_name);
		String actual_product_desc=cartpage.getProductText(product_name);
		
		String cart_product_price=caratdetails.getprouctprice(product_name);
		String cart_product_desc=caratdetails.getprouctdesc(product_name);

		String cart_product_name=caratdetails.getprouctname(product_name);
		
		assertEquals(actual_product_desc, cart_product_desc);
		assertEquals(actual_product_price, cart_product_price);
		assertEquals(product_name, cart_product_name);
		ArrayList<String> allcheckoutdata=new ArrayList<>();
		CheckOutDetails checkoutdata=new CheckOutDetails(driver);
	    allcheckoutdata.addAll(checkoutdata.checkOut());
		String checkoutprodname=allcheckoutdata.get(0);
		String checkoutproddesc=allcheckoutdata.get(2);

		String checkoutprodprice=allcheckoutdata.get(1);

		String checkoutprodsubtotal=allcheckoutdata.get(3);
		
		assertEquals(actual_product_desc, checkoutproddesc);
		assertEquals(actual_product_price, checkoutprodprice);
		assertEquals(product_name, checkoutprodname);
		assertEquals(actual_product_price, checkoutprodsubtotal.split(":")[1].trim());
		
		FinishCheckOut finish=new FinishCheckOut(driver);
		String finishmsg=finish.finishCheckOut();
		assertEquals("Thank you for your order!", finishmsg);

		
}
	
	@DataProvider
	public Object[][] getproductname() {
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("username", "standard_user");
		map.put("password", "secret_sauce");
		map.put("productname", "Sauce Labs Backpack");
		return new Object [] [] {{map}};
		
	}
	
	 


}


