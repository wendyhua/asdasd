package mypackage;

/*TC4195*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.ListIterator;
import Pageobjects.Homepagetc;

@SuppressWarnings("unchecked")
public class Countrydropdownselector {
	@Test
	public void VerifyCountrydropdownselector() {

//		@SuppressWarnings("rawtypes")
		LinkedList<String> country = new LinkedList<String>();
		ListIterator<String> countryir = null;
		country.add("Australia (English)");
		country.add("Canada (English)");
		country.add("Brazil (Português)");
		country.add("Canada (Français)");
		country.add("China (???)");
		country.add("France (Français)");
		country.add("Germany (Deutsch)");
		country.add("Hong Kong (????)");
		country.add("India (English)");
		country.add("Italy (Italiano)");
		country.add("Japan (???)");
		country.add("South Korea (???)");
		country.add("Latin America (Español)");
		country.add("Spain (Español)");
		country.add("UK (English)");
		countryir = country.listIterator();

		@SuppressWarnings("rawtypes")
		LinkedList countryurl = new LinkedList();
		ListIterator<String> countryurlir = null;
		countryurl.add("https://www.webex.com.gr/");
		countryurl.add("https://www.webex.ca/en/");
		countryurl.add("http://www.webex.com.br/");
		countryurl.add("https://www.webex.ca/fr/");
		countryurl.add("http://www.webex.com.cn/");
		countryurl.add("https://www.webex.fr/");
		countryurl.add("http://www.webex.de/");
		countryurl.add("http://www.webex.com.hk/");
		countryurl.add("https://www.webex.co.in/");
		countryurl.add("http://www.webex.co.it/");
		countryurl.add("http://www.webex.co.jp/");
		countryurl.add("http://www.webex.co.kr/");
		countryurl.add("http://www.webex.com.mx/");
		countryurl.add("http://www.webex.es/");
		countryurl.add("https://www.webex.co.uk/");
		countryurlir = countryurl.listIterator();
		
		while (countryir.hasNext()) {
			WebDriver driver = new FirefoxDriver();
			driver.get("http://webex.com");
			Homepagetc.Countrydropdownselector(driver).click();
			
			Actions action = new Actions(driver);
			action.moveToElement(Homepagetc.Countrydropdownselector(driver))
					.build().perform();
			
			driver.findElement(By.partialLinkText(countryir.next())).click();
			String url = driver.getCurrentUrl();
			if (url.equalsIgnoreCase((countryurlir.next()))) {
				System.out.println("Navigating to correct url");
			} else {
				System.out.println("is not getting navigated to correct url");
			}
			driver.close();
		}
	}
}
