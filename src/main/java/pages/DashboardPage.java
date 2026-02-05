package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DashboardPage extends Config_BasePage {

    public DashboardPage(WebDriver driver) {
       super(driver);
       System.out.println("Driver inside DashboardPage constructor: " + driver);
    }

    @FindBy(xpath = "//span[@class='stats-leaderboard__header']")
    private List<WebElement> statsCategories;

    @FindBy(xpath = "//h2[@data-testid='widgetHeaderTitle'][1]")
    private WebElement headTitle;


    public String getCurrentUrl() {
        System.out.println("PAGE URL: "+ driver.getCurrentUrl() );
        return driver.getCurrentUrl();
    }

    public String getCategoryByIndex(int index){
        return statsCategories.get(index).getText();
    }

    public String getTitle(){
        System.out.println("Title: "+ driver.getTitle());
        return driver.getTitle();
    }

    public int getCategoriesCount() {
        return statsCategories.size();
    }

    public boolean theStatisticsDashboardIsDisplayed(){
        return headTitle.isDisplayed();
    }

    public boolean lookForCategory(String category) {
        for (int i = 0; i < getCategoriesCount(); i++) {
            String currentCategory = getCategoryByIndex(i);
            if (category.equals(currentCategory)) {
                System.out.println("Category: " + currentCategory);
                return true;
            }
        }
        return false;
    }

    public boolean theDashboardShouldShowTheAssistsCategory(){
        return lookForCategory("Assists");
    }

    public boolean theDashboardShouldShowTheTotalPassesCategory(){
        return lookForCategory("Total Passes");
    }

    public boolean theDashboardShouldShowTheGoalsCategory(){
        return lookForCategory("Goals");
    }

    public boolean theDashboardShouldShowTheCleanSheetsCategory(){
        return lookForCategory("Clean Sheets");
    }
}
