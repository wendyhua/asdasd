package com.cisco.commonclasses;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cisco.util.AppTestDTO;
import com.cisco.util.ApplicationUtility;
import com.cisco.util.LocalDriverFactory;
import com.cisco.util.Report;

public class HostAndJoinFunctionalityImp {
	
	
	//TC4229,TC4230 from regression suite
	
	WebDriver driver;
	
	
		public void verifyTitle(ApplicationUtility appUtility) //To Verify home page title
		{
			driver=appUtility.driver;
			String title = driver.getTitle();
			System.out.println("Title of the home page :"+title);
			String Verifytitle = "Cisco WebEx — Online Meetings and Video Conferencing";
			if(title.equalsIgnoreCase(Verifytitle))
			{
				//appUtility.logMessage("step Description","Expected Message", "actual Message", "Failed");
				appUtility.logMessage("Title Verification","Expected Page title is:"+Verifytitle, "Actual Page title is:"+title, "Passed");
			}
			else{
				appUtility.logMessage("Title Verification","Expected Page title is:"+Verifytitle, "Actual Page title is:"+title, "Failed");
			}
		}
		public void verifyHostButton(ApplicationUtility appUtility) throws InterruptedException //Hitting host button 
		{
			driver=appUtility.driver;
			String path = ".//*[@id='header']/div/div/div[1]/section/div/div/div[3]/div/ul/li[1]/a";
			WebElement host = driver.findElement(By.xpath(path));
			Thread.sleep(3000);
			host.click();
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			String MainWindow = driver.getWindowHandle();
			String Childwindow = MainWindow;

			for (String Handle : driver.getWindowHandles())
			{
				if (!Childwindow.equals(Handle))
				{
					Childwindow = Handle;
					driver.switchTo().window(Childwindow);
					//		            WebElement next = driver.findElement(By.xpath(".//*[@id='login-btn-next']"));
					//			        next.click();

					//String windowURL = driver.getCurrentUrl();
					String windowTitle = driver.getTitle();
					System.out.println(driver.getTitle());
					System.out.println("Sign In page Title is : "+windowTitle);
					//String CompareURL = "https://signin.webex.com/collabs/auth?service=it&from=hostmeeting&TrackID=&hbxref=http%3A%2F%2Fwww.webex.com%2F&goid=host-meeting";
					String compareTitle = "Sign in to your WebEx account.";
					if(windowTitle.equalsIgnoreCase(compareTitle)){
						//System.out.println("Test case passed for Host functionality");
						appUtility.logMessage("Host button functionality","Expected Host button Title is:"+compareTitle, "Actual Host button Title is:"+windowTitle, "Passed");
						
					}
					else {
						//System.out.println("Test case failed for Host functionality");
						appUtility.logMessage("Host button functionality","Expected Host button Title is:"+compareTitle, "Actual Host button Title is:"+windowTitle, "failed");
					}
				}

			}
			driver.close();
			driver.switchTo().window(MainWindow);
			//System.out.println(driver.findElement(By.xpath(".//*[@id='header_rwd']/div[2]/div/div[2]/a[2]")).getText());
		}

		
		
		
		
		public void verifyJoinButton(ApplicationUtility appUtility) throws InterruptedException //Hitting Join button 
		{
			
			Thread.sleep(5000);
			driver=appUtility.driver;
			String path = ".//*[@id='header']/div/div/div[1]/section/div/div/div[3]/div/ul/li[2]/a";

			WebElement join = driver.findElement(By.xpath(path));
			join.click();
			Thread.sleep(5000);
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

			String MainWindow = driver.getWindowHandle();
			String Childwindow = MainWindow;

			for (String Handle : driver.getWindowHandles())
			{
				if (!Childwindow.equals(Handle))
				{
					Childwindow = Handle;
					driver.switchTo().window(Childwindow);
					//		            WebElement next = driver.findElement(By.xpath(".//*[@id='login-btn-next']"));
					//			        next.click();

					//String windowURL = driver.getCurrentUrl();
					
					String windowTitle = driver.getTitle();
					//String windowTitle = driver.getCurrentUrl();
					
					//System.out.println("Join page title is "+driver.getTitle());
					System.out.println("Join In page Title is : "+windowTitle);

					String compareTitle = "Join by Number - Cisco WebEx Meetings";
					//String compareTitle = "Join by Number - Cisco WebEx Meetings";
					
					if(windowTitle.equalsIgnoreCase(compareTitle)){
						//System.out.println("Test case passed for Join functionality");
						appUtility.logMessage("Join button functionality","Expected Join button Title is:"+compareTitle, "Actual Join button Title is:"+windowTitle, "passed");
					}
					else {
						//System.out.println("Test case failed for Join functionality");
						appUtility.logMessage("join button functionality","Expected Join button Title is:"+compareTitle, "Actual Join button Title is:"+windowTitle, "failed");
					}
				
				}
				
			}
			driver.close();
			Thread.sleep(5000);
			driver.switchTo().window(MainWindow);
		}

		
			/*public static void main(String[] args) {
			WebDriver driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get("http://www.webex.com/");
			HostButtonTesting obj = new HostButtonTesting();
			obj.verifyTitle(driver);
			obj.verifyHostButton(driver);
			obj.verifyJoinButton(driver);
			
//			ArrayList myArray = new ArrayList<String>();
//			myArray.add("verifyHostButton");
//			myArray.add("verifyJoinButton");
//			System.out.println(myArray);
//			for(int i=0;i<myArray.size();i++){
//				if(myArray.get(i).toString().equals("verifyHostButton")){
//					obj.verifyHostButton(driver);
//				}
//				else if(myArray.get(i).toString().equals("verifyJoinButton")){
//					obj.verifyHostButton(driver);
//				}
//				else{
//					System.out.println("No method exists");
//				}
			

			}*/
			


}
