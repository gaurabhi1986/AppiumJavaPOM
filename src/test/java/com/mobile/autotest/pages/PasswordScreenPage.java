package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PasswordScreenPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]")
	private MobileElement signInHeaderText;

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[1]/android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[4]")
	private MobileElement emailText;

	@AndroidFindBy(xpath = "//android.view.View[7]/android.view.View[2]/android.widget.EditText[1]")
	private MobileElement passwordText;

	@AndroidFindBy(xpath = "//android.view.View[7]/android.view.View[6]/android.widget.Button[1]")
	private MobileElement signInBtn;

	public PasswordScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	/*
	 * Wait for Password Screen to display
	 */
	public void waitForPasswordScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(signInHeaderText));
	}

	/*
	 * Validate email Address
	 */
	public boolean validateEmail(String email) {
		return this.emailText.getText().contains(email);
	}

	/*
	 * Enter Password
	 */
	public void enterPassword(String password) {
		this.passwordText.sendKeys(password);
	}

	/*
	 * Click Sign In
	 */
	public void clickSignIn() {
		this.signInBtn.click();
	}

}
