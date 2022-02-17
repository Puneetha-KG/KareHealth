package stepDefinitions;

import org.junit.Assert;

import com.qa.driverFactory.DriverFactory;
import com.qa.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	public String title;
	private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	
	@Given("browser is launched with url {string} and user is on login page")
	public void browser_is_launched_with_url_and_user_is_on_login_page(String url) {
		System.out.println("Inside Step- User is on login page");
		  DriverFactory.getDriver()
			.get(url);
	}

	@When("user enters username as {string} and password {string}")
	public void user_enters_username_as_and_password(String userName, String password) {
		System.out.println("Inside Step- User enters username and password");
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@When("clicks on login button")
	public void clicks_on_login_button() {
		System.out.println("Inside Step- User clicks login button");
		loginPage.clickOnLogin();
	}

	@Then("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		//System.out.println("Inside Step- User gets the title of the home page");
		title = loginPage.getLoginPageTitle().trim();
		System.out.println("Page title is: " + title);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitleName) {
		System.out.println("Inside Step- page title of page is "+expectedTitleName);
		Assert.assertTrue(title.contains(expectedTitleName));
	}

}
