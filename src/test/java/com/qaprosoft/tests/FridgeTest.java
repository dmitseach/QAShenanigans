package com.qaprosoft.tests;

import org.testng.Assert;

import com.qaprosoft.carina.core.foundation.UITest;
import com.qaprosoft.pages.StartPage;

public class FridgeTest extends UITest {
	public void testModelSpecs() {
		StartPage startPage = new StartPage(getDriver());
		startPage.open();
		Assert.assertTrue(startPage.isPageOpened(), "The catalog page is unavailable");
		startPage.selectFridgesSection();
	}

}
