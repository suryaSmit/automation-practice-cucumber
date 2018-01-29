package com.automationpractice.cucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.CLASS_NAME, using="login")
	private WebElement signinButton;
	
	public void clickSigninButton() {
		this.signinButton.click();
	}
	
	public String getTitleOfPage() {
		return driver.getTitle();
	}
}
