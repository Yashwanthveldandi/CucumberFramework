package stepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
public class firstTest {

	 WebDriver driver; // Declare WebDriver variable
	 loginPage login = new loginPage();
	 
	    @Given("user is on login page")
	    public void user_is_on_login_page() {
	    	login.openUrl();

	    }

	    @When("user enters credentials")
	    public void user_enters_credentials() {
	        // Use valid credentials (replace with actual test data or parameterize the step if needed)
	    	login.enterscredentials();

	    }

	    @And("click on login button")
	    public void click_on_login_button() {
	        login.clicklogin();
	    }

	    @When("user is navigated to homepage")
	    public void user_is_navigated_to_homepage() {
	    	login.navigatedtohomepage();
	    	
	    }

	    @Then("user clicks on admin button")
	    public void user_clicks_on_admin_button() {
	      login.clickadminbutton();
	        
	    }
	    
}
