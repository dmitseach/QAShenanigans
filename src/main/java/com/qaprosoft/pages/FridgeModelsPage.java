package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class FridgeModelsPage extends AbstractPage {

	@FindBy(xpath = "//div[@id='schema-filter']//span[2][contains(text(), 'Samsung')]")
	private ExtendedWebElement brandCheckbox;

	@FindBy(xpath = "//div[@id='schema-filter']//span[contains(text(), 'side by side')]")
	private ExtendedWebElement constructionTypeCheckbox;

	@FindBy(xpath = "//div[@id='schema-filter']//span[2][contains(text(), 'полный No Frost')]")
	private ExtendedWebElement coolingSystemCheckbox;

	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), 'серебристый')]")
	private ExtendedWebElement colourCheckbox;

 	// TODO DON'T forget to INSERT the name of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='***NAME OF THE ID***']//span[contains(text(), '***NAME OF THE FRIDGE***')]")
	private ExtendedWebElement fridgeModelLink;

	public FridgeModelsPage(WebDriver driver) {
		super(driver);
	}

	public void selectBrand() {
		brandCheckbox.click();
	}

	public void selectConstructionType() {
		constructionTypeCheckbox.click();
	}

	public void selectCoolingSystemType() {
		coolingSystemCheckbox.click();
	}

	public void selectColour() {
		colourCheckbox.click();
	}

	public FridgeDescriptionPage selectFridgeModel() {
		fridgeModelLink.click();
		return new FridgeDescriptionPage(driver);
	}

}
