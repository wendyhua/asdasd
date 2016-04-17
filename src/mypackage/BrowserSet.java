package mypackage;

public class BrowserSet {
	static file 
	public void setUp() throws Exception {
	    File file = new File("C:\\IEDriverServer\\IEDriverServer.exe");
	    System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	    driver = new InternetExplorerDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	

}
