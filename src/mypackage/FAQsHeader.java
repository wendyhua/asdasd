package com.cisco.commonclasses;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cisco.util.ApplicationUtility;

import static com.cisco.util.DBConnectionManager.commonProperties;

public class FAQsHeader {
	
	//TC4196 from regression suite
	WebDriver driver;
	ApplicationUtility appUtility;
	
	public FAQsHeader(){
		
	}
	
	public FAQsHeader(ApplicationUtility appUtility){
		driver=appUtility.driver;
		this.appUtility=appUtility;
	}
	
	public void FaqsLink() throws InterruptedException //To Verify FAQs Link in header
	{
		Thread.sleep(5000);
		WebElement faq=driver.findElement(By.xpath("//div[@class='header']//li[1]//div[@class='section linkwithtext']/a"));
		faq.click();
		Thread.sleep(5000);
		String Expurl=commonProperties.getProperty("FAQs");
		String Actualurl=driver.getCurrentUrl();
		if(Expurl.equalsIgnoreCase(Actualurl))
		{
			appUtility.logMessage("Validate FAQ Header Link","Expected URL is "+Expurl,"The Actual url for FAQs link is "+Actualurl,"passed");
		}
		else
		{
			appUtility.logMessage("Validate FAQ Header Link","Expected URL is "+Expurl,"The Actual url for FAQs link is "+Actualurl,"Failed");
		}
		}
		
	}


