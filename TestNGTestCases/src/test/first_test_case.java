package test;

import org.testng.annotations.Test;

public class first_test_case {
 @Test
 public void login(){
	 System.out.println("Successfully Login");
 }
 @Test
 public void logout(){
	 System.out.println("Successfully Logout");
 }
 @Test
 public void failed_login(){
	 System.out.println("Failed To Login");
 }
 
}
