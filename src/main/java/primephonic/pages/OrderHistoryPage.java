package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import primephonic.blocks.Product;
import primephonic.blocks.WithLogo;
import primephonic.webelements.MineWebElement;

public interface OrderHistoryPage extends WebPage, WithLogo {

    @Description("First Item")
    @FindBy("//tr[contains(@class,'first_item')]")
    MineWebElement firstItem();

    @Description("History price")
    @FindBy("//td[@class='history_price']")
    ExtendedList<MineWebElement> historyPrice();

    @Description("History price")
    @FindBy("//td[@class='history_method']")
    ExtendedList<MineWebElement> historyMethod();

}
