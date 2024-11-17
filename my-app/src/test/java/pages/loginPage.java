package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import stepDefinition.DriverFactory;

public class loginPage {
	
	 WebDriver driver;

	    // Constructor initializes driver using DriverFactory
	    public loginPage() {
	        this.driver = DriverFactory.getDriver(); // Get the driver from the global DriverFactory class
	    }
	
	public void openUrl()
	{
		
    	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
	}

	    public void enterscredentials() {
	        // Use valid credentials (replace with actual test data or parameterize the step if needed)
	    	driver.findElement(By.name("username")).sendKeys("Admin");
	    	driver.findElement(By.name("password")).sendKeys("admin123");

	    }

	    public void enterscredentials(String user,String pass) {
	        // Use valid credentials (replace with actual test data or parameterize the step if needed)
	    	driver.findElement(By.name("username")).sendKeys(user);
	    	driver.findElement(By.name("password")).sendKeys(pass);

	    }
	   
	    public void clicklogin() {
	        driver.findElement(By.xpath("//*[@type='submit']")).click();
	    }

	    public void navigatedtohomepage() {
	    	 String title = driver.getTitle();
	         System.out.println(title);// Verify the page title (to confirm successful login)
	    }

	 
	    public void clickadminbutton() {
	       driver.findElement(By.xpath("//*[text()='Admin']")).click();
	      String value = driver.findElement(By.xpath("//*[text()='System Users']")).getText();
	      System.out.println(value);
	       
	    }
	    
}
