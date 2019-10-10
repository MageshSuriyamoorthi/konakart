package com.magesh.konakart.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;

import com.magesh.konakart.classpath.Classpaths;
import com.magesh.konakart.helper.GridInvoke;
import com.magesh.konakart.helper.ReadpropertiesFile;




public class browserInvoke {
	Logger loggerobject = Logger.getLogger("Config files");
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	GridInvoke invoke = new GridInvoke();
	public static WebDriver driver;
	String runvia, browser;

	

	@SuppressWarnings("deprecation")
	@BeforeTest
	public void OpenBrowser() {

		runvia = propertyobject.getLocatorValue("config.runvia");
		if (runvia.equalsIgnoreCase("browser")) {

			browser = propertyobject.getLocatorValue("config.browsername");

			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						Classpaths.Chrome_file);
				driver = new ChromeDriver();
				loggerobject.info("chrome has started");

			} else if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", Classpaths.Firefox_file);
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
