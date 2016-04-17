package mypackage;

import java.util.Properties;
import Pageobjects.Homepagetc;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.*;
//check CiscoSpark in footer
public class CiscoSpark {

	public static Properties commonProperties = null;

	@BeforeTest
	public void loadProp() throws Exception {
		commonProperties = propertiesfilereader.getInstance().readProperties(
				"common.properties");
	}

	
	public void Verifyciscospark() {
		boolean findSpark = false;

		WebDriver driver = new FirefoxDriver();

		driver.get(propertiesfilereader.getProperty("home"));
		driver.wait(2000);

		Homepagetc.CiscoSparkfooter(driver).click();

		if (driver.getWindowHandles().size() > 1) {
			for (String winhandle : driver.getWindowHandles()) {
				driver.switchTo().window(winhandle);

				String url1 = driver.getCurrentUrl();

				if (url1.equalsIgnoreCase(propertiesfilereader   
						.getProperty("home"))) {
					driver.close();
				}

				else if (url1.equalsIgnoreCase(propertiesfilereader
						.getProperty("CiscoSpark")))

				{
					 
					System.out.println("Navigating to correct url");

					System.out.println(url1);

					driver.close();

				} else {
					driver.close();
				}

			}

		}
		if (findSpark == false){
			System.out.println("CiscoSpark url not find");
		}

	}

}