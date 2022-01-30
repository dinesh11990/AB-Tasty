package commonFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class CommonFunctions {
	
	//Property file configuration
	public static WebDriver driver=null;
	public static Properties properties=null;
	static Logger logger=Logger.getLogger("CommonFunctions.class");
	public Properties loadPropertyFile() throws IOException {		
		FileInputStream fileInputStream=new FileInputStream("config.properties");
		properties=new Properties();
		properties.load(fileInputStream);	
		return properties;
	}
	
	@BeforeSuite
	public void launchBrowser() throws IOException {
		
		//Configuring the log4j
		PropertyConfigurator.configure("log4j.properties");
		logger.info("AB Tasty Portal");
		logger.info("Loading the property file");
		loadPropertyFile();
		String browser=properties.getProperty("browser");
		String url=properties.getProperty("url");
		String driverLocation=properties.getProperty("DriverLocation");
		
		//Run in different browser
		if(browser.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver",driverLocation);
			logger.info("Launching Chrome");
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("fireFox")) {
			System.getProperty("webdriver.gecko.driver",driverLocation);
			logger.info("Launching Firefox");
			driver=new FirefoxDriver();}
		
		//Maximize the browser
		driver.manage().window().maximize();
		logger.info("Navigated to AB Tasty Application");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		
	}
	
	@AfterSuite
	public void tearDown() {
		
		logger.info("Execution Done, Closing the browser");
		//driver.quit();
		
	}

}
