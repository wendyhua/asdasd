package  com.cisco.commonclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.cisco.util.ApplicationUtility;
import static com.cisco.util.DBConnectionManager.commonProperties;

public class MegaMenu1Imp {
	
	//TC4174 from regression suite
	WebDriver driver;
	
	public void megamenu11(ApplicationUtility appUtility) throws InterruptedException{
		driver=appUtility.driver;
		Thread.sleep(5000);
		try{	
			Thread.sleep(5000);
		      WebElement ele=driver.findElement(By.xpath("//div[@class='megamenu']/a"));
				String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover', true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
				((JavascriptExecutor) driver).executeScript(mouseOverScript,ele);
				
				List<String> expurlList = new ArrayList<String>();
		expurlList.add(commonProperties.getProperty("webConference"));
		expurlList.add(commonProperties.getProperty("pricing"));
		expurlList.add(commonProperties.getProperty("enterpriseMeeting"));
		expurlList.add(commonProperties.getProperty("webinarsAndOnlineEvents"));
		expurlList.add(commonProperties.getProperty("elearningAndOnlineTraining"));
		expurlList.add(commonProperties.getProperty("remoteSupport"));
		expurlList.add(commonProperties.getProperty("ciscoSpark"));
		expurlList.add(commonProperties.getProperty("webCoferencingMobile"));
		expurlList.add(commonProperties.getProperty("contactSales"));
		
		
		List<WebElement> Megamenuslist = driver.findElements(By.xpath("//div[@class='megamenu']//ul//a"));
		Iterator itr=Megamenuslist.iterator();
		List<String> Megamenus = new ArrayList<String>();
		
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			String temp=element.getText();
			if(temp.startsWith(" ")){
				temp=temp.replaceFirst(" ", "");
			}
			if(temp.startsWith(" ")){
				temp=temp.replaceFirst(" ","");
			}
			Megamenus.add(temp);// link text
			System.out.println(temp);
		}
		
		
		
		for(int i=0;i<Megamenus.size();i++){
			ele=driver.findElement(By.xpath("//div[@class='megamenu']/a"));
			((JavascriptExecutor) driver).executeScript(mouseOverScript,ele);
			Thread.sleep(5000);
			//System.out.println("Element::"+"//div[@class='megamenu']//ul//a[contains(text(),'"+Megamenus.get(i)+"')]");
			driver.findElement(By.xpath("//div[@class='megamenu']//ul//a[contains(text(),'"+Megamenus.get(i)+"')]")).click();
			Thread.sleep(5000);
			String parentWindow=null;
			if(driver.getWindowHandles().size()>1)
			{
			parentWindow=driver.getWindowHandle();
			for(String handle: driver.getWindowHandles())
				{
					driver.switchTo().window(handle);
					Thread.sleep(3000);
				}
				String actualUrl = driver.getCurrentUrl();
				if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
				{
					
					appUtility.logMessage("Product & Pricing MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under P&P MegaMenu1 is "+driver.getCurrentUrl(),"passed");
											
				}
				else
				{
					appUtility.logMessage("Product & Pricing MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under P&P MegaMenu1 is "+driver.getCurrentUrl(),"Failed");
				}
				
					driver.close();
					Thread.sleep(5000);
					driver.switchTo().window(parentWindow);
					Thread.sleep(3000);
					
		}//if ending	
           else{
				
				String actualUrl = driver.getCurrentUrl();
								
				if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
				{
					
					appUtility.logMessage("Product & Pricing MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under P&P MegaMenu1 is "+driver.getCurrentUrl(),"passed");
					
				}
				else
				{
					
					appUtility.logMessage("Product & Pricing MegaMenu","Expected URL is "+expurlList.get(i),"The url for "+Megamenus.get(i).toString()+" link under P&P MegaMenu1 is "+driver.getCurrentUrl(),"Failed");
				}
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
			}

		
		}
		
			
			
		}
		catch(Exception ne){
			ne.printStackTrace();
		}
		
	}
}
