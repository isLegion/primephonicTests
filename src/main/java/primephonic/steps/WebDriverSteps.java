package primephonic.steps;

import primephonic.WebDriverProvider;

public class WebDriverSteps {

    protected WebDriverProvider driverProvider;

    public WebDriverSteps(WebDriverProvider driverProvider) {
        this.driverProvider = driverProvider;
    }

    public WebDriverProvider getDriverProvider() {
        return driverProvider;
    }
}
