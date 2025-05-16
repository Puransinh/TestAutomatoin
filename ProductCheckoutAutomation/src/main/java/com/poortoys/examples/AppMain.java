package com.poortoys.examples;

import java.security.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.ModifierReviewable.OfAbstraction;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {
        String url="https://www.saucedemo.com/";
        String username="standard_user";
        String firstname="Test";
        String lastname="User";
        String zip="45678";
        String password="secret_sauce";
        String productname="Sauce Labs Bike Light";
        String expectedconfirmation="Thank you for your order!";
        
        
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", Map.of(
            "credentials_enable_service", false,
            "profile.password_manager_enabled", false
        ));
        
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        
        
        driver.get(url);
        
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
                
   
        List<WebElement> productsiteams=driver.findElements(By.className("inventory_item"));
        
        WebElement products= productsiteams.stream().filter(product -> product.findElement(By.className("inventory_item_name")).getText().equalsIgnoreCase(productname)).findFirst().orElse(null);        
        products.findElement(By.className("btn_inventory")).click();
        
        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_list")));
        driver.findElement(By.className("btn_action")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_info_container")));
        
        driver.findElement(By.id("first-name")).sendKeys(firstname);
        driver.findElement(By.id("last-name")).sendKeys(lastname);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        
        driver.findElement(By.id("continue")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart_list")));
        
        driver.findElement(By.id("finish")).click();
        
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("checkout_complete_container")));
        
        boolean actualconfirmation=driver.findElement(By.className("complete-header")).getText().equalsIgnoreCase(expectedconfirmation);
        
        if (actualconfirmation==true){
        	
        	System.out.println("Order Send Successfully");
        	
        }
        
        else {
        	System.out.println("Error in Sending Orders");
        }
  
          
        
        
     
        driver.quit();
        
        
    }

}
