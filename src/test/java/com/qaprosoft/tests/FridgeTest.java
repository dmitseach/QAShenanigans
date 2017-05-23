package com.qaprosoft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.pages.*;

public class FridgeTest extends UITest {
	@Test(dataProvider = "SingleDataProvider", description = "1.1 Verify model data against web data")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Fridges", dsUid = "TUID", dsArgs = "brand, colour, coolSyst, constrType")
	public void testFridgeModelSpecs(String brand, String colour, String coolSyst, String constrType) throws Exception {
		StartPage startPage = new StartPage(getDriver());
		startPage.open();
		Assert.assertTrue(startPage.isPageOpened(), "The catalog page is unavailable");
		FridgeModelsPage fridgeModelPage = startPage.tapOnFridgesSection();
		fridgeModelPage.selectBrand();
		fridgeModelPage.selectColour();
		fridgeModelPage.selectCoolingSystemType();
		fridgeModelPage.selectConstructionType();
		FridgeDescriptionPage fridgeDescriptionPage = fridgeModelPage.selectFridgeModel();
		Assert.assertEquals(fridgeDescriptionPage.readBrand(), brand, "Brand info is invalid!");
		Assert.assertEquals(fridgeDescriptionPage.readColour(), colour, "Colour info is invalid!!");
		Assert.assertEquals(fridgeDescriptionPage.readCoolSyst(), coolSyst, "Cooling system info is invalid!!");
		Assert.assertEquals(fridgeDescriptionPage.readConstrType(), constrType, "Construction type info is invalid!!");
	}

	@Test(dataProvider = "SingleDataProvider", description = "1.2 Verify model data against DB data", dependsOnMethods = "testFridgeModelSpecs")
	public void testModelSpecs() {
		// TODO
		// 1. Get the data from DB
		// 2. Verify is DB data valid against the data from "xls/test.xlsx" (see above @XlsDataSourceParameters)
		// 3. If it's ok - the model info on the web site is valid against the
		// DB data
	}
}
