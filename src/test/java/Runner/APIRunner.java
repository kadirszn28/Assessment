package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/API/LanguageTest.feature"},
        glue = "StepDefinitions",
        dryRun = false,
        monochrome = false
)
public class APIRunner {

}
