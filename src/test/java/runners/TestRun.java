package runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = {"src/test/features/Covid19GameApplication.feature"},
                glue = "stepDefinitions",
                dryRun=false,
                monochrome = true,
                plugin = {"pretty","html:target/cucumber.html","json:target/cucumber.json","pretty:target/cucumber-pretty.txt",
                "usage:target/cucumber-usage.json","junit:cucumber-results.xml"}

        )

public class TestRun {
}
