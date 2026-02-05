package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import qa.DriverFactory;

import java.nio.charset.MalformedInputException;

public class Hooks {

//    private DriverFactory driverFactory;
    private WebDriver driver;

    @Parameters("browserName")
    @BeforeTest
    public void initializeBrowser(String browserName) throws MalformedInputException {
//        driverFactory = new DriverFactory();
//        driver = DriverFactory.initDriver(browserName);
        driver.navigate().to("https://www.premierleague.com/stats");
        System.out.println("TestNg browser: " + browserName);
        System.out.println("Hooks - setUp");
    }

    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
