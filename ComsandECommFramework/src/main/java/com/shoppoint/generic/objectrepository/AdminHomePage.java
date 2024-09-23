package com.shoppoint.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminHomePage {
	
	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@class='collapsed']")
	private WebElement orderManagementLink;
	
	@FindBy(xpath = "//a[@href='todays-orders.php']")
	private WebElement todayOrdersLink;
	
	@FindBy(xpath = "//a[@href='pending-orders.php']")
	private WebElement pendingOrdersLink;
	
	@FindBy(xpath = "//a[@href='delivered-orders.php']")
	private WebElement deliveredOrdersLink;

	public WebElement getOrderManagementLink() {
		return orderManagementLink;
	}

	public WebElement getTodayOrdersLink() {
		return todayOrdersLink;
	}

	public WebElement getPendingOrdersLink() {
		return pendingOrdersLink;
	}

	public WebElement getDeliveredOrdersLink() {
		return deliveredOrdersLink;
	}
	
	

}
