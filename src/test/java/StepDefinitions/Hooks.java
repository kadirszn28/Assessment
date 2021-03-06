package StepDefinitions;

import Utils.BrowserUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void setup(Scenario scenario) {
        System.out.println(scenario.getName());
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("This one will run after each scenario");
        // After annotation will execute after each scenario even though they are failed, undefined
        if (scenario.isFailed()) {
            System.out.println("failed");
            BrowserUtils.takeScreenShot();
        }
    }
}
