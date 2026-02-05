package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Config_BasePage {
    WebDriver driver;

    public Config_BasePage(WebDriver driver){
        System.out.println("Redirected from hooks to Config_BasePage");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
