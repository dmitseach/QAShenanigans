package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class FridgeDescriptionPage extends AbstractPage {
	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='container']//h1[contains(text(), '***')]")
	private ExtendedWebElement brandFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement constructionTypeFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='specs']//span[contains(text(), '***')]")
	private ExtendedWebElement coolingSystemFieldText;

	// TODO DON'T forget to INSERT a data of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), '***')]")
	private ExtendedWebElement colourFieldText;

	public FridgeDescriptionPage(WebDriver driver) {
		super(driver);
	}

	public String readBrand() {
		assertElementPresent(brandFieldText);
		return brandFieldText.getText();
	}

	public String readColour() {
		assertElementPresent(colourFieldText);
		return colourFieldText.getText();
	}

	public String readCoolSyst() {
		assertElementPresent(coolingSystemFieldText);
		return coolingSystemFieldText.getText();
	}

	public String readConstrType() {
		assertElementPresent(constructionTypeFieldText);
		return constructionTypeFieldText.getText();
	}

}
