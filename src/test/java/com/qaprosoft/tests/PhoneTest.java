package com.qaprosoft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.pages.*;

public class PhoneTest extends UITest {
	@Test(dataProvider = "SingleDataProvider", description = "1.1 Verify model data against web data")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Phones", dsUid = "TUID", dsArgs = "brand, resolution, os, display, year")
	public void testPhoneModelSpecs(String brand, String model, String resolution, String os, String display)
			throws Exception {
		StartPage startPage = new StartPage(getDriver());
		startPage.open();
		Assert.assertTrue(startPage.isPageOpened(), "The catalog page is unavailable");
		PhoneModelsPage phoneModelPage = startPage.tapOnPhonesSection();
		phoneModelPage.selectBrand();
		phoneModelPage.selectResolution();
		phoneModelPage.selectOS();
		phoneModelPage.selectDisplayType();
		PhoneDescriptionPage phoneDescriptionPage = phoneModelPage.selectPhoneModel();
		Assert.assertEquals(phoneDescriptionPage.readBrand(), brand, "Brand info is invalid!");
		Assert.assertEquals(phoneDescriptionPage.readResolution(), resolution, "Display resolution info is invalid!!");
		Assert.assertEquals(phoneDescriptionPage.readOS(), os, "OS info is invalid!!");
		Assert.assertEquals(phoneDescriptionPage.readDisplay(), display, "Display type info is invalid!!");
	}

	@Test(dataProvider = "SingleDataProvider", description = "1.2 Verify model data against DB data", dependsOnMethods = "testPhoneModelSpecs")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Phones", dsUid = "TUID", dsArgs = "brand, resolution, os, display, year")
	public void testPhoneModelSpecsToDB(String brand, String model, String resolution, String os, String display) {
		// TODO
		// 1. Get the data from DB and toString it
		String dbData = "";
		// 2. Verify if DB data is valid against the data from "xls/test.xlsx" (see
		// above @XlsDataSourceParameters)
		String xlsData = brand + model + resolution + os + display;
		Assert.assertEquals(dbData, xlsData, "Model data is invalid against DB data!");
		// 3. If it's ok - the model info on the web site is valid against the DB data
		// NOTE: If change names of classes or methods - go to resources/web.xml to change binded data

	}
}
