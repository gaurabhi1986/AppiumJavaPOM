package com.mobile.autotest.pages;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SignInScreenPage extends BasePage {
	
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/sign_in_button\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/sign_in_button")
	private MobileElement signInBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/new_user\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/new_user")
	private MobileElement createAccountBtn;

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/skip_sign_in_button\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/skip_sign_in_button")
	private MobileElement skipSignInBtn;

	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/signin_to_yourAccount")
	private AndroidElement headerText;
	
	public SignInScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);		
	}

    /*
    *   Wait for Sign-In Screen to display
    */
    public void waitForHomecreen() {
        webDriverWait.until(ExpectedConditions.visibilityOf(headerText));
    }
       
    /*
     *   Click 'Already a customer? Sign in'
     */
     public void clickSignInButton() {
    	 webDriverWait.until(ExpectedConditions.visibilityOf(signInBtn));
         this.signInBtn.click();
     }
    
}
