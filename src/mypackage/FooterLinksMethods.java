package com.cisco.commonclasses;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.cisco.util.ApplicationUtility;
import com.cisco.util.WrapperActionTest;

import static com.cisco.util.DBConnectionManager.commonProperties;

//TC4177,TC4178,TC4179,TC4180,TC4181,TC4182,TC4183,TC4184,TC4185,TC4186,TC4187,TC4188,TC4190,TC4191,TC4192,TC4193,TC4189,TC4194 from regression suite


public class FooterLinksMethods {
	
	WebDriver driver;
	ApplicationUtility appUtility;
	WrapperActionTest test = new WrapperActionTest();
	
	public FooterLinksMethods(){
		
	}
	
	public FooterLinksMethods(ApplicationUtility appUtility){
		driver=appUtility.driver;
		this.appUtility=appUtility;
	}
	
	public void webExValidations() throws Exception
	{
		
		test.startBrowser(driver, commonProperties.getProperty("webEx"));
		SignUpFree();		
		driver.navigate().to("https://www.webex.com/");	
		HomeLinks();
		driver.navigate().to("https://www.webex.com/");
		ProductsAndPricing();
		driver.navigate().to("https://www.webex.com/");
		learnLinks();
		driver.navigate().to("https://www.webex.com/");
		aboutUsLinks();
		driver.navigate().to("https://www.webex.com/");
		supportLinks();
		driver.navigate().to("https://www.webex.com/");
		SocialIconLinks();
		driver.navigate().to("https://www.webex.com/");
		footerCopyrightlinks();
		driver.navigate().to("https://www.webex.com/");
		ciscoLogo();
		
	 }
	
	//To verify Sign Up Free link in footer
	
	public void SignUpFree() throws InterruptedException{  
		Thread.sleep(4000);
		Actions ac =new Actions(driver);
	    ac.sendKeys(Keys.END).perform();
	    Thread.sleep(4000);
		WebElement signup=driver.findElement(By.xpath("//div[@class='container']//div[@class='url-call-p']//a"));
		signup.click();
		Thread.sleep(5000);
		String expurl=commonProperties.getProperty("footerSignup");
		String actualurl=driver.getCurrentUrl();
		if(expurl.equalsIgnoreCase(actualurl))
		{
			appUtility.logMessage("Validate Sign Up Free Footer Link","Expected URL for Sign Up Free link is: "+expurl,"The Actual url for Sign Up Free link is "+actualurl,"passed");
		}
		else
		{
			appUtility.logMessage("Validate Sign Up Free Footer Link","Expected URL for Sign Up Free link is: "+expurl,"The Actual url for Sign Up Free link is "+actualurl,"Failed");
		}
		
		}
	
	//To verify the links under Home Section
		
	public void HomeLinks() throws InterruptedException{  
		Thread.sleep(4000);
		Actions ac =new Actions(driver);
	    ac.sendKeys(Keys.END).perform();
		List<WebElement> Homelist=driver.findElements(By.xpath("//div[@class='col-links col-links-home']//ul[@class='f-links-list list-unstyled']//a"));
       
		List<String> expurlList = new ArrayList<String>();
		
		expurlList.add(commonProperties.getProperty("hostMeeting"));
		expurlList.add(commonProperties.getProperty("joinMeeting"));
		expurlList.add(commonProperties.getProperty("mobile"));
		expurlList.add(commonProperties.getProperty("contactSales"));
		expurlList.add(commonProperties.getProperty("contactUs"));
		
		List<String> Linktext = new ArrayList<String>();
		Iterator itr=Homelist.iterator();
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			Linktext.add(element.getText());// link text
			System.out.println(element.getText());
		}
			
			for(int i=0;i<Linktext.size();i++){
								
				WebElement eachlink =driver.findElement(By.xpath("//div[@class='col-links col-links-home']//ul[@class='f-links-list list-unstyled']//a[contains(text(),'"+Linktext.get(i)+"')]"));
				Thread.sleep(2000);
				eachlink.click();
				Thread.sleep(4000);
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
					
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
												
					}
					else
					{
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					
						driver.close();
						Thread.sleep(3000);
						driver.switchTo().window(parentWindow);
						Thread.sleep(3000);
						
			}//if ending	
               else{
					
					String actualUrl = driver.getCurrentUrl();
						
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
						
					}
					else
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			
			}
			
		
	}
	
	//To verify the links under Products & Pricing section in footer
	
	public void ProductsAndPricing() throws InterruptedException{  
		Thread.sleep(4000);
		Actions ac =new Actions(driver);
	    ac.sendKeys(Keys.END).perform();
		List<WebElement> Menulinks=driver.findElements(By.xpath("//div[@class='col-links col-links-products']//ul[@class='f-links-list list-unstyled']//a"));
       
		List<String> expurlList = new ArrayList<String>();
		
		expurlList.add(commonProperties.getProperty("webConference"));
		expurlList.add(commonProperties.getProperty("enterpriseMeeting"));
		expurlList.add(commonProperties.getProperty("videoConferencing"));
		expurlList.add(commonProperties.getProperty("webinarsAndOnlineEvents"));
		expurlList.add(commonProperties.getProperty("elearningAndOnlineTraining"));
		expurlList.add(commonProperties.getProperty("remoteSupport"));
		expurlList.add(commonProperties.getProperty("ciscoSpark"));
		expurlList.add(commonProperties.getProperty("enterprise"));
		
		List<String> Linktext = new ArrayList<String>();
		Iterator itr=Menulinks.iterator();
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			Linktext.add(element.getText());// link text
			System.out.println(element.getText());
		}
			
			for(int i=0;i<Linktext.size();i++){
								
				WebElement eachlink =driver.findElement(By.xpath("//div[@class='col-links col-links-products']//ul[@class='f-links-list list-unstyled']//a[contains(text(),'"+Linktext.get(i)+"')]"));
				Thread.sleep(2000);
				eachlink.click();
				Thread.sleep(5000);
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
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
												
					}
					else
					{
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					
						driver.close();
						Thread.sleep(3000);
						driver.switchTo().window(parentWindow);
						Thread.sleep(3000);
						
			}//if ending	
               else{
					
					String actualUrl = driver.getCurrentUrl();
					
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
						
					}
					else
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			
			}
			
		
	}
	
	//To verify the links under Learn section in footer
	
		public void learnLinks() throws InterruptedException{  
			Thread.sleep(4000);
			Actions ac =new Actions(driver);
		    ac.sendKeys(Keys.END).perform();
			List<WebElement> Menulinks=driver.findElements(By.xpath("//div[@class='col-links col-links-learn']//ul[@class='f-links-list list-unstyled']//a"));
	       
			List<String> expurlList = new ArrayList<String>();
			
			expurlList.add(commonProperties.getProperty("FAQs"));
			expurlList.add(commonProperties.getProperty("howToIndex"));
			expurlList.add(commonProperties.getProperty("gettingStarted"));
			expurlList.add(commonProperties.getProperty("webinarsOndemand"));
			expurlList.add(commonProperties.getProperty("testMeeting"));
						
			List<String> Linktext = new ArrayList<String>();
			Iterator itr=Menulinks.iterator();
			while(itr.hasNext()){
				WebElement element=(WebElement)itr.next();
				Linktext.add(element.getText());// link text
				System.out.println(element.getText());
			}
				
				for(int i=0;i<Linktext.size();i++){
									
					WebElement eachlink =driver.findElement(By.xpath("//div[@class='col-links col-links-learn']//ul[@class='f-links-list list-unstyled']//a[contains(text(),'"+Linktext.get(i)+"')]"));
					Thread.sleep(2000);
					eachlink.click();
					Thread.sleep(5000);
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
						if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
						{
							
							appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
													
						}
						else
						{
							appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
						}
						
							driver.close();
							Thread.sleep(3000);
							driver.switchTo().window(parentWindow);
							Thread.sleep(3000);
							
				}//if ending	
	               else{
						
						String actualUrl = driver.getCurrentUrl();
									
						if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
						{
							
							appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
							
						}
						else
						{
							
							appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
						}
						Thread.sleep(2000);
						driver.navigate().back();
						Thread.sleep(2000);
					}

				
				}
				
			
		}
		
		//To verify the links under About Us section in footer
		
			public void aboutUsLinks() throws InterruptedException{  
				Thread.sleep(4000);
				Actions ac =new Actions(driver);
			    ac.sendKeys(Keys.END).perform();
				List<WebElement> Menulinks=driver.findElements(By.xpath("//div[@class='col-links col-links-about']//ul[@class='f-links-list list-unstyled']//a"));
		       
				List<String> expurlList = new ArrayList<String>();
				
				expurlList.add(commonProperties.getProperty("overview"));
				expurlList.add(commonProperties.getProperty("webConferencingNews"));
											
				List<String> Linktext = new ArrayList<String>();
				Iterator itr=Menulinks.iterator();
				while(itr.hasNext()){
					WebElement element=(WebElement)itr.next();
					Linktext.add(element.getText());// link text
					System.out.println(element.getText());
				}
					
					for(int i=0;i<Linktext.size();i++){
										
						WebElement eachlink =driver.findElement(By.xpath("//div[@class='col-links col-links-about']//ul[@class='f-links-list list-unstyled']//a[contains(text(),'"+Linktext.get(i)+"')]"));
						Thread.sleep(2000);
						eachlink.click();
						Thread.sleep(5000);
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
							
							if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
														
							}
							else
							{
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
							}
							
								driver.close();
								Thread.sleep(3000);
								driver.switchTo().window(parentWindow);
								Thread.sleep(3000);
								
					}//if ending	
		               else{
							
							String actualUrl = driver.getCurrentUrl();
							
							if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
								
							}
							else
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
							}
							Thread.sleep(2000);
							driver.navigate().back();
							Thread.sleep(2000);
						}

					
					}
					
				
			}
			
	//To verify the links under Support section in footer
			
			public void supportLinks() throws InterruptedException{  
				Thread.sleep(4000);
				Actions ac =new Actions(driver);
			    ac.sendKeys(Keys.END).perform();
				List<WebElement> Menulinks=driver.findElements(By.xpath("//div[@class='col-links col-links-support']//ul[@class='f-links-list list-unstyled']//a"));
		       
				List<String> expurlList = new ArrayList<String>();
				
				expurlList.add(commonProperties.getProperty("support"));
				expurlList.add(commonProperties.getProperty("globalLogin"));
				expurlList.add(commonProperties.getProperty("docs"));
				expurlList.add(commonProperties.getProperty("helpCentral"));
															
				List<String> Linktext = new ArrayList<String>();
				Iterator itr=Menulinks.iterator();
				while(itr.hasNext()){
					WebElement element=(WebElement)itr.next();
					Linktext.add(element.getText());// link text
					System.out.println(element.getText());
				}
					
					for(int i=0;i<Linktext.size();i++){
										
						WebElement eachlink =driver.findElement(By.xpath("//div[@class='col-links col-links-support']//ul[@class='f-links-list list-unstyled']//a[contains(text(),'"+Linktext.get(i)+"')]"));
						Thread.sleep(2000);
						eachlink.click();
						Thread.sleep(5000);
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
							
							if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
														
							}
							else
							{
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
							}
							
								driver.close();
								Thread.sleep(3000);
								driver.switchTo().window(parentWindow);
								Thread.sleep(3000);
								
					}//if ending	
		               else{
							
							String actualUrl = driver.getCurrentUrl();
							
							if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
								
							}
							else
							{
								
								appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
							}
							Thread.sleep(2000);
							driver.navigate().back();
							Thread.sleep(2000);
						}

					
					}
					
				
			}
	//To verify the Social Icon links under footer

	public void SocialIconLinks() throws InterruptedException{  
		Thread.sleep(4000);
	    Actions ac =new Actions(driver);
	    ac.sendKeys(Keys.END).perform();
		Thread.sleep(4000);
		List<WebElement> Iconslist=driver.findElements(By.xpath("//div[@class='social-box clearfix']//ul[@class='clearfix list-unstyled social-list']//a"));
        List<String> expurlList = new ArrayList<String>();// 
		
		expurlList.add(commonProperties.getProperty("twitter"));
		expurlList.add(commonProperties.getProperty("linkedid"));
		expurlList.add(commonProperties.getProperty("facebook"));
		expurlList.add(commonProperties.getProperty("youtube"));
		expurlList.add(commonProperties.getProperty("blog"));
		
		List<String> Linktext = new ArrayList<String>();
		Iterator itr=Iconslist.iterator();
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			Linktext.add(element.getAttribute("class"));
			System.out.println(element.getAttribute("class"));

		}
					
			for(int i=0;i<Linktext.size();i++){
								
				WebElement eachlink =driver.findElement(By.xpath("//div[@class='social-box clearfix']//ul[@class='clearfix list-unstyled social-list']//a[@class='"+Linktext.get(i)+"']"));
				Thread.sleep(4000);
				eachlink.click();
				Thread.sleep(5000);
				String parentWindow=null;
				if(driver.getWindowHandles().size()>1)
				{
					parentWindow=driver.getWindowHandle();
					for(String handle: driver.getWindowHandles())
					{
						driver.switchTo().window(handle);
						Thread.sleep(2000);
					}
					String actualUrl = driver.getCurrentUrl();
					
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Social Icon links under footer", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL "+actualUrl, "Passed");
												
					}
					else
					{
						appUtility.logMessage("Validate Social Icon links under footer", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL "+actualUrl, "Failed");
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
						
						appUtility.logMessage("Validate Social Icon links under footer", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL "+actualUrl, "Passed");
						
					}
					else
					{
						
						appUtility.logMessage("Validate Social Icon links under footer", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL "+actualUrl, "Failed");
					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			
			}
			
		}
	
	//To verify the links under Footer Copyright links
	
	public void footerCopyrightlinks() throws InterruptedException{  
		Thread.sleep(4000);
		Actions ac =new Actions(driver);
	    ac.sendKeys(Keys.END).perform();
		List<WebElement> Menulinks=driver.findElements(By.xpath("//div[@class='container copyright-box']//div[@class='footer-copyright-con']//a"));
       
		List<String> expurlList = new ArrayList<String>();
		
		expurlList.add(commonProperties.getProperty("service"));
		expurlList.add(commonProperties.getProperty("privacy"));
		expurlList.add(commonProperties.getProperty("cookies"));
		expurlList.add(commonProperties.getProperty("contactSales"));
		expurlList.add(commonProperties.getProperty("trademark"));
		expurlList.add(commonProperties.getProperty("sitemap"));
													
		List<String> Linktext = new ArrayList<String>();
		Iterator itr=Menulinks.iterator();
		while(itr.hasNext()){
			WebElement element=(WebElement)itr.next();
			Linktext.add(element.getText());// link text
			System.out.println(element.getText());
		}
			
			for(int i=0;i<Linktext.size();i++){
								
				WebElement eachlink =driver.findElement(By.xpath("//div[@class='container copyright-box']//div[@class='footer-copyright-con']//a[contains(text(),'"+Linktext.get(i)+"')]"));
				Thread.sleep(2000);
				eachlink.click();
				Thread.sleep(5000);
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
					
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
												
					}
					else
					{
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					
						driver.close();
						Thread.sleep(3000);
						driver.switchTo().window(parentWindow);
						Thread.sleep(3000);
						
			}//if ending	
               else{
					
					String actualUrl = driver.getCurrentUrl();
					
					if(actualUrl.equalsIgnoreCase(expurlList.get(i)))
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Passed");
						
					}
					else
					{
						
						appUtility.logMessage("Validate Footer Links Under Home Section", "Expected URL for "+Linktext.get(i)+" link is: "+expurlList.get(i), "Actual URL is: "+actualUrl, "Failed");
					}
					Thread.sleep(2000);
					driver.navigate().back();
					Thread.sleep(2000);
				}

			
			}
			
		
	}
	
	//To verify Cisco Logo in footer
	
		public void ciscoLogo() throws InterruptedException{  
			Thread.sleep(4000);
			Actions ac =new Actions(driver);
		    ac.sendKeys(Keys.END).perform();
		    Thread.sleep(4000);
			WebElement logo=driver.findElement(By.xpath("//div[@class='footer-copyright']//div[@class='col-md-12']//a[@class='logo-footer']"));
			logo.click();
			Thread.sleep(5000);
			String expurl=commonProperties.getProperty("logo");
			String parentWindow=null;
			
			if(driver.getWindowHandles().size()>1)
			{
				parentWindow=driver.getWindowHandle();
				for(String handle: driver.getWindowHandles())
				{
					Thread.sleep(3000);
					driver.switchTo().window(handle);
					Thread.sleep(2000);
				}
				String actualUrl = driver.getCurrentUrl();
				
				if(actualUrl.equalsIgnoreCase(expurl))
				{
					
					appUtility.logMessage("Validate Ciscologo link in footer","Expected URL for Ciscologo link link is: "+expurl,"The Actual url for Ciscologo link is "+actualUrl,"passed");
											
				}
				else
				{
					appUtility.logMessage("Validate Ciscologo link in footer","Expected URL for Ciscologo link link is: "+expurl,"The Actual url for Ciscologo link is "+actualUrl,"Failed");
				}
				
					driver.close();
					Thread.sleep(3000);
					driver.switchTo().window(parentWindow);
					Thread.sleep(3000);
					
		}//if ending	
           else{
				
				String actualUrl = driver.getCurrentUrl();
				
				if(actualUrl.equalsIgnoreCase(expurl))
				{
					
					appUtility.logMessage("Validate Ciscologo link in footer","Expected URL for Ciscologo link link is: "+expurl,"The Actual url for Ciscologo link is "+actualUrl,"passed");
					
				}
				else
				{
					
					appUtility.logMessage("Validate Ciscologo link in footer","Expected URL for Ciscologo link link is: "+expurl,"The Actual url for Ciscologo link is "+actualUrl,"Failed");
				}
				Thread.sleep(2000);
				driver.navigate().back();
				Thread.sleep(2000);
			}


}
}

