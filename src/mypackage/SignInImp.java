package com.cisco.commonclasses;

import static com.cisco.util.DBConnectionManager.commonProperties;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cisco.util.ApplicationUtility;

public class SignInImp {
	
	WebDriver driver;
	
	public void signinFunctionality(ApplicationUtility appUtility) throws InterruptedException
	{
		try
		{
		driver=appUtility.driver;
		Thread.sleep(8000);
		WebElement signin1 = driver.findElement(By.xpath("//div[@class='signin section']/a[@class ='tool-drop-toggle']"));
		signin1.click();
		Thread.sleep(5000);
        List<String> expurlList = new ArrayList<String>();
		
		expurlList.add(commonProperties.getProperty("webExProducts"));
		expurlList.add(commonProperties.getProperty("globalLogin"));
		expurlList.add(commonProperties.getProperty("invoiceLogin"));
		expurlList.add(commonProperties.getProperty("spark"));
	
		List<String> list1 = new ArrayList<String>();
				
		List <WebElement> signinList = driver.findElements(By.xpath("(//div[@class='signin section']/dl/dt/a)"));
        Iterator<WebElement> itr=signinList.iterator();
		
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			list1.add(element.getText());// link text
			System.out.println(element.getText());
		}

				
					
		for( int i=0;i<signinList.size();i++)
		{
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[@class='signin section']/dl/dt/a[text()='"+list1.get(i)+"']")).click();
			Thread.sleep(8000);
			String parentWindow=null;
						
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
				if(actualUrl.contains(expurlList.get(i)))
				{
					
					appUtility.logMessage("Validate Sign In drop down", "Expected URL for "+list1.get(i)+" link is "+expurlList.get(i), "Actual URL is "+actualUrl, "Passed");
											
				}
				else
				{
					appUtility.logMessage("Validate Sign In drop down", "Expected URL for "+list1.get(i)+" link is "+expurlList.get(i), "Actual URL is "+actualUrl, "Failed");
				}
				
				    Thread.sleep(2000);
					driver.close();
					Thread.sleep(3000);
					driver.switchTo().window(parentWindow);
					Thread.sleep(3000);
					
		}//if ending		

			else{
				
				String actualUrl = driver.getCurrentUrl();
				
				if(actualUrl.contains(expurlList.get(i)))
				{
					
					appUtility.logMessage("Validate Sign In drop down", "Expected URL for "+list1.get(i)+" link is "+expurlList.get(i), "Actual URL is "+actualUrl, "Passed");
					
				}
				else
				{
					
					appUtility.logMessage("Validate Sign In drop down", "Expected URL for "+list1.get(i)+" link is "+expurlList.get(i), "Actual URL is "+actualUrl, "Failed");
				}
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(8000);
			}
			driver.findElement(By.xpath("//div[@class='signin section']/a[@class ='tool-drop-toggle']")).click();

		}//for ending
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
			

}
