package com.qa.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrdersPage {
	private WebDriver driver;

	// 1. By Locators
	private By filterButton = By.xpath("//span[contains(text(),'Filter')]");
	private By customerDropdown = By.xpath("//select[@name='customer_id']");
	private By searchBtn = By.xpath("//button[@class='btn btn-info submit btn-sm']");
	private By orderTable = By.xpath("//table[@class='table table-hover grid-table']");
	

	// 2. Constructor of the page class:
	public OrdersPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getOrdersPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		//System.out.println("****Title of the current page: "+driver.getTitle());
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(orderTable));
		return driver.getTitle();
	}
	
	public void clickOnFilter(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(orderTable));
		driver.findElement(filterButton).click();
		System.out.println("Filter button clicked");
		
	}
	public void selectCustomer(String customerId) throws InterruptedException {
		//System.out.println("customerId as passed from feature file:"+customerId);
		//select customer Saran
		Thread.sleep(2000);
		Select select=new Select(driver.findElement(customerDropdown));
		select.selectByVisibleText(customerId);
		
	}
	
	public Boolean searchCustomer(String customerId) throws InterruptedException {

		Boolean searchStatus=false;
		
		//search button clicked
		driver.findElement(searchBtn).click();

		// To locate table.
		WebElement OrdersListTable = driver.findElement(orderTable);

		// To locate rows of table.
		List<WebElement> rows_table = OrdersListTable.findElements(By.tagName("tr"));

		// To calculate no of rows In table.
		int rows_count = rows_table.size();
		//System.out.println("rows_count::" + rows_count);

		// Loop will execute for all the rows of the table
		for (int row = 0; row < rows_count; row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			// To calculate no of columns(cells) In that specific row.
			int columns_count = Columns_row.size();
			//System.out.println("Number of cells In Row " + row + " are " + columns_count);

			if (columns_count > 1) {
				String customerIdCol = Columns_row.get(5).getText();
				 System.out.println("customerId name: "+customerIdCol);

				if (customerIdCol.equalsIgnoreCase(customerId)) {
					System.out.println("Search result matched for customer id "+customerId);
					searchStatus=true;
					break;
				}
				else
				{
					System.out.println("Search is unsuccessful");
					searchStatus=false;
				}
			} else {
				System.out.println("Search result not matched:: No Records found");
				searchStatus=false;
			}

		}//for
		Thread.sleep(2000);
		return searchStatus;
	}


	
}
