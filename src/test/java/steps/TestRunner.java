package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        stepNotifications = true,
        glue = {"hooks", "steps"},
        plugin = {"json:build/cucumber.json", "pretty", "html:build/result.html"},
        features = "src/test/resources/features"
)
public class TestRunner {
}

