package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductCartScreenPage extends BasePage {

	/*
	 * @AndroidFindBy(uiAutomator =
	 * "new UiSelector().resourceId(\"7a25401a-6561-4a49-9282-7c5fd65ab052\")")
	 * 
	 * @AndroidFindBy(id = "7a25401a-6561-4a49-9282-7c5fd65ab052")
	 */
	@AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.widget.Button")
	private MobileElement proceedToCheckoutButton;
	
	@AndroidFindBy(xpath = "//android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[3]/android.view.View")
	private MobileElement productDescription;
	
	@AndroidFindBy(xpath = "//android.view.View/android.view.View[3]/android.widget.ListView/android.view.View[1]")
	private MobileElement productPrice;
	
	public ProductCartScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}
	/*
	 * Wait for Products List Screen to display
	 */
	public void waitForProductCartScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(proceedToCheckoutButton));
	}	
	/*
	 * Get Product Description
	 */
	public String getProductDescription() {
		System.out.println("ProductCartScreenPage  >>>> Product Description : " + this.productDescription.getText());
		return this.productDescription.getText();
	}		
	/*
	 * Get Product Price.
	 */
	public String getProductPrice() {
		System.out.println("ProductCartScreenPage  >>>> Product Price : " + this.productPrice.getText());
		return this.productPrice.getText();
	}
}
