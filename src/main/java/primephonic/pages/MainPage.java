package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import primephonic.blocks.Product;
import primephonic.blocks.WithLogo;
import primephonic.webelements.MineWebElement;

public interface MainPage extends WebPage, WithLogo {

    @Description("Sign In button")
    @FindBy("//a[@class='login']")
    MineWebElement signInButton();

    @Description("Shopping Cart button")
    @FindBy("//div[@class='shopping_cart']/a")
    MineWebElement shoppingCartButton();

    @Description("Products")
    @FindBy("//ul[contains(@class, 'product_list') and contains(@class, 'active')]/li")
    ExtendedList<Product> products();

    @Description("Close cart layer button")
    @FindBy("//div[contains(@class, 'layer_cart')]//span[@class='cross']")
    MineWebElement closeLayerCartButton();

    @Description("Close cart layer button")
    @FindBy("//div[contains(@class, 'layer_cart')]//a[contains(@class, 'button-medium')]")
    MineWebElement proceedToCheckoutBtn();
}
