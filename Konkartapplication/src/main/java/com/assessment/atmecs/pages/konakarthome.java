package com.assessment.atmecs.pages;

import java.util.List;
import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.testbase.browserInvoke;
import com.assessment.atmecs.utils.utilityFiles;

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

}
