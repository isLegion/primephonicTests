package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import primephonic.webelements.MineWebElement;

public interface CartPage extends WebPage {


    @Description("Product {{ name }} name")
    @FindBy("//p[@class='product-name']/a[text()='{{ name }}']")
    MineWebElement productName(@Param("name") String name);

    @Description("Product {{ name }} image")
    @FindBy("//a[text()='{{ name }}']/ancestor::tr/td[@class='cart_product']//img")
    MineWebElement productImage(@Param("name") String name);

    @Description("Product {{ name }} image")
    @FindBy("//a[text()='{{ name }}']/ancestor::tr/td[@class='cart_avail']//span")
    MineWebElement productAvail(@Param("name") String name);

    @Description("Product {{ name }} unitPrice")
    @FindBy("//a[text()='{{ name }}']/ancestor::tr/td[@class='cart_unit']//span")
    MineWebElement productUnitPrice(@Param("name") String name);

    @Description("Proceed to checkout button")
    @FindBy("//span[text()='Proceed to checkout']")
    MineWebElement checkoutButton();

    @Description("Proceed to checkout to Payment button")
    @FindBy("//span[contains(.,'Proceed to checkout')]/ancestor::button")
    MineWebElement checkoutToPaymentButton();

    @Description("Terms of service agreement")
    @FindBy("//label[text()='I agree to the terms of service and will adhere to them unconditionally.']")
    MineWebElement termsOfService();

    @Description("Address delivery block")
    @FindBy("//ul[@id='address_delivery']")
    MineWebElement addressDeliveryBlock();

    @Description("Delivery option block")
    @FindBy("//div[@class='delivery_options']")
    MineWebElement deliveryOptionBlock();

    @Description("Bank wire method")
    @FindBy("//a[@class='bankwire']")
    MineWebElement bankWireMethod();

    @Description("Check method")
    @FindBy("//a[@class='cheque']")
    MineWebElement checkMethod();

    @Description("Order information Check Method")
    @FindBy("//div[@class='box order-confirmation']/h3[text()='Your check must include:']")
    MineWebElement orderConfirmationCheckMethod();

    @Description("Order information")
    @FindBy("//p[@class='cheque-indent']/strong[text()='Your order on My Store is complete.']")
    MineWebElement orderConfirmationBankWire();

    @Description("Confirm order button")
    @FindBy("//span[text()='I confirm my order']/ancestor::button")
    MineWebElement confirmOrderButton();

    @Description("Back to orders button")
    @FindBy("//a[@title='Back to orders']")
    MineWebElement backToOrdersBtn();
}
