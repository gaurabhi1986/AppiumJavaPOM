package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductDetailsScreenPage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/glow_subnav_ingress\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/glow_subnav_ingress")
	private MobileElement deliveryAddressModel;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/glow_subnav_label\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/glow_subnav_label")
	private MobileElement deliveryAddressLabel;

	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[3]/android.view.View[1]/android.view.View[2]/android.view.View[1]/android.view.View[2]")
	private MobileElement productDesc;

	//@AndroidFindBy(id = "priceblock_ourprice")
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View[1]")
	private MobileElement productPrice;

	@AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View[2]/android.view.View[1]")
	private MobileElement productBannerImage;

	@AndroidFindBy(xpath = "//android.view.View[5]/android.view.View[1]/android.view.View[1]/android.view.View[1]")
	private MobileElement buyNowButton;

	@AndroidFindBy(xpath = "//android.view.View[6]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.Button[1]")
	private MobileElement addToCartButton;

	//@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image\")")
	//@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_image")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.ImageView")
	private MobileElement cartIconImage;
	
	
	//@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count\")")
	//@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/chrome_action_bar_cart_count")
	@AndroidFindBy(xpath = "//android.widget.LinearLayout[2]/android.widget.FrameLayout/android.widget.TextView")
	private MobileElement cartCount;
	

	public ProductDetailsScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	/*
	 * Wait for Products List Screen to display
	 */
	public void waitForProductsDetailsScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(deliveryAddressLabel));
	}

	/*
	 * Add product to cart
	 */
	public void addProductToCart(String btnText) {
		scrollToElementByText(btnText).click();
	}

	/*
	 * Wait for Products List Screen to display
	 */
	public void clickCartIcon() {
		webDriverWait.until(ExpectedConditions.elementToBeClickable(cartIconImage));
		this.cartIconImage.click();
	}	
	/*
	 * Get Product Description
	 */
	public String getProductDescription() {
		webDriverWait.until(ExpectedConditions.visibilityOf(productDesc));
		System.out.println("ProductDetailsScreenPage  >>>> Product Description : " + this.productDesc.getText());
		return this.productDesc.getText();
	}
		
	/*
	 * Get Product Price.
	 */
	public String getProductPrice() {
		System.out.println("ProductDetailsScreenPage  >>>> Product Price : " + this.productPrice.getText());
		return this.productPrice.getText();
	}	
	/*
	 * Get Cart Count.
	 */
	public String getTotalCartCount() {
		return this.cartCount.getText();
	}

}
