package primephonic.steps;

import org.openqa.selenium.WebDriver;
import primephonic.pages.OrderHistoryPage;
import primephonic.pages.PageFactory;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;

public class OrderHistorySteps {

    private OrderHistoryPage orderHistoryPage;

    public OrderHistorySteps(WebDriver webDriver){
        PageFactory pageFactory = new PageFactory(webDriver);
        orderHistoryPage =  pageFactory.on(OrderHistoryPage.class);
    }


    public OrderHistorySteps checkFirstItemDisplayed(String method){
        orderHistoryPage.firstItem().should(displayed());
        orderHistoryPage.historyMethod().get(0).waitUntil(displayed()).should(hasText(method));
        return this;
    }


}
