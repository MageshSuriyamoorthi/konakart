package com.assessment.atmecs.testscript;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.pages.konakarthome;
//import com.assessment.atmecs.reports.ExtentReport;
import com.assessment.atmecs.testbase.browserInvoke;
import com.assessment.atmecs.utils.utilityFiles;

public class konakartHomeScript {

	konakarthome konakartobject = new konakarthome();
	browserInvoke browserobject = new browserInvoke();
	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();

	@BeforeSuite
	public void get_browser() {
		browserobject.OpenBrowser();
	}

	@BeforeTest
	public void get_url() {
		konakartobject.geturl();
	}

	@BeforeMethod
	public void search_product() {
		konakartobject.openkonakarthome();
	}

	@Test(priority = 1)
	public void positive_validation() {
		konakartobject.searchproduct(utilityFiles.getdataone("dropdown_data"), "positive value");
		konakartobject.positivescenarioval();
	}

	@Test(priority = 2)
	public void negative_validation() {
		konakartobject.searchproduct(utilityFiles.getdataone("dropdown_data"), "negative value");
		konakartobject.negativescenarioval();
	}

	@Test(priority = 3)
	public void neutral_validation() {
		konakartobject.searchproduct(utilityFiles.getdataone("dropdown_data"), "neutral value");
		konakartobject.neutralscenarioval();
	}

}
