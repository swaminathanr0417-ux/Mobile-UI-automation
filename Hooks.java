package hooks;

import base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class Hooks {
    @Before
    public void setup() throws Exception { DriverFactory.initDriver(); }

    @After
    public void teardown(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtils.capture(scenario.getName().replaceAll("[^a-zA-Z0-9_-]", "_"));
        }
        DriverFactory.quitDriver();
    }
}
