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
public class SignIn {
	public void verifysignin(){
		LinkedList<String> productstype = new LinkedList<String>();
		ListIterator<String> productstypeir = null;
		productstype.add("WebEx Products");
		productstype.add("Account Management");
		productstype.add("Billing Support");
		productstype.add("Cisco Spark");
		productstypeir=productstype.listIterator();
		
		LinkedList<String> productslink = new LinkedList<String>();
		ListIterator<String> productslinkir = null;
		productslink.add("https://signin.webex.com/collabs/auth");
		productslink.add("https://support.webex.com/MyAccountWeb/hostLogin.do");
		productslink.add("https://support.webex.com/MyAccountWeb/invoiceLogin.do");
		productslink.add("https://web.ciscospark.com/#/signin");
		productslinkir=productslink.listIterator();
		
		while (productslinkir.hasNext()) {
			WebDriver driver = new FirefoxDriver();
			driver.get("https://www.webex.com/");
			Homepagetc.signinselector(driver).click();
			Actions action = new Actions(driver);
			action.moveToElement(Homepagetc.signinselector(driver)).build().perform();
			driver.findElement(By.partialLinkText(productstypeir.next())).click();
			String url=driver.getCurrentUrl();
			if(url.equalsIgnoreCase(productslinkir.next())){
				System.out.println(productstypeir+" Sign in link is correct");}
			else {
				System.out.println(productstypeir+" Sign in link is incorrect, the real one is"+url);
				}
			driver.close();
		}
			
		}
	
	}

