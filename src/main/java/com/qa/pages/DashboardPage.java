package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	private WebDriver driver;

	// 1. By Locators
	private By total_orders_panel = By.xpath("//p[contains(text(),'Total Orders')]");

	// 2. Constructor of the page class:
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	// 3. page actions: features(behavior) of the page the form of methods:

	public String getDashbaordPageTitle() {
		//System.out.println("Title of the current page: "+driver.getTitle());
		return driver.getTitle();
	}

	public boolean isTotalOdersPanelExist() {
		return driver.findElement(total_orders_panel).isDisplayed();
	}
	
	public void clickOnTotalOdersPanel()  {
		driver.findElement(total_orders_panel).click();
		System.out.println("Am in orders page");
		
	}
}