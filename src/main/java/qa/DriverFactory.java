package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.nio.charset.MalformedInputException;

import static java.sql.DriverManager.getDriver;

public class DriverFactory {

    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public DriverFactory() throws MalformedInputException {

    }

    public WebDriver initDriver(String browserName){
        switch (browserName.toLowerCase()){
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("-headless");
                tlDriver.set(new ChromeDriver(chromeOptions));
//                tlDriver.set(new ChromeDriver());
                break;

            case "firefox":
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                firefoxOptions.addArguments("--headless");
//                tlDriver.set(new FirefoxDriver(firefoxOptions));
                tlDriver.set(new FirefoxDriver());
                break;

            case "safari":
                tlDriver.set(new SafariDriver());
                break;

            default:
                tlDriver.set(new ChromeDriver());
                break;
        }
        System.out.println("DriverFactory: "+ browserName);
        return tlDriver.get();
    }


}
