package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepagetc {
//	WebDriver driver;
	public static WebElement element = null;

	public static WebElement ciscologob(WebDriver driver) {
		element = driver.findElement(By
				.xpath("html/body/div[4]/div[2]/div[4]/div/div/div/div/a"));
		return element;
	}

	public static WebElement Aboutus(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("/html/body/div[2]/div/div/div[1]/section/div/div/div[2]/nav/ul/li[3]/div/a"));
		return element;
	}

	public static WebElement ContactSales(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("/html/body/div[2]/div/section/div/div/div[1]/ul/div/li[4]/div/a"));
		return element;

	}

	public static WebElement ContactSalesFooter(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("/html/body/div[4]/div[2]/div[4]/div/div/div/div/div/p[3]/a[1]"));
		return element; 
	}

	public static WebElement CookiePolicy(WebDriver driver) {
		element = driver.findElement(By.linkText("Cookie Policy"));
		return element;
	}

	// about us xpath
	public static WebElement Countrydropdownselector(WebDriver driver) {
		element = driver
				.findElement(By
						.xpath("/html/body/div[2]/div/section/div/div/div[1]/ul/div/div/li/a"));
		return element;
	}
	
	// sin in xpath
	public static WebElement signinselector(WebDriver driver) {
		element = driver.findElement(By.linkText("Sign In"));
		return element;
				
	}

// CiscoSpark in footer

public static WebElement ciscosparkfooter(WebDriver driver) {
	element = driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div/div/div/div[2]/div[2]/ul/li[7]/a"));
	return element;
			
}
}
