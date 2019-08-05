package primephonic.steps;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    private static WebDriver webDriver;

    protected WebDriver getDriver() {
        if(webDriver == null) {
            throw new WebDriverException();
        }
        return webDriver;
    }

    @BeforeAll
    public static void setWebDriver(){
        webDriver = new ChromeDriver();
    }

    @AfterAll
    public static void closeWebDriver(){
        webDriver.quit();
    }

}
