package com.qaprosoft.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.dao.PhoneDAO;
import com.qaprosoft.objects.Phone;
import com.qaprosoft.pages.*;

public class PhoneTest extends UITest {
	@Test(dataProvider = "SingleDataProvider", description = "1.1 Verify model data against web data")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Phones", dsUid = "TUID", dsArgs = "section, brand, resolution, os, display, year, model, title")
	public void testPhoneModelSpecs(String section, String brand, String model, String resolution, String os,
			String display, String year, String title) throws Exception {
		StartPage startPage = new StartPage(getDriver());
		startPage.open();
		Assert.assertTrue(startPage.isPageOpened(), "The catalog page is unavailable");
		ModelsPage modelPage = startPage.selectSection(section);
		modelPage.selectBrand(brand);
		modelPage.selectResolution(resolution);
		modelPage.selectOS(os);
		modelPage.selectDisplayType(display);
		modelPage.selectYear(year);
		Thread.sleep(3000);
		DescriptionPage descriptionPage = modelPage.selectModel(model);
		Assert.assertEquals(descriptionPage.readModelTitle(), title, "Model title is invalid!");
		Assert.assertEquals(descriptionPage.readResolution(), resolution, "Display resolution info is invalid!!");
		Assert.assertEquals(descriptionPage.readOS(), os, "OS info is invalid!!");
		Assert.assertEquals(descriptionPage.readDisplay(), display, "Display type info is invalid!!");
	}

	@Test(dataProvider = "SingleDataProvider", description = "1.2 Verify model data against DB data", dependsOnMethods = "testPhoneModelSpecs")
	@XlsDataSourceParameters(path = "xls/test.xlsx", sheet = "Phones", dsUid = "TUID", dsArgs = "id, brand, resolution, os, display, year")
	public void testPhoneModelSpecsToDB(String id, String brand, String model, String resolution, String os,
			String display, String year) {
		PhoneDAO phoneDAO = new PhoneDAO();
		Phone phone = phoneDAO.getPhoneById(1);
		String dbData = String.join(" ", String.valueOf(phone.getId()), phone.getModel(), phone.getResolution(),
				phone.getOs(), phone.getDisplay(), phone.getYear());
		String xlsData = String.join(" ", id, model, resolution, brand, os, display, year);
		Assert.assertEquals(dbData, xlsData, "Model data is invalid against DB data!");
	}
}
