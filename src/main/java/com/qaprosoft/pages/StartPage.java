/*
 * Copyright 2013-2016 QAPROSOFT (http://qaprosoft.com/).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.qaprosoft.pages;

import static com.qaprosoft.utils.Constants.URLS.ONLINER_URL;
// import com.qaprosoft.pages.PhoneModelsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class StartPage extends AbstractPage {

	public StartPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL(ONLINER_URL);
	}

	public ModelsPage selectSection(String section) {
		String template = "//div[@id='container']//a[contains(text(), '%s')]";
		String xpath = String.format(template, section);
		ExtendedWebElement sectionLink = new ExtendedWebElement(driver.findElement(By.xpath(xpath)));
		sectionLink.click();
		return new ModelsPage(driver);
	}

}
