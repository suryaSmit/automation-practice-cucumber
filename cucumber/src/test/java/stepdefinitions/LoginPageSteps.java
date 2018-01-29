package stepdefinitions;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import java.text.DecimalFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.automationpractice.cucumber.BaseClass;
import com.automationpractice.cucumber.CartPage;
import com.automationpractice.cucumber.Credentials;
import com.automationpractice.cucumber.HomePage;
import com.automationpractice.cucumber.LoginPage;
import com.automationpractice.cucumber.UserHomePage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPageSteps extends BaseClass {
	LoginPage loginPage;
	HomePage homePage;
	UserHomePage userHomePage;
	CartPage cartPage;
	double expectedTotal = 0;

	@Before("@ui")
	public void setUp() {
		initBrowser();
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		userHomePage = new UserHomePage(driver);
		cartPage = new CartPage(driver);
	}

	@After("@ui")
	public void close() {
		closeBroser();
	}
	
	@Given("^user is in login page$")
	public void user_is_in_login_page() throws Throwable {
		homePage.clickSigninButton();
	}

	@When("^user enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_username_and_password(String arg1, String arg2) throws Throwable {
		loginPage.enterUserName(arg1);
		loginPage.enterPassword(arg2);
	}

	// @When("^user enters username and password$")
	// public void user_enters_username_and_password() throws Throwable {
	// loginPage.enterUserName("temp@tester.com");
	// loginPage.enterPassword("12345");
	// }

	@When("^clicks on login button$")
	public void clicks_on_login_button() throws Throwable {
		loginPage.clickSubmitButton();
	}

	@Then("^user can see related output \"([^\"]*)\"$")
	public void user_can_see_related_output(String arg1) throws Throwable {
		System.out.println(arg1);
	}

	@Then("^user can see user home page$")
	public void user_can_see_user_home_page() throws Throwable {
		assertTrue(homePage.getTitleOfPage().contains("My account"));
	}

	@Then("^user can do logout$")
	public void user_can_do_logout() throws Throwable {
		Assert.assertTrue(userHomePage.isSignoutButtonDisplayed());
		userHomePage.clickSignoutButton();
		// closeBroser();
	}

	@Given("^user is in user home page$")
	public void user_is_in_user_home_page() throws Throwable {
		// user_is_in_login_page();
		// loginPage.enterUserName("temp@tester.com");
		// loginPage.enterPassword("12345");
		// loginPage.clickSubmitButton();
		userHomePage.clickWomenLink();
	}

	@When("^user selects one product and add to cart$")
	public void user_selects_one_product_and_add_to_cart() throws Throwable {
		expectedTotal += userHomePage.getFirstItemPrice();
		userHomePage.addFirstItemToCart();
		userHomePage.clickContinueShopping();
	}

	@When("^user selects second product and add to cart$")
	public void user_selects_second_product_and_add_to_cart() throws Throwable {
		expectedTotal += userHomePage.getSecondItemPrice();
		userHomePage.addSecondItemToCart();
		userHomePage.clickProceedToCheckout();
	}

	@Then("^products must added to cart and diplays order total$")
	public void products_must_added_to_cart_and_diplays_order_total() throws Throwable {
		double total = cartPage.getOrderTotal();
		DecimalFormat df = new DecimalFormat("#.##");
		assertEquals(total, Double.valueOf(df.format(expectedTotal + 2)));
		userHomePage.clickSignoutButton();

	}

	// data table for single step
	@When("^user enter username  password and click on login button$")
	public void user_enter_username_password_and_click_on_login_button(List<Credentials> users) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		for (Credentials user : users) {
			loginPage.login(user.getUsername(), user.getPassword());
		}

	}

	@Then("^user can see user home page with logout link$")
	public void user_can_see_user_home_page_with_logout_link() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	}

}
