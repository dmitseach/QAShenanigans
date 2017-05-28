package com.qaprosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class DescriptionPage extends AbstractPage {

	public DescriptionPage(WebDriver driver) {
		super(driver);
	}

	public String readModelTitle() {
		String template = "//div[@id='container']//h1[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement brandFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(brandFieldText);
		return brandFieldText.getText();
	}

	public String readResolution() {
		String template = "//div[@id='specs']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement displayResolutionFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(displayResolutionFieldText);
		return displayResolutionFieldText.getText();
	}

	public String readOS() {
		String template = "//div[@id='specs']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement osFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(osFieldText);
		return osFieldText.getText();
	}

	public String readDisplay() {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement displayTypeFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(displayTypeFieldText);
		return displayTypeFieldText.getText();
	}

	public String readYear() {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement yearFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(yearFieldText);
		return yearFieldText.getText();
	}

	public String readColour() {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement colourCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(colourCheckbox);
		return colourCheckbox.getText();
	}

	public String readCoolSyst() {
		String template = "//div[@id='specs']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement coolingSystemFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(coolingSystemFieldText);
		return coolingSystemFieldText.getText();
	}

	public String readConstrType() {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template);
		ExtendedWebElement constructionTypeFieldText = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		assertElementPresent(constructionTypeFieldText);
		return constructionTypeFieldText.getText();
	}

}
