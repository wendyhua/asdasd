package mypackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.ListIterator;
import Pageobjects.Homepagetc;
//check sign in dropdown menu in header
public class SocialMedia {
	public void verifySocialMeida(){
		LinkedList<String> socialicon = new LinkedList<String>();
		ListIterator<String> socialiconir = null;
		socialicon.add("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[1]/a");
		socialicon.add("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[2]/a");
		socialicon.add("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[3]/a");
		socialicon.add("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[4]/a");
		socialicon.add("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[5]/a");
		socialiconir=socialicon.listIterator();
		
		LinkedList<String> iconlink = new LinkedList<String>();
		ListIterator<String> iconlinkir = null;
		iconlink.add("http://twitter.com/webex");
		iconlink.add("http://www.linkedin.com/company/webex");
		iconlink.add("http://www.facebook.com/webex");
		iconlink.add("https://www.youtube.com/c/webex");
		iconlink.add("http://blog.webex.com/");
		iconlinkir=iconlink.listIterator();
		
		
		while (socialicon.hasNext()) {
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.webex.com/");
			//Homepagetc.signinselector(driver).click();
			//Actions action = new Actions(driver);
			//action.moveToElement(Homepagetc.signinselector(driver)).build().perform();
			String socialpath = socialicon.next();
			driver.findElement(By.xpath(socialpath).click();
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase(iconlinkir.next())){
				System.out.println(socialiconir+" Social icon link is correct");}
			else {
				System.out.println(socialiconir+" Socail icon is incorrect, the real one is"+url);
				}
			driver.close();
		}
			
		}
	
	}

