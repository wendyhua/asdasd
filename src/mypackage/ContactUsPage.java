package com.cisco.commonclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cisco.util.ApplicationUtility;

import java.util.ArrayList;
import java.util.List;


public class ContactUsPage {
	
	static WebDriver driver;

	
	//TC4263 from regression suite
	
	
	public void contactUsPageLinks(ApplicationUtility appUtility){
		driver=appUtility.driver;
				
		try{
			
			//Expected URLs list for the contact us page
			List<String> expUrlsList = new ArrayList<String>();
			expUrlsList.add("https://support.webex.com/MyAccountWeb/supporthome.do");
			expUrlsList.add("https://help.webex.com/welcome");
			expUrlsList.add("https://support.webex.com/MyAccountWeb/globalLogin.do");
			expUrlsList.add("https://www.webex.com/support/getting-started.html");
			expUrlsList.add("https://www.webex.com/faqs.html");
			expUrlsList.add("https://www.webex.com/how-to/index.html");
			expUrlsList.add("https://www.webex.com/webinars/listing/type/ondemand");
			
		
			List<String> linkNames = new ArrayList<String>();
			linkNames.add("resources");
			linkNames.add("help.webex.com");
			linkNames.add("Sign in");
			linkNames.add("Get started");
			linkNames.add("FAQs");
			linkNames.add("how-to videos");
			linkNames.add("webinars");

					
			List<WebElement> actURLsPath = driver.findElements(By.xpath("//div[@class='container']//p/span[@class='cu-copy']/a"));
			System.out.println(actURLsPath.size());

			for( int i=0;i<actURLsPath.size();i++)
			{

				WebElement eachlink =driver.findElement(By.xpath("//div[@class='container']//p/span[@class='cu-copy']/a[text()='"+linkNames.get(i)+"']"));
				
				Thread.sleep(2000);
				eachlink.click();
				Thread.sleep(2000);
				String parentWindow=null;
				
				Thread.sleep(2000);

				if(driver.getWindowHandles().size()>1)
				{
					parentWindow=driver.getWindowHandle();
					for(String handle: driver.getWindowHandles())
					{
						Thread.sleep(2000);
						driver.switchTo().window(handle);
						Thread.sleep(2000);
					}
					String actualUrl = driver.getCurrentUrl();
					System.out.println(actualUrl);
					if(actualUrl.equalsIgnoreCase(expUrlsList.get(i)))
					{
						
						appUtility.logMessage("ContactUsPage", "Expected "+linkNames.get(i)+" link URL "+expUrlsList.get(i), "Actual URL "+actualUrl, "Passed");
												
					}
					else
					{
						System.out.println("Test case is failed ");
					}
					
					    Thread.sleep(2000);
						driver.close();
						Thread.sleep(3000);
						driver.switchTo().window(parentWindow);
						Thread.sleep(3000);
						
			}//if ending		

				else{
					
					String actualUrl = driver.getCurrentUrl();
					
					System.out.println(actualUrl);	
					if(actualUrl.equalsIgnoreCase(expUrlsList.get(i)))
					{
						
						appUtility.logMessage("ContactUsPage", "Expected "+linkNames.get(i)+" link URL "+expUrlsList.get(i), "Actual URL "+actualUrl, "Passed");
						
					}
					else
					{
						
						appUtility.logMessage("ContactUsPage", "Should Navigate to all links successfully", "Not able to navigate", "Failed");
					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			}//for ending
		}//try ending
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

		
} //class closing
