package com.qaprosoft.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class PhoneModelsPage extends AbstractPage {

	@FindBy(xpath = "//div[@id='schema-filter']//span[2][contains(text(), 'Samsung')]")
	private ExtendedWebElement brandCheckbox;

	@FindBy(xpath = "//div[@id='schema-filter']//span[contains(text(), '2560x1600')]")
	private ExtendedWebElement resolutionCheckbox;

	@FindBy(xpath = "//div[@id='schema-filter']//span[2][contains(text(), 'Android')]")
	private ExtendedWebElement osCheckbox;

	@FindBy(xpath = "//div[@id='schema-products']//span[contains(text(), 'TFT')]")
	private ExtendedWebElement displayTypeCheckbox;

	// TODO DON'T forget to INSERT the name of the necessary device to xpath below!!
	@FindBy(xpath = "//div[@id='***NAME OF THE ID***']//span[contains(text(), '***NAME OF THE PHONE***')]")
	private ExtendedWebElement phoneModelLink;

	public PhoneModelsPage(WebDriver driver) {
		super(driver);
	}

	public void selectBrand() {
		brandCheckbox.click();
	}

	public void selectResolution() {
		resolutionCheckbox.click();
	}

	public void selectOS() {
		osCheckbox.click();
	}

	public void selectDisplayType() {
		displayTypeCheckbox.click();
	}

	public PhoneDescriptionPage selectPhoneModel() {
		phoneModelLink.click();
		return new PhoneDescriptionPage(driver);
	}
}
