import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.firefox.FirefoxDriver;
/*check link of TOS in footer*/

public class CheckLinkTOS {
	public static void check1(){
		System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
		DesiredCapabilities capability=DesiredCapabilities.internetExplorer(); 
		 capability.setCapability( 
		              InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		WebDriver driver=new InternetExplorerDriver(capability);
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.get("http://www.webex.com");
		WebElement Element1=driver.findElement(By.linkText("Terms of Service"));
		Element1.click();
		String url=driver.getCurrentUrl();
		if (url.equalsIgnoreCase("https://www.webex.com/terms-of-service.html"))
		{
			System.out.println("the link of TOS in footer is correct");
			}
			else
			{
				System.out.println("the link of TOS is footer is incorrect, the real one is: " + url);
			}
		driver.close();
	}
    /* check link of FAQ in header */
	public static void check2()
	{
	System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
	//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
	DesiredCapabilities capability=DesiredCapabilities.internetExplorer(); 
	 capability.setCapability( 
	              InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
	WebDriver driver=new InternetExplorerDriver(capability);
	//WebDriver driver = new ChromeDriver();
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
				System.out.println("the link for FAQ is header is incorrect, the real one is:" + url);
				System.out.println(url);
			}
			driver.close();
	

	}
    
	public static void main(String[] args) {
		CheckLinkTOS.check1();
		CheckLinkTOS.check2();
	}
}

