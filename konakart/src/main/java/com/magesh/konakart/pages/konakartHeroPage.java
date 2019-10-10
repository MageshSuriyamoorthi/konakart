package com.magesh.konakart.pages;

import com.magesh.konakart.helper.ReadpropertiesFile;
import com.magesh.konakart.utils.utilityFiles;

public class konakartHeroPage {
	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();
	konakarthome konakartobject = new konakarthome();
	String actual, expected;
	String kitchentitle = utilityFiles.getdatatwo("Sheet2", "Kitchentitle");

	String kindletitle = utilityFiles.getdatatwo("Sheet2", "kindletitle");

	String title;

	public void getTitle() {

		utilityobject.ClickUsingXpath(propertyobject.getLocatorValue("locator.hero.navigation"));

		title = utilityobject.gettitle();
		
		utilityobject.scroll();

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
