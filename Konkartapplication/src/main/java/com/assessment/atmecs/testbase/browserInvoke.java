package com.assessment.atmecs.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.assessment.atmecs.classpath.Classpaths;
import com.assessment.atmecs.helper.GridInvoke;
import com.assessment.atmecs.helper.ReadpropertiesFile;

public class browserInvoke {
	Logger loggerobject = Logger.getLogger("utilityfiles");
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	GridInvoke invoke = new GridInvoke();
	public static WebDriver driver;
	String runvia, browser;

	@SuppressWarnings("deprecation")
	public void OpenBrowser() {

		runvia = propertyobject.getLocatorValue("config.runvia");
		if (runvia.equalsIgnoreCase("browser")) {

			browser = propertyobject.getLocatorValue("config.browsername");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("Webdriver.chrome.driver", Classpaths.Chrome_file);
				driver = new ChromeDriver();
				loggerobject.info("chrome has started");

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("Webdriver.gecko.driver", Classpaths.Firefox_file);
				driver = new FirefoxDriver();
				loggerobject.info("firefox has started");

			}

			else if (browser.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.edge.driver", Classpaths.IE_file);
				DesiredCapabilities ieCaps = DesiredCapabilities.internetExplorer();
				ieCaps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "https://bing.com");
				driver = new InternetExplorerDriver(ieCaps);
				loggerobject.info("Internet explorer has started");

			} // properties.loadproperty("browser").
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		} else if (runvia.equalsIgnoreCase("grid")) {

			invoke.openBrowser();
		}
	}

	public void BrowserClose() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.close();
	}
}

