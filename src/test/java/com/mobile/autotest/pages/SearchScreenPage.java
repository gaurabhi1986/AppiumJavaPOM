package com.mobile.autotest.pages;

import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SearchScreenPage extends BasePage {

	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/action_bar_burger_icon\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
	private MobileElement hamburgerMenuIcon;

	/// android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.widget.EditText[1]
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/rs_search_src_text\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
	private MobileElement searchBox;

	//// android.widget.FrameLayout[1]/android.widget.ListView[1]
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/iss_search_suggestions_list_view\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_suggestions_list_view")
	private MobileElement searchSuggestionListView;

	//////android.widget.FrameLayout[1]/android.widget.ListView[1]/android.widget.LinearLayout
	@AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions\")")
	@AndroidFindBy(id = "com.amazon.mShop.android.shopping:id/iss_search_dropdown_item_suggestions")
	private List<MobileElement> searchSuggestionListViewItems;

	public SearchScreenPage(AndroidDriver androidDriver) {
		super(androidDriver);
	}

	/*
	 * Wait for Search Screen to display
	 */
	public void waitForSearchScreen() {
		webDriverWait.until(ExpectedConditions.visibilityOf(hamburgerMenuIcon));
	}

	/*
	 * Search Products
	 */
	public void searchForProducts(String searchCriteria) {
		this.searchBox.click();
		this.searchBox.sendKeys(searchCriteria);
		webDriverWait.until(ExpectedConditions.visibilityOf(this.searchSuggestionListView));
		this.searchSuggestionListViewItems.get(2).click();
		//androidDriver.pressKey(new KeyEvent(AndroidKey.ENTER));
	}
}
