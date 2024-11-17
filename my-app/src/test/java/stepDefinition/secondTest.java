package stepDefinition;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;

public class secondTest {
	
	 WebDriver driver; // Declare WebDriver variable
	 loginPage login = new loginPage();
	 
	
	
	@Given("user on login page")
	public void user_on_login_page() {
		login.openUrl();
		

	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String username, String password) {
		// Use valid credentials (replace with actual test data or parameterize the step
		// if needed)
		login.enterscredentials(username,password);
		
		
	}

	@And("click login button")
	public void click_login_button() {
		 login.clicklogin();
	}

	@When("user navigated to homepage")
	public void user_navigated_to_homepage() {
		login.navigatedtohomepage();
	}

	@Then("user clicks on admin page")
	public void user_clicks_on_admin_page() {
		  login.clickadminbutton();

	}
}
