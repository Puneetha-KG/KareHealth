package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.driverFactory.DriverFactory;
import com.qa.pages.DashboardPage;
import com.qa.pages.LoginPage;
import com.qa.pages.OrdersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OdersSteps {
	
	public String title;
	public String customerId;
	public Boolean searchStatus=false;
	private DashboardPage dashboardPage = new DashboardPage(DriverFactory.getDriver());
	private OrdersPage ordersPage = new OrdersPage(DriverFactory.getDriver());
	
	@Given("user is on Dashbaord page")
	public void user_is_on_dashbaord_page() {
	    
	}

	@When("user clicks on Total Orders panel")
	public void user_clicks_on_total_orders_panel() throws InterruptedException {
		dashboardPage.clickOnTotalOdersPanel();
	}

	@Then("user should view Orders page with title {string}")
	public void user_should_view_orders_page_with_title(String expectedTitle) throws InterruptedException {
		//System.out.println("Inside Step- User gets the title of the Orders page");
		title = ordersPage.getOrdersPageTitle();
		System.out.println("orders page actual title matched with expected title : " + title);
		Assert.assertTrue(title.contains(expectedTitle));
	}
	
	@Given("user is on Orders page with title {string}")
	public void user_is_on_orders_page_with_title(String expectedTitle) throws InterruptedException {
		dashboardPage.clickOnTotalOdersPanel();
		title = ordersPage.getOrdersPageTitle();
		//System.out.println("orders page actual title matched with expected title : " + title);
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@When("user clicks on Filter button")
	public void user_clicks_on_filter_button() {
		ordersPage.clickOnFilter();
	}

	@When("selects customer as {string}")
	public void selects_customer_as(String customer) throws InterruptedException {
		customerId=customer;
	   ordersPage.selectCustomer(customer);
	}

	@When("clicks on Search")
	public void clicks_on_search() throws InterruptedException {
		searchStatus= ordersPage.searchCustomer(customerId);
	}

	@Then("Order with selected customer should be listed")
	public void order_with_selected_customer_should_be_listed() {
		Assert.assertTrue(searchStatus);
		System.out.println("Search is sucessfull "+customerId+" present in orders table");
	}


}
