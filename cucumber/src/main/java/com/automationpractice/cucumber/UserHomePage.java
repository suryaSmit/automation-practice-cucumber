package com.automationpractice.cucumber;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sun.tools.javadoc.JavaScriptScanner;

public class UserHomePage extends BaseClass {
	WebDriver driver;
	Actions action;

	public UserHomePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = "logout")
	private WebElement signoutButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Women']")
	private WebElement womenLink;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']//div//span[contains(text(),'$16.51')]/ancestor::li")
	private WebElement firstItem;

	@FindBy(how = How.XPATH, using = "(//div[@id='subcategories']/following-sibling::ul//span[contains(text(),'$16.51')])[2]")
	private WebElement firstItemText;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']//div//span[contains(text(),'$16.51')]//parent::div[@class='content_price']//following-sibling::div[@class='button-container']//span[text()='Add to cart']")
	private WebElement firstItemAddToCart;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']//div//span[contains(text(),'$27.00')]/ancestor::li")
	private WebElement secondItem;

	@FindBy(how = How.XPATH, using = "(//div[@id='subcategories']/following-sibling::ul//span[contains(text(),'$27.00')])[1]")
	private WebElement secondItemText;

	@FindBy(how = How.XPATH, using = "//div[@id='center_column']//div//span[contains(text(),'$27.00')]//parent::div[@class='content_price']//following-sibling::div[@class='button-container']//span[text()='Add to cart']")
	private WebElement secondItemAddToCart;

	@FindBy(how = How.XPATH, using = "//div[@class='button-container']/span")
	private WebElement continueShopping;

	@FindBy(how = How.XPATH, using = "//div[@class='button-container']/a")
	private WebElement proceedToCheckout;

	
	//user actions
	public void clickSignoutButton() {
		this.signoutButton.click();
	}

	public void clickWomenLink() {
		this.womenLink.click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
	}

	public void addFirstItemToCart() {
		action.moveToElement(firstItem).build().perform();
		action.moveToElement(firstItemAddToCart).click().build().perform();
	}

	public void addSecondItemToCart() {
		action.moveToElement(secondItem).moveToElement(secondItemAddToCart).click().build().perform();
	}

	
	public void clickContinueShopping() {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(continueShopping));
		this.continueShopping.click();
	}
	
	public void clickProceedToCheckout() {
		new WebDriverWait(driver, 15).until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
		this.proceedToCheckout.click();
	}
	
	//validation methods
	public boolean isSignoutButtonDisplayed() {
		return this.signoutButton.isDisplayed();
	}
	
	public double getFirstItemPrice() {
		System.out.println("string value is : "+this.firstItemText.getText());
		double p = Double.valueOf(this.firstItemText.getText().trim().substring(1));
		return p;
	}
	
	public double getSecondItemPrice() {
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(secondItemText));
		System.out.println("string value is : "+this.secondItemText.getText());
		double p = Double.valueOf(this.secondItemText.getText().trim().substring(1));
		System.out.println(p);
		return p;
	}
}
