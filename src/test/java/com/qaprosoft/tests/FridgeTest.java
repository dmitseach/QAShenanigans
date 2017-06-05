package com.qaprosoft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.dao.FridgeDAO;
import com.qaprosoft.objects.Fridge;
import com.qaprosoft.pages.*;

public class FridgeTest extends UITest {
	@Test(dataProvider = "SingleDataProvider", description = "1.1 Verify model data against web data")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Fridges", dsUid = "TUID", dsArgs = "section, brand, colour, coolSyst, model, constrType, title")
	public void testFridgeModelSpecs(String section, String brand, String colour, String coolSyst, String constrType,
			String model, String title) throws Exception {
		StartPage startPage = new StartPage(getDriver());
		startPage.open();
		Assert.assertTrue(startPage.isPageOpened(), "The catalog page is unavailable");
		ModelsPage modelPage = startPage.selectSection(section);
		modelPage.selectColour(colour);
		modelPage.selectCoolingSystemType(coolSyst);
		modelPage.selectConstructionType(constrType);
		DescriptionPage descriptionPage = modelPage.selectModel(model);
		Assert.assertEquals(descriptionPage.readModelTitle(), title, "Model title is invalid!");
		Assert.assertEquals(descriptionPage.readColour(), colour, "Colour info is invalid!!");
		Assert.assertEquals(descriptionPage.readCoolSyst(), coolSyst, "Cooling system info is invalid!!");
		Assert.assertEquals(descriptionPage.readConstrType(), constrType, "Construction type info is invalid!!");
	}

	@Test(dataProvider = "SingleDataProvider", description = "1.2 Verify model data against DB data", dependsOnMethods = "testFridgeModelSpecs")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Fridges", dsUid = "TUID", dsArgs = "id, brand, colour, coolSyst, constrType")
	public void testModelSpecs(String id, String brand, String colour, String coolSyst, String constrType) {
		FridgeDAO fridgeDAO = new FridgeDAO();
		Fridge fridge = fridgeDAO.getFridgeById(1);
		String dbData = String.join(" ", String.valueOf(fridge.getId()), fridge.getModel(), fridge.getColour(),
				fridge.getCoolSyst(), fridge.getConstrType());
		String xlsData = String.join(" ", id, brand, colour, coolSyst, constrType);
		Assert.assertEquals(dbData, xlsData, "Model data is invalid against DB data!");
	}

}
