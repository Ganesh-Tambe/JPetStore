package com.JPetStore.JPetStore;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class LoginJPetStore {
	WebDriver driver;
	WebDriverWait wait;
 @BeforeTest
 public void beforeTest()
 {
	 driver=new ChromeDriver();
	  driver.get("https://petstore.octoperf.com/actions/Catalog.action");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  wait =new WebDriverWait(driver, Duration.ofSeconds(10));
 }
 //Login Functionality
	@Test
  public void login() {
	 driver.findElement(By.xpath("//a[text()='Sign In']")).click();
	 WebElement username=driver.findElement(By.name("username"));
	 username.sendKeys("j2ee");
	
	 driver.findElement(By.xpath("//input[@name='signon']")).click();
	 WebElement text=driver.findElement(By.xpath("//div[@id='Welcome']"));
	 Assert.assertEquals(text.getText(), "Welcome ABC!") ;
	 
  }
	//Logout Functionality
	@Test
	public void  logout() throws InterruptedException
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sign Out']"))).click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://petstore.octoperf.com/actions/Catalog.action");
	}
	
	@AfterTest
	public void after()
	{
		driver.close();
	}
}
