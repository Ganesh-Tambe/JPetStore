package com.JPetStore.JPetStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginJPetStore {
	WebDriver driver;
 @BeforeTest
 public void beforeTest()
 {
	 driver=new ChromeDriver();
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
 }
	@Test
  public void login() {
	 driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	 WebElement username=driver.findElement(By.name("username"));
	 username.sendKeys("j2ee");
	
	 driver.findElement(By.xpath("//input[@name='signon']")).click();
	 WebElement text=driver.findElement(By.xpath("//div[@id='Welcome']"));
	 Assert.assertEquals(text.getText(), "Welcome ABC!") ;
	 
  }
	@Test
	public void  logout()
	{
		driver.findElement(By.linkText("Sign Out")).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	@AfterTest
	public void after()
	{
		driver.close();
	}
}