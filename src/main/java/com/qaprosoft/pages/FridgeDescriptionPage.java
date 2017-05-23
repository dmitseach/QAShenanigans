package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class FridgeDescriptionPage extends AbstractPage {
	@FindBy(xpath = "//div[@id='container']//h1[contains(text(), '***')]")
	private ExtendedWebElement brandField;

	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement constructionTypeField;

	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement coolingSystemField;

	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), '***')]")
	private ExtendedWebElement colourField;

	public FridgeDescriptionPage(WebDriver driver) {
		super(driver);
	}
}
