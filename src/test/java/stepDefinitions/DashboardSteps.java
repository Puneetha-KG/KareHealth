package stepDefinitions;

import org.junit.Assert;

import com.qa.driverFactory.DriverFactory;
import com.qa.pages.DashboardPage;

import io.cucumber.java.en.Then;

public class DashboardSteps {
	
	public String title;
	private DashboardPage dashbaordPage = new DashboardPage(DriverFactory.getDriver());

@Then("user should view dashbaord page with title {string}")
public void user_should_view_dashbaord_page_with_title(String expectedTitle) {
	System.out.println("Inside Step- User gets the title of the Dashboard page");
	title = dashbaordPage.getDashbaordPageTitle();
	System.out.println("Dashboard page actual title is: " + title);
	Assert.assertTrue(title.contains(expectedTitle));
}

@Then("Total Orders panel should be displayed")
public void total_orders_panel_should_be_displayed() {
	Assert.assertTrue(dashbaordPage.isTotalOdersPanelExist());
}

}
