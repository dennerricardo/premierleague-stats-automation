package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/features"},

        glue = {"stepdefinitions", "hooks"},

        dryRun = false,


        plugin = { "pretty",
             "html:target/HTMLReports/cucumber.html",
             "json:target/JsonReports/cucumber.json",
            }
)

public class TestRunner extends AbstractTestNGCucumberTests{



}
