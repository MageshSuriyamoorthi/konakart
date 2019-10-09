package com.assessment.atmecs.pages;

import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.utils.utilityFiles;

public class konakartHeroPage {
	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	konakartHeroPage konakartobject = new konakartHeroPage();

	String actual, expected;
	String kitchentitle = utilityFiles.getdatatwo("Sheet2", "Kitchentitle");

	String kindletitle = utilityFiles.getdatatwo("Sheet2", "kindletitle");

	String title;

	public void getTitle() {

		utilityobject.ClickUsingXpath(propertyobject.getLocatorValue("locator.hero.navigation"));

		title = utilityobject.gettitle();

	}

	public void validation(String locator, String columnname) {
		actual = utilityobject.locategettext(propertyobject.getLocatorValue(locator));

		expected = utilityFiles.getdatatwo("Sheet3", columnname);

	}

	public void titleValidation() {

		if (title.equals(kitchentitle)) {
			konakartobject.validation("locator.kitchenproduct.validation", "kitchendescription");
			utilityobject.assertmatch(actual, expected, "The kitchen product description is validated");

		} else if (title.equals(kindletitle)) {
			konakartobject.validation("locator.kindleproduct.validation", "kindledescription");
			utilityobject.assertmatch(actual, expected, "The kindle product description is validated");

		}

	}

	public void specificationValidation() {
		if (title.equals(kitchentitle)) {
			konakartobject.validation("locator.kitchenspecification.validation", "kitchenspecs");
			utilityobject.assertmatch(actual, expected, "The kitchen product specification is validated");

		} else if (title.equals(kindletitle)) {
			konakartobject.validation("locator.kindlespecification.validation", "kindlespecs");
			utilityobject.assertmatch(actual, expected, "The kindle product specification is validated");
		}

	}

}
