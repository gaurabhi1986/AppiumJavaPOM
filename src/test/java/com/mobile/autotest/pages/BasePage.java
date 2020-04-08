package com.mobile.autotest.pages;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Created by Abhishek Gaur on 04/04/20.
 */

public class BasePage {

	protected AndroidDriver<AndroidElement> androidDriver;
	protected WebDriverWait webDriverWait;

	public BasePage(AndroidDriver androidDriver) {
		this.androidDriver = androidDriver;
		this.webDriverWait = webDriverWait = new WebDriverWait(this.androidDriver, 10);
		PageFactory.initElements(new AppiumFieldDecorator(this.androidDriver, Duration.ofMillis(10000)), this);
	}

	/*
	 * Scroll to element using Search Text
	 */
	public MobileElement scrollToElementByText(String searchText) {
		MobileElement elementToClick = (MobileElement) androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\""
						+ searchText + "\"));");
		return elementToClick;
	}

	/*
	 * Scroll to element using Search Text
	 */
	public MobileElement scrollViewToElementByText(String searchText) {
		MobileElement elementToClick = (MobileElement) androidDriver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().resourceId(\"search\")).scrollIntoView(new UiSelector().textContains(\""+searchText+"\"));");
		System.out.println("Element To Click : Text >>>> " + elementToClick.getText() + " Element Class: Class >>>>"
				+ elementToClick.getClass());
		return elementToClick;
	}

	/*
	 * Generate random number
	 */
	public int getRandomNumberInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, (max + 1)).findFirst().getAsInt();
	}
}