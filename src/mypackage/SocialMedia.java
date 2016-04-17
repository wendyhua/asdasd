package mypackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.util.Date;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
/*check social media links in footer */
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

//check social media links
public class SocialMedia {
	public static void check1(){
		//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
		//DesiredCapabilities capability=DesiredCapabilities.internetExplorer(); 
		// capability.setCapability( 
		 //             InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); 
		//WebDriver driver=new InternetExplorerDriver(capability);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.webex.com/");
		WebElement Element1=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[1]/a"));
		String url = Element1.getAttribute("href");
		if (url.equalsIgnoreCase("http://twitter.com/webex"))
		{
			System.out.println("Twitter's link is correct");
			}
			else
			{
				System.out.println("the Twitter link is incorrect, the real one is: " + url);
			}
		driver.close();
	}
	
	public static void check2()
	{
	//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
	//WebDriver driver=new InternetExplorerDriver();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.webex.com");
	WebElement Element1=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[2]/a"));
	String url=Element1.getAttribute("href");
	if (url.equalsIgnoreCase("http://www.linkedin.com/company/webex"))
			{
		System.out.println("LinkedIn's link is correct");
			}
			else
			{
				System.out.println("the link for Linkedin is incorrect, the real one is:" + url);
			}
			driver.close();
	

	}
	
	public static void check3()
	{
	//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
	//WebDriver driver=new InternetExplorerDriver();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.webex.com");
	WebElement Element1=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[3]/a"));
	String url=Element1.getAttribute("href");
	if (url.equalsIgnoreCase("http://www.facebook.com/webex"))
			{
		System.out.println("facebook's link is correct");
			}
			else
			{
				System.out.println("the link for facebook is incorrect, the real one is:" + url);
			}
			driver.close();
	

	}
	
	public static void check4() 
	{
	//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
	//WebDriver driver=new InternetExplorerDriver();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.webex.com");
	WebElement Element1=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[4]/a"));
	String url=Element1.getAttribute("href");
	if (url.equalsIgnoreCase("https://www.youtube.com/c/webex"))
			{
		System.out.println("youtube's link is correct");
			}
			else
			{
				System.out.println("the link for youtube is incorrect, the real one is:" + url);
			}
			driver.close();
	

	}
    
	public static void check5() 
	{
	//System.setProperty("webdriver.ie.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\IEDriverServer.exe");
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\jre1.8.0_74\\lib\\chromedriver.exe");
	//WebDriver driver=new InternetExplorerDriver();
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.webex.com");
	WebElement Element1=driver.findElement(By.xpath("/html/body/div[4]/div/div[3]/div/div[1]/div/div/ul/li[5]/a"));
	String url=Element1.getAttribute("href");
	if (url.equalsIgnoreCase("http://blog.webex.com"))
			{
		System.out.println("blog's link is correct");
			}
			else
			{
				System.out.println("the link for blog is incorrect, the real one is:" + url);
			}
			driver.close();
	

	}
    
	public static void main(String[] args) {
		SocialMedia.check1();
	    SocialMedia.check2();
		SocialMedia.check3();
		SocialMedia.check4();
		SocialMedia.check5();
		
	}
}
