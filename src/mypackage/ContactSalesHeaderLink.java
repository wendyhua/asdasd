package com.cisco.commonclasses;

import static com.cisco.util.DBConnectionManager.commonProperties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.cisco.util.ApplicationUtility;

public class ContactSalesHeaderLink {
	
	//TC4198 from regression suite
		WebDriver driver;
		ApplicationUtility appUtility;
		
		public ContactSalesHeaderLink(){
			
		}
		
		public ContactSalesHeaderLink(ApplicationUtility appUtility){
			driver=appUtility.driver;
			this.appUtility=appUtility;
		}
		
		public void ContactSales() throws InterruptedException //To Verify Contact Sales Link in header
		{
			Thread.sleep(5000);
			WebElement contactSales=driver.findElement(By.xpath("//div[@class='header']//div[@class='parbase section linkWithTextBlurb']/a"));
			contactSales.click();
			Thread.sleep(5000);
			String Expurl=commonProperties.getProperty("contactSales");
			String Actualurl=driver.getCurrentUrl();
			if(Expurl.equalsIgnoreCase(Actualurl))
			{
				appUtility.logMessage("Validate Contactsales Header Link","Expected URL is "+Expurl,"The Actual url for Contactsales link is "+Actualurl,"passed");
			}
			else
			{
				appUtility.logMessage("Validate Contactsales Header Link","Expected URL is "+Expurl,"The Actual url for Contactsales link is "+Actualurl,"Failed");
			}
			}
			
		}


