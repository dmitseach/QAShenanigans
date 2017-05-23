package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneDescriptionPage extends AbstractPage {

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='container']//h1[contains(text(), '***')]")
	private ExtendedWebElement brandFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement displayResolutionFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement ramFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), '***')]")
	private ExtendedWebElement displayTypeFieldText;

	public PhoneDescriptionPage(WebDriver driver) {
		super(driver);
	}

	public String readBrand() {
		assertElementPresent(brandFieldText);
		return brandFieldText.getText();
	}

	public String readResolution() {
		assertElementPresent(displayResolutionFieldText);
		return displayResolutionFieldText.getText();
	}

	public String readOS() {
		assertElementPresent(ramFieldText);
		return ramFieldText.getText();
	}

	public String readDisplay() {
		assertElementPresent(displayTypeFieldText);
		return displayTypeFieldText.getText();
	}

}
