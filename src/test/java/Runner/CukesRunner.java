package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/com.Victoria'sSecret/CheckoutFlow.feature"},
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = false
)
public class CukesRunner {

}
