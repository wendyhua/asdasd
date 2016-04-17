package com.cisco.commonclasses;

import static com.cisco.util.DBConnectionManager.commonProperties;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cisco.util.ApplicationUtility;

public class SupportHeader {
	
	//TC4197 from regression suite
	WebDriver driver;
	ApplicationUtility appUtility;
	
	public SupportHeader(){
		
	}
	
	public SupportHeader(ApplicationUtility appUtility){
		driver=appUtility.driver;
		this.appUtility=appUtility;
}
	public void SupportLink() throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement support=driver.findElement(By.xpath("//div[@ class='header']//li[2]//div[@class='section linkwithtext']/a"));
		support.click();
		Thread.sleep(5000);
		String Expurl=commonProperties.getProperty("support");
		String Actualurl=driver.getCurrentUrl();
		System.out.println("Expected URL is:"+Actualurl);
		if(Expurl.equalsIgnoreCase(Actualurl))
		{
			appUtility.logMessage("Validate Support Header Link","Expected URL is "+Expurl,"The Actual url for Support link is "+Actualurl,"passed");
		}
		else
		{
			appUtility.logMessage("Validate Support Header Link","Expected URL is "+Expurl,"The Actual url for Support link is "+Actualurl,"Failed");
		}
		
		
	}
}