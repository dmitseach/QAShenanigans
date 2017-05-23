package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneDescriptionPage extends AbstractPage {
	@FindBy(xpath = "//div[@id='container']//h1[contains(text(), '***')]")
	private ExtendedWebElement brandField;

	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement displayResolutionField;

	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement ramField;
	
	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), '***')]")
	private ExtendedWebElement displayTypeField;

	public PhoneDescriptionPage(WebDriver driver) {
		super(driver);
	}

}
