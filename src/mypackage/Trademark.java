package mypackage;

import java.util.Properties;

import Pageobjects.Homepagetc;

import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.*;

public class PrivacyStatement {

	public static Properties commonProperties = null;

	@BeforeTest
	public void loadProp() throws Exception {

		commonProperties = propertiesfilereader.getInstance().readProperties(
				"common.properties");
	}

	/* TC4177 */
	@Test
	public void VerifyPrivacystat() {

		WebDriver driver = new FirefoxDriver();

		driver.get(propertiesfilereader.getProperty("home"));

		Homepagetc.FooterPrivacyStatement(driver).click();

		if (driver.getWindowHandles().size() > 1)

		{

			for (String winhandle : driver.getWindowHandles())

			{

				driver.switchTo().window(winhandle);

				String url1 = driver.getCurrentUrl();

				if (url1.equalsIgnoreCase(propertiesfilereader
						.getProperty("home")))

				{

					driver.close();
				}

				else if (url1.equalsIgnoreCase(propertiesfilereader
						.getProperty("privacystatement")))

				{

					System.out.println("Navigating to correct url");

					System.out.println(url1);

					driver.close();

				}

				driver.close();

			}

		}

	 }

}