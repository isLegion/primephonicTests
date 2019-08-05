package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.WebPageFactory;
import org.openqa.selenium.WebDriver;

public class PageFactory {

    protected WebDriver webDriver;

    public PageFactory(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public <T extends WebPage>T on(Class<T> webpage){
        WebPageFactory webPageFactory = new WebPageFactory();
        return webPageFactory.get(webDriver, webpage);
    }

    public WebDriver getDriver() { return webDriver;}


}
