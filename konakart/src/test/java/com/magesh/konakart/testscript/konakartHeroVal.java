package com.magesh.konakart.testscript;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.magesh.konakart.helper.ReadpropertiesFile;
import com.magesh.konakart.pages.konakartHeroPage;
import com.magesh.konakart.reports.ExtentReport;
import com.magesh.konakart.testbase.browserInvoke;
import com.magesh.konakart.utils.utilityFiles;

public class konakartHeroVal extends konakartHomeScript {
	konakartHeroPage konakartheroobject = new konakartHeroPage();
	browserInvoke browserobject = new browserInvoke();
	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();

	@Test(priority = 4)
	public void Hero_validation() {
		konakartheroobject.getTitle();

		konakartheroobject.titleValidation();

		konakartheroobject.specificationValidation();
	}

	/*
	 * @AfterMethod public void project_report() {
	 * ExtentReport.reportLog("Konakart website", "validation Report"); }
	 */

	@AfterTest
	public void close_browser() {
		browserobject.BrowserClose();
	}

}
