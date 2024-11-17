package stepDefinition;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;

public class DriverFactory {

    public static WebDriver driver; // Declare the WebDriver globally

    // Hook to initialize WebDriver before each scenario
    @Before
    public void setUp() {
    	
        System.setProperty("webdriver.edge.driver", "./drivers/msedgedriver.exe");
        driver = new EdgeDriver(); // Create a new EdgeDriver instance
        driver.manage().window().maximize(); // Maximize the window
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS); // Set timeout
        
       
    }
    // Hook to clean up WebDriver after each scenario
    @After
    public void tearDown(Scenario scenario) {
        if (driver != null) {
            // Check if the scenario has failed
            if (scenario.isFailed()) {
                try {
                    // Take screenshot on failure
                    takeScreenshot(scenario);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // Quit the driver after the test
            driver.quit();
        }
    }

    // Method to get WebDriver instance
    public static WebDriver getDriver() {
        return driver;
    }
    
    private void takeScreenshot(Scenario scenario) throws IOException {
        // Ensure the screenshots directory exists
        Files.createDirectories(Paths.get("target/screenshots"));

        // Capture screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Define screenshot file path
        String screenshotPath = "target/screenshots/" + scenario.getName() + ".png";

        // Copy the screenshot to the target location
        Files.copy(screenshot.toPath(), Paths.get(screenshotPath));

        // Attach the screenshot to the scenario report
        byte[] screenshotBytes = Files.readAllBytes(Paths.get(screenshotPath));
        scenario.attach(screenshotBytes, "image/png", scenario.getName());
    }
}
