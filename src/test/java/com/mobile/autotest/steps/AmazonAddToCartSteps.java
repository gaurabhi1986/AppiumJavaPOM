package com.mobile.autotest.steps;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import com.mobile.autotest.pages.PasswordScreenPage;
import com.mobile.autotest.pages.ProductCartScreenPage;
import com.mobile.autotest.pages.ProductDetailsScreenPage;
import com.mobile.autotest.pages.ProductsListScreenPage;
import com.mobile.autotest.pages.SearchScreenPage;
import com.mobile.autotest.pages.SignInScreenPage;
import com.mobile.autotest.pages.WelcomeScreenPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class AmazonAddToCartSteps {

	Properties configProp = new Hooks().getProperties();
	SignInScreenPage homeScreen;
	WelcomeScreenPage welcomeScreen;
	PasswordScreenPage passwordScreen;
	SearchScreenPage searchScreen;
	ProductsListScreenPage productsListScreen;
	ProductDetailsScreenPage productDetailsScreen;
	ProductCartScreenPage productCartScreen;
	String productDescOnDetailsScreen;
	String productPriceOnDetailsScreen;
	String productDescOnCartScreen;
	String productPriceOnCartScreen;
	AndroidDriver androidDriver;
	

	@Given("^user in search page$")
	public void user_in_search_page() throws Throwable {
		Hooks hooks = new Hooks();
		androidDriver = hooks.getDriver();
		homeScreen = new SignInScreenPage(androidDriver);
		homeScreen.waitForHomecreen();
		homeScreen.clickSignInButton();

		welcomeScreen = new WelcomeScreenPage(androidDriver);
		welcomeScreen.waitForWelcomeScreen();
		welcomeScreen.enterEmailAddress(configProp.getProperty("amazon.user")); // test1234 // telstra2020 //// telstra.test2020@gmail.com
		welcomeScreen.clickContinueBtn();

		passwordScreen = new PasswordScreenPage(androidDriver);
		passwordScreen.waitForPasswordScreen();
		passwordScreen.enterPassword(configProp.getProperty("amazon.password"));
		passwordScreen.clickSignIn();

		searchScreen = new SearchScreenPage(androidDriver);
		searchScreen.waitForSearchScreen();
	}

	@When("^user search \"([^\"]*)\"$")
	public void user_search(String searchCriteria) throws Throwable {
		searchScreen.searchForProducts(searchCriteria);
	}

	@Then("^user see the list of products$")
	public void user_see_the_list_of_products() throws Throwable {
		productsListScreen = new ProductsListScreenPage(androidDriver);
		productsListScreen.waitForProductsListScreen();
	}

	@When("^user click any product$")
	public void user_click_any_product() throws Throwable {
		productsListScreen.selectRandomProductByText(configProp.getProperty("amazon.productName"));
	}

	@Then("^user navigate to product details page$")
	public void user_navigate_to_product_details_page() throws Throwable {
		productDetailsScreen = new ProductDetailsScreenPage(androidDriver);
		productDetailsScreen.waitForProductsDetailsScreen();
		productDescOnDetailsScreen = productDetailsScreen.getProductDescription();
		assertTrue("Incorrect Product Name", productDescOnDetailsScreen.contains(configProp.getProperty("amazon.productName")));
		productPriceOnDetailsScreen = productDetailsScreen.getProductPrice();
	}

	@When("^user add a product to cart$")
	public void user_add_a_product_to_cart() throws Throwable {
		productDetailsScreen.addProductToCart("Add to Cart");
		//assertTrue("Incorrect Product Count in the cart", productDetailsScreen.getTotalCartCount().equals("1"));
		productDetailsScreen.clickCartIcon();
	}

	@Then("^product should be added to cart$")
	public void product_should_be_added_to_cart() throws Throwable {
		productCartScreen = new ProductCartScreenPage(androidDriver);
		productCartScreen.waitForProductCartScreen();
		productDescOnCartScreen = productCartScreen.getProductDescription();
		productPriceOnCartScreen = productCartScreen.getProductPrice();
		
		if(productDescOnCartScreen.contains(".")) {
			productDescOnCartScreen = productDescOnCartScreen.replace(".", " ").trim();
		}
		// Validate Product Descript and Price on Cart Page
		assertTrue("Incorrect Product Description", productDescOnDetailsScreen.contains(productDescOnCartScreen));
		assertTrue("Incorrect Product Price", productPriceOnDetailsScreen.trim().equals(productPriceOnCartScreen.trim()));
	}

}
