
package com.mobile.autotest.steps;

import java.util.Properties;

import com.mobile.autotest.pages.PasswordScreenPage;
import com.mobile.autotest.pages.SearchScreenPage;
import com.mobile.autotest.pages.SignInScreenPage;
import com.mobile.autotest.pages.WelcomeScreenPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class AmazonLoginTestSteps {

	SignInScreenPage homeScreen;
	WelcomeScreenPage welcomeScreen;
	PasswordScreenPage passwordScreen;
	SearchScreenPage searchScreen;
	Properties configProp = new Hooks().getProperties();
	AndroidDriver androidDriver;

	@Given("^User is in Home Screen$")
	public void user_is_in_Home_Screen() throws Throwable {
		Hooks hooks = new Hooks();
		androidDriver = hooks.getDriver();
		homeScreen = new SignInScreenPage(androidDriver);
		homeScreen.waitForHomecreen();
	}

	@When("^user click on Already a customer link$")
	public void user_click_on_Already_a_customer_link() throws Throwable {
		homeScreen.clickSignInButton();
	}

	@Then("^user navigate to Welcome screen$")
	public void user_navigate_to_Welcome_screen() throws Throwable {
		welcomeScreen = new WelcomeScreenPage(androidDriver);
		welcomeScreen.waitForWelcomeScreen();
	}

	@When("^user enter email address$")
	public void user_enter_email_address() throws Throwable {
		welcomeScreen.enterEmailAddress(configProp.getProperty("amazon.user")); // test1234 telstra2020 telstra.test2020@gmail.com
	}

	@When("^click continue button$")
	public void click_continue_button() throws Throwable {
		welcomeScreen.clickContinueBtn();
	}

	@Then("^user navigate to Sign In page$")
	public void user_navigate_to_Sign_In_page() throws Throwable {
		passwordScreen = new PasswordScreenPage(androidDriver);
		passwordScreen.waitForPasswordScreen();
	}

	@When("^user enter password$")
	public void user_enter_password() throws Throwable {
		passwordScreen.enterPassword(configProp.getProperty("amazon.password"));
	}

	@When("^click Sign-In button$")
	public void click_Sign_In_button() throws Throwable {
		passwordScreen.clickSignIn();
	}

	@Then("^user navigate to search screen$")
	public void user_navigate_to_search_screen() throws Throwable {
		searchScreen = new SearchScreenPage(androidDriver);
		searchScreen.waitForSearchScreen();
	}

}
