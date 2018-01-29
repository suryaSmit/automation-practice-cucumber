package com.automationpractice.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID, using="email")
	private WebElement username;
	
	@FindBy(how=How.ID, using="passwd")
	private WebElement password;
	
	@FindBy(how=How.ID, using="SubmitLogin")
	private WebElement submitButton;
	
	public void enterUserName(String username) {
		this.username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}
	
	public void clickSubmitButton() {
		this.submitButton.click();
	}
	
	
	public void login(String username, String password) {
		this.enterUserName(username);
		this.enterPassword(password);
		this.clickSubmitButton();
	}
	
	
}
