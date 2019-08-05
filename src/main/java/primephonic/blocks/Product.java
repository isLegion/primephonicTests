package primephonic.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import primephonic.webelements.ExtendedMineWebElement;
import primephonic.webelements.MineWebElement;

public interface Product extends ExtendedMineWebElement {

    @Description("Add to cart button")
    @FindBy(".//a[contains(@class, 'ajax_add_to_cart_button')]")
    MineWebElement addToCartButton();

    @Description("Product name")
    @FindBy(".//a[@class='product-name']")
    MineWebElement productName();

    @Description("Product price")
    @FindBy(".//div[@class='right-block']//span[contains(@class,'product-price')]")
    MineWebElement productPrice();

    @Description("Product img")
    @FindBy(".//img[contains(@class,'img-responsive')]")
    MineWebElement productImg();
}
