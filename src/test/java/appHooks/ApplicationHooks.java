package appHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.config.ConfigReader;
import com.qa.driverFactory.DriverFactory;
import com.qa.util.TestUtils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() throws IOException
	{
		configReader= new ConfigReader();
		prop= configReader.init_prop();
		//System.out.println("get browser type "+prop.getProperty("browser"));
	}
	
	@Before(order=1)
	public void launchBrowser() throws IOException
	{
		String browserName=prop.getProperty("browser");
		//System.out.println("Browser name--->"+browserName);
		driverFactory= new DriverFactory();
		driver= driverFactory.init_driver_launchBrowser(browserName);
	}
	
	@After(order=0)
	public void quitBrowser() throws IOException
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario) throws IOException
	{
		if(scenario.isFailed())
		{
			TestUtils.takeScreenshotOnFailure(scenario,driver);
		}
	}

}