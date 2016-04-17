import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class CheckLinkofContactsales {
/*check link for FAQ in CA-FR HP, and will tell the user what's the real URL is if it's incorrect */
	public static void main(String[] args)
	{
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.webex.ca/fr/");
	WebElement Element1=driver.findElement(By.linkText("FAQ"));
    Element1.click();
	String url=driver.getCurrentUrl();
	if (url.equalsIgnoreCase("https://www.webex.ca/fr/faqs1.html"))
			{
		System.out.println("the link for FAQ in header is correct");
			}
			else
			{
				System.out.println("the link for FAQ is header is incorrect, the real one is");
				System.out.println(url);
			}
			driver.close();
	

	}

}
