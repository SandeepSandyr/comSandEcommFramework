package com.shoppoint.generic.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginpage {
	
	public AdminLoginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "inputEmail")
	private WebElement usernameTF;
	
	@FindBy(id = "inputPassword")
	private WebElement passwordTF;
	
	@FindBy(name = "submit")
	private WebElement submitBtn;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
		 
}

