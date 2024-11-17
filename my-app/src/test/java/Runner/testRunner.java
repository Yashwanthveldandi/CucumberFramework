package Runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = {"src/test/resources/Feature"},  // path to your feature files
    glue = {"stepDefinition"},  // path to your step definition classes
    plugin = {"pretty", "html:target/cucumber-report.html"},  // Static file name, actual path will be modified at runtime
    monochrome = true,
    tags = "@Smoke"  // filter by tags
)
public class testRunner extends AbstractTestNGCucumberTests {
	 
	
}
