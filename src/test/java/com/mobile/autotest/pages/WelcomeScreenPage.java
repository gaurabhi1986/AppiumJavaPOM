package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomeScreenPage extends BasePage {

	@AndroidFindBy(xpath = "//android.webkit.WebView[1]/android.webkit.WebView[1]/android.view.View[1]/android.view.View[2]/android.view.View[1]")
	private MobileElement welcomeHeaderText;
	
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"register_accordion_header\")")
	@AndroidFindBy(id = "register_accordion_header")
	private MobileElement createAccRadioBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_customer_name\")")
	@AndroidFindBy(id = "ap_customer_name")
	private MobileElement nameTextField;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_email\")")
	@AndroidFindBy(id = "ap_email")
	private MobileElement mobOrEmailTextField;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"ap_password\")")
	@AndroidFindBy(id = "ap_password")
	private MobileElement pwdTextField;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"auth-register-show-password-checkbox\")")
	@AndroidFindBy(id = "auth-register-show-password-checkbox")
	private MobileElement showPwdCheckBox;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"login_accordion_header\")")
	@AndroidFindBy(id = "login_accordion_header")
	private MobileElement signInRadioBtn;

	//@AndroidBy(className = "android.widget.EditText")
	@AndroidFindBy(xpath ="//android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.widget.EditText[1]")
	private MobileElement emailTextField;

	//@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"continue\")")
	//@AndroidFindBy(id = "continue")
	@AndroidFindBy(xpath = "//android.view.View[2]/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.view.View[3]/android.widget.Button[1]")
	private AndroidElement continueBtn;

	public WelcomeScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	/*
	 * Wait for Welcome Screen to display
	 */
	public void waitForWelcomeScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(welcomeHeaderText));
	}

	/*
	 * Enter Email Address
	 */
	public void enterEmailAddress(String email) {
		//webDriverWait.until(ExpectedConditions.elementToBeClickable(emailTextField));
		this.emailTextField.sendKeys(email);
	}
	
	/*
	 * Click Continue Button
	 */
	public void clickContinueBtn() {
		//webDriverWait.until(ExpectedConditions.elementToBeClickable(emailTextField));
		this.continueBtn.click();
	}

}