package com.magesh.konakart.pages;

import java.util.List;
import com.magesh.konakart.helper.ReadpropertiesFile;
import com.magesh.konakart.testbase.browserInvoke;
import com.magesh.konakart.utils.utilityFiles;

public class konakarthome extends browserInvoke {

	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	String actual, expected;

	public void geturl() {

		utilityobject.geturl(propertyobject.getLocatorValue("config.homepage.url"));
		utilityobject.maximize();
	}

	public void openkonakarthome() {

		utilityFiles.clickOnElement(propertyobject.getLocatorValue("locator.konakart.home"));

	}

	public void searchproduct(String dd_data, String dd_text) {

		utilityobject.Dropdown(propertyobject.getLocatorValue("locator.select.dropdown"), dd_data);

		utilityobject.entertextone(propertyobject.getLocatorValue("locator.entertext.field"), dd_text);

		utilityFiles.clickOnElement(propertyobject.getLocatorValue("locator.search.button"));

	}

	public void positivescenarioval() {

		expected = utilityFiles.getActual(propertyobject.getLocatorValue("locator.product.available"));

		actual = utilityFiles.getActual(propertyobject.getLocatorValue("locator.product.text"));

		utilityobject.assertequals(actual, expected, "the product were equal");
	}

	public void negativescenarioval() {

		actual = utilityFiles.getActual(propertyobject.getLocatorValue("locator.product.validate"));

		utilityobject.assertequals(actual, utilityFiles.getdataone("negativevalues"),
				"There is no such products try, different search");
	}

	public void neutralscenarioval() {
		actual = utilityFiles.getActual(propertyobject.getLocatorValue("locator.product.validate"));

		List<String> needed = utilityFiles.Splittext("for", actual);

		utilityobject.assertequals(needed.get(0), utilityFiles.getdataone("neutralvalues"),
				"There is no such products try, different search");
	}
	
	public void validation(String locator, String columnname) {
		actual = utilityobject.locategettext(propertyobject.getLocatorValue(locator));

		expected = utilityFiles.getdatatwo("Sheet3", columnname);

	}


}
