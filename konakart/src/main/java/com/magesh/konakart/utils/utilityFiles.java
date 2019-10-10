package com.magesh.konakart.utils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import com.magesh.konakart.classpath.Classpaths;
import com.magesh.konakart.helper.Locators;
import com.magesh.konakart.helper.ReadpropertiesFile;
import com.magesh.konakart.helper.XlxsReader;
import com.magesh.konakart.reports.log4j;
import com.magesh.konakart.testbase.browserInvoke;

public class utilityFiles extends browserInvoke {

	WebElement element;
	String getval;
	public static ReadpropertiesFile readpropertyobject = new ReadpropertiesFile();
	public static log4j log4jobject = new log4j();
	public static XlxsReader xlxsreaderobject = utilityFiles.getXlsReader(Classpaths.Excel_file_one);
	
	public void geturl(String string) {
		driver.get(string);
	}

	public void clicklocator(Locators locator, final String locatorValue) {
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(3, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		switch (locator) {
		case CLASSNAME:

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.className(locatorValue)).click();
					return true;
				}
			});
			break;
		case CSSSELECTOR:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.cssSelector(locatorValue)).click();
					return true;
				}
			});

			break;
		case ID:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.id(locatorValue)).click();
					return true;
				}
			});

			break;
		case LINKTEXT:

			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.linkText(locatorValue)).click();
					return true;
				}
			});
			break;
		case NAME:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.name(locatorValue)).click();
					return true;
				}
			});
			break;
		case PARTIALLINKTEXT:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.partialLinkText(locatorValue)).click();
					return true;
				}
			});
			driver.findElement(By.partialLinkText(locatorValue)).click();
			break;
		case TAGNAME:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.tagName(locatorValue)).click();
					return true;
				}
			});
			break;
		case XPATH:
			fluentWait.until(new Function<WebDriver, Boolean>() {
				public Boolean apply(WebDriver driver) {
					driver.findElement(By.xpath(locatorValue)).click();
					return true;
				}
			});
			break;
		default:
			log4jobject.info("Entering text into text box");
			break;
		}
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void ClickUsingXpath(String xpath) {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.findElement(By.xpath(xpath)).click();

	}

	public WebElement entertext(String Xpath, int text) {
		log4jobject.info("Entering text into text box");
		WebElement value = driver.findElement(By.xpath(Xpath));
		value.sendKeys(utilityFiles.getdata("textbox_values", text));
		log4jobject.info(text + " is entered");
		return value;
	}

	public WebElement entertextone(String Xpath, String text) {
		log4jobject.info("Entering text into text box");
		WebElement value = driver.findElement(By.xpath(Xpath));
		value.sendKeys(utilityFiles.getdataone(text));
		log4jobject.info(text + " is entered");
		return value;
	}

	public void Dropdown(String xpath, String text) {
		element = driver.findElement(By.xpath(xpath));
		Select value = new Select(element);
		value.selectByVisibleText(text);
	}

	public void scroll() {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollTo(0,650)");

	}

	public String scrolltoview(String Xpath) {
		WebElement element = driver.findElement(By.xpath(Xpath));
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].scrollIntoView();", element);
		javascript.executeScript("window.scrollTo(0,-500)");
		return Xpath;

	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = false;
		try {
			Assert.assertTrue(condition);
			log4jobject.info("PASS : " + message);
			System.out.println("PASS : " + message);
			// Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}

	public static boolean isDisplayed(String Xpath) {
		boolean isdisplayed = false;

		isdisplayed = driver.findElement(By.xpath(Xpath)).isDisplayed();
		if (isdisplayed = true) {
			return isdisplayed;
		} else {
			return false;
		}
	}

	public static String getActual(String Xpath) {
		String getstring = driver.findElement(By.xpath(Xpath)).getText();
		return getstring;
	}

	public static List<String> getexpected(String symbol) {
		String data = xlxsreaderobject.getCellDataByColumnName("Sheet1", "columnName", 1);
		String[] contents = data.split(symbol);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		return list;
	}

	public static List<String> Splittext(String element, String text) {
		String data = text;
		String[] contents = data.split(element);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		return list;

	}

	public static XlxsReader getXlsReader(String testDataFile) {
		XlxsReader xlsReader = new XlxsReader();

		try {
			xlsReader.setPath(testDataFile);
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}

	public static String expectedresult(String Xpath, int beginindex, int endindex) {
		String name = driver.findElement(By.xpath(Xpath)).getText().substring(beginindex, endindex);
		return name;
	}

	public static String dataresult(String sheetno, String sheetname, int index) {
		String dataname = xlxsreaderobject.getCellDataByColumnName(sheetno, sheetname, index);
		log4jobject.info(dataname);
		return dataname;
	}

	public static String datares(String sheetno, String sheetname, int index) {
		String dataname = xlxsreaderobject.getCellDataByColumnName(sheetno, sheetname, index);
		log4jobject.info(dataname);
		return dataname;
	}

	public void assertequals(String actual, String expected, String message) {
		log4jobject.info("Assertion Starts");
		Assert.assertEquals(actual, expected, "Assert not equals");
		log4jobject.info(message);
	}

	public String locateactualval(String sheet, String name, int index) {
		String value = xlxsreaderobject.getCellDataByColumnName(sheet, name, index);
		log4jobject.info("Expected " + value);
		return value;
	}

	public String locateexpectedvals(String Xpath) {
		String value = driver.findElement(By.xpath(Xpath)).getText();
		log4jobject.info("Actual " + value);
		return value;
	}

	public String locategettext(String Xpath) {
		String value = driver.findElement(By.xpath(Xpath)).getText();
		// log4jobject.info("The text is " + value);
		return value;
	}

	public void assertequals(String actual, List<WebElement> expected, String message) {
		// TODO Auto-generated method stub
		Assert.assertEquals(actual, expected, message);
		log4jobject.info(message);

	}

	public boolean mouseHoverTotab(String xPath) {
		WebElement webElement = driver.findElement(By.xpath(xPath));
		Actions action = new Actions(driver);
		action.moveToElement(webElement);

		return true;
	}

	public List<WebElement> getListOfWebElement(String locatorvalue) {
		List<WebElement> list = driver.findElements(By.xpath(locatorvalue));
		return list;
	}

	public List<String> convertListFromWebElement(List<WebElement> list) {
		List<String> textList = new ArrayList<String>();
		if (list.size() > 0) {
			for (WebElement element : list) {
				textList.add(element.getText());
			}
		}
		return textList;
	}

	public String replacetext(String Xpath, String replacingtext, String expectedtext) {
		String Replacedtext = readpropertyobject.getLocatorValue(Xpath).replace(replacingtext, expectedtext);
		String value = driver.findElement(By.xpath(Replacedtext)).getText();
		log4jobject.info("Actual " + value);
		return value;

	}

	public String getnewlocator(String Xpath, String replacingtext, String expectedtext) {
		String replacedtext = readpropertyobject.getLocatorValue(Xpath).replace(replacingtext, expectedtext);
		log4jobject.info("Replaced dynamic locator");
		return replacedtext;

	}

	public void assertmatch(String actual, String expected, String message) {
		// TODO Auto-generated method stub
		assertEquals(actual, expected);
		log4jobject.info(message);

	}

	public static void clickOnElement(final String xpath) {

		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
				.ignoring(ElementClickInterceptedException.class).pollingEvery(3, TimeUnit.SECONDS)
				.withTimeout(30, TimeUnit.SECONDS);

		fluentWait.until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				driver.findElement(By.xpath(xpath)).click();
				return true;
			}

		});
	}

	public static String getdata(String column_name, int text) {

		String contents = xlxsreaderobject.getCellDataByColumnName("Sheet1", column_name, text);
		return contents;
	}

	public static String getdataone(String column_name) {

		String contents = xlxsreaderobject.getCellDataByColumnName("Sheet1", column_name, 1);
		return contents;
	}

	public static String getdatatwo(String sheetname, String column_name) {

		String contents = xlxsreaderobject.getCellDataByColumnName(sheetname, column_name, 1);
		return contents;
	}

	public String gettitle() {
		String getval = driver.getTitle();

		return getval;

	}

}
