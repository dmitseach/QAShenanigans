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
import com.qaprosoft.pages.PhoneModelsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;

public class StartPage extends AbstractPage {
	@FindBy(xpath = "//div[@id='container']//a[contains(text(), 'Мобильные телефоны')]")
	private ExtendedWebElement phonesSectionLink;

	@FindBy(xpath = "//div[@id='container']//a[contains(text(), 'Холодильники')]")
	private ExtendedWebElement fridgesSectionLink;

	public StartPage(WebDriver driver) {
		super(driver);
		setPageAbsoluteURL(ONLINER_URL);
	}

	public ExtendedWebElement getPhonesSection() {
		return phonesSectionLink;
	}

	public ExtendedWebElement getFridgesSection() {
		return fridgesSectionLink;
	}

	public PhoneModelsPage selectPhonesSection() {
		phonesSectionLink.click();
		return new PhoneModelsPage(driver);
	}

	public PhoneModelsPage selectFridgesSection() {
		fridgesSectionLink.click();
		return new PhoneModelsPage(driver);
	}
}
