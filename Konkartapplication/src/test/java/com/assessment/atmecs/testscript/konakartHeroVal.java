package com.assessment.atmecs.testscript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.assessment.atmecs.helper.ReadpropertiesFile;
import com.assessment.atmecs.pages.konakartHeroPage;
import com.assessment.atmecs.testbase.browserInvoke;
import com.assessment.atmecs.utils.utilityFiles;

public class konakartHeroVal  {
	konakartHeroPage konakartheroobject = new konakartHeroPage();
	browserInvoke browserobject = new browserInvoke();
	utilityFiles utilityobject = new utilityFiles();
	ReadpropertiesFile propertyobject = new ReadpropertiesFile();

	@Test
	public void Hero_validation() {
		konakartheroobject.getTitle();

		konakartheroobject.titleValidation();

		konakartheroobject.specificationValidation();
	}

	/*
	 * @AfterMethod public void project_report() { //
	 * ExtentReport.reportLog("Konakart website", "validation Report"); }
	 */
	@AfterTest
	public void close_browser() {
		browserobject.BrowserClose();
	}

}
