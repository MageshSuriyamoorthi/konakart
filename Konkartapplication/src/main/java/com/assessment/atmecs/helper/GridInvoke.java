package com.assessment.atmecs.helper;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.assessment.atmecs.helper.ReadpropertiesFile;

public class GridInvoke {
		ReadpropertiesFile propertyobject = new ReadpropertiesFile();
		public URL url;
		String nodeurl;
		public WebDriver driver;
		String browser;

		// public WebDriver driver;

		public void openBrowser() {
			// TODO Auto-generated method stub
			browser = propertyobject.getLocatorValue("config.browsername");
			nodeurl = "http://55.55.52.136:2000/wd/hub";

			try {
				url = new URL(nodeurl);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (browser.equalsIgnoreCase("chrome")) {
				DesiredCapabilities capability = new DesiredCapabilities();
				capability = DesiredCapabilities.chrome();
				capability.setBrowserName(browser);
				capability.setPlatform(Platform.WIN10);
				driver = new RemoteWebDriver(url, capability);

			} else if (browser.equalsIgnoreCase("firefox")) {
				DesiredCapabilities capability = DesiredCapabilities.firefox();
				capability.setBrowserName(browser);
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(url, capability);

			} else if (browser.equalsIgnoreCase("ie")) {
				DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
				capability.setBrowserName(browser);
				capability.setPlatform(Platform.WINDOWS);
				driver = new RemoteWebDriver(url, capability);
			}
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		}

	}

//java -jar "C:\Drivers\selenium-server-standalone-3.141.59.jar" -role hub

//java -jar "C:\Drivers\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register
