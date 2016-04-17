package com.cisco.commonclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import com.cisco.util.ApplicationUtility;

import static com.cisco.util.DBConnectionManager.commonProperties;

public class MegaMenu2Imp {

WebDriver driver;
	//TC4224 from regression suite
	public void megamenu22(ApplicationUtility appUtility){
		driver=appUtility.driver;
		
		try{	
			
			Thread.sleep(8000);
			List<WebElement> Megamenuslist=null;
					
		WebElement mainMenu=driver.findElement(By.xpath("//div[@class='megamenu learn']//a[@class='dropdown-toggle webex-nav-title']"));
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
		((JavascriptExecutor) driver).executeScript(mouseOverScript,
				mainMenu);
				
		Megamenuslist=driver.findElements(By.xpath("//div[@class='megamenu learn']//ul/li/a"));
        List<String> expurlList = new ArrayList<String>();
		
		expurlList.add(commonProperties.getProperty("FAQs"));
		expurlList.add(commonProperties.getProperty("howToIndex"));
		expurlList.add(commonProperties.getProperty("gettingStarted"));
		expurlList.add(commonProperties.getProperty("webinarsOndemand"));
		
		List<String> Megamenus = new ArrayList<String>();
		
		Iterator itr=Megamenuslist.iterator();
		
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			Megamenus.add(element.getText());// link text
			System.out.println(element.getText());
		}
		
					
		for(int i=0;i<Megamenus.size();i++){
			
			mainMenu=driver.findElement(By.xpath("//div[@class='megamenu learn']//a[@class='dropdown-toggle webex-nav-title']"));
			((JavascriptExecutor) driver).executeScript(mouseOverScript,mainMenu);
			Thread.sleep(5000);
			String parentWindow=driver.getWindowHandle();
			driver.findElement(By.xpath("//div[@class='megamenu learn']//ul/li//a[text()='"+Megamenus.get(i)+"']")).click();
			Thread.sleep(8000);
			
						
			if(driver.getWindowHandles().size()>1)
			{
				for(String handle: driver.getWindowHandles()){
					driver.switchTo().window(handle);
									                         }
				
				if(expurlList.get(i).equalsIgnoreCase(driver.getCurrentUrl())){
					
					appUtility.logMessage("Learn MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under Learn MegaMenu2 is "+driver.getCurrentUrl(),"passed");
					
				                                                               }
					
				driver.close();
				Thread.sleep(8000);
				driver.switchTo().window(parentWindow);
								
			} // if loop ending
			
				
			else if(expurlList.get(i).equalsIgnoreCase(driver.getCurrentUrl()))
			{
					
					appUtility.logMessage("Learn MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under Learn MegaMenu2 is "+driver.getCurrentUrl(),"passed");
									                                               
		    }
			
			else{
				
				appUtility.logMessage("Learn MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under Learn MegaMenu2 is "+driver.getCurrentUrl(),"Failed");
			    Thread.sleep(4000);
			
		         }///
			
			
			
			driver.navigate().to("http://www.webex.com/");
			Thread.sleep(5000);
						
		} // for loop ending
		}
		catch(Exception e){
			e.printStackTrace();
		}
}
	
	
}
