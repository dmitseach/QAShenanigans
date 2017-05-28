package com.qaprosoft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class ModelsPage extends AbstractPage {

	public ModelsPage(WebDriver driver) {
		super(driver);
	}

	public void selectBrand(String brand) {
		String template = "//div[@id='schema-filter']//span[2][contains(text(), '%s')]";
		String xpath = String.format(template, brand);
		ExtendedWebElement brandCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		brandCheckbox.click();
	}

	public void selectResolution(String resolution) {
		String template = "//div[@id='schema-filter']//span[contains(text(), '%s')]";
		String xpath = String.format(template, resolution);
		ExtendedWebElement resolutionCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		resolutionCheckbox.click();
	}

	public void selectOS(String os) {
		String template = "//div[@id='schema-filter']//span[2][contains(text(), '%s')]";
		String xpath = String.format(template, os);
		ExtendedWebElement osCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		osCheckbox.click();
	}

	public void selectDisplayType(String display) {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template, display);
		ExtendedWebElement displayTypeCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		displayTypeCheckbox.click();
	}

	public void selectYear(String year) {
		String template = "//div[@id='schema-filter']//span[contains(text(), '%s')]";
		String xpath = String.format(template, year);
		ExtendedWebElement yearCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		yearCheckbox.click();
	}

	public void selectConstructionType(String constrType) {
		String template = "//div[@id='schema-filter']//span[contains(text(), '%s')]";
		String xpath = String.format(template, constrType);
		ExtendedWebElement constructionTypeCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		constructionTypeCheckbox.click();
	}

	public void selectCoolingSystemType(String coolSyst) {
		String template = "//div[@id='schema-filter']//span[2][contains(text(), '%s')]";
		String xpath = String.format(template, coolSyst);
		ExtendedWebElement coolingSystemCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		coolingSystemCheckbox.click();
	}

	public void selectColour(String colour) {
		String template = "//div[@id='schema-products']//span[contains(text(), '%s')]";
		String xpath = String.format(template, colour);
		ExtendedWebElement colourCheckbox = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		colourCheckbox.click();
	}

	public DescriptionPage selectModel(String model) {
		String template = "//div[@id='container']//span[contains(text(), '%s')]";
		String xpath = String.format(template, model);
		ExtendedWebElement modelLink = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		modelLink.click();
		return new DescriptionPage(driver);
	}
}