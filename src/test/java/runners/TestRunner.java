package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import qa.DriverFactory;

import java.nio.charset.MalformedInputException;

@CucumberOptions(
        features = {"src/test/resources/features"},

        glue = {"stepdefinitions"},

        dryRun = false,


        plugin = { "pretty",
             "html:target/HTMLReports/cucumber.html",
             "json:target/JsonReports/cucumber.json",
            }
)

public class TestRunner extends AbstractTestNGCucumberTests{

    private DriverFactory driverFactory;
    private WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void initializeBrowser(String browserName) throws MalformedInputException {
        System.out.println("TestNg - Initializing");
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(browserName);
        driver.navigate().to("https://www.premierleague.com/stats");

    }

    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
        System.out.println("TestNg - Driver Quit");
    }

}
