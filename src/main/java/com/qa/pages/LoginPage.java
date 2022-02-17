package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;

	//page locators
	private By userName = By.xpath("//input[@name='username']");
	private By password = By.xpath("//input[@name='password']");
	private By loginButton = By.xpath("//button[contains(text(),'Login')]");
	
	//constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//page actions
	public WebElement getWebElement(By locator)
	{
		return driver.findElement(locator);
	}

	public String getLoginPageTitle() {
		//System.out.println("Title of the current page: "+driver.getTitle());
		return driver.getTitle();
	}

	
	public void enterUserName(String username) {
		System.out.println("username====>"+username);
		getWebElement(userName).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		getWebElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		getWebElement(loginButton).click();
	}

}
