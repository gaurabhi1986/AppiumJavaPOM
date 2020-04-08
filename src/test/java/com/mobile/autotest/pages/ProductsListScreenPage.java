package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsListScreenPage extends BasePage {

	@AndroidFindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.view.View[1]")
	private MobileElement numOfResultsText;

	@AndroidFindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]")
	private MobileElement filtersDropDown;

	@AndroidFindBy(xpath = "//android.webkit.WebView[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]/android.view.View[1]")
	private MobileElement fmiltersDropDown;

	public ProductsListScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	/*
	 * Wait for Products List Screen to display
	 */
	public void waitForProductsListScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(numOfResultsText));
	}

	/*
	 * Select Random Product from List using Search Text
	 */
	public void selectRandomProductByText(String productSearchText) {
		scrollViewToElementByText(productSearchText).click();
	}
}
