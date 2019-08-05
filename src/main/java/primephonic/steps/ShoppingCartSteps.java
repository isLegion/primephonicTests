package primephonic.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import primephonic.data.Product;
import primephonic.pages.*;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static io.qameta.htmlelements.matcher.HasTextMatcher.hasText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.*;

public class ShoppingCartSteps {

    private CartPage cartPage;
    private OrderHistorySteps orderHistorySteps;

    public ShoppingCartSteps(WebDriver webDriver){
        PageFactory pageFactory = new PageFactory(webDriver);
        cartPage =  pageFactory.on(CartPage.class);
        orderHistorySteps = new OrderHistorySteps(webDriver);

    }

    public ShoppingCartSteps checkProductInTheCart(Product product){
        cartPage.productName(product.getName()).should(hasText(product.getName()));
        String actualImg = cartPage.productImage(product.getName()).getAttribute("src").replace("small", "home");
        Assert.assertThat(actualImg, equalTo(product.getImg()));
        cartPage.productUnitPrice(product.getName()).should(hasText(product.getPrice()));
        cartPage.productAvail(product.getName()).should(hasText(product.getAvail()));
        return this;
    }

    public ShoppingCartSteps clickProceedToCheckout(){
        cartPage.checkoutButton().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps goToPaymentOptions(){
        cartPage.checkoutToPaymentButton().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps agreeTermsOfService() {
        cartPage.deliveryOptionBlock().waitUntil(displayed());
        cartPage.termsOfService().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps checkDeliveryAddressDisplayed(){
        cartPage.addressDeliveryBlock().should(displayed());
        return this;
    }

    public ShoppingCartSteps chooseBankWireMethod(){
        cartPage.bankWireMethod().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps chooseCheckMethod(){
        cartPage.checkMethod().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps confirmMyOrder(){
        cartPage.confirmOrderButton().waitUntil(displayed()).click();
        return this;
    }

    public ShoppingCartSteps checkOrderConfirmationBankWire(){
        cartPage.orderConfirmationBankWire().should(displayed());
        return this;
    }

    public ShoppingCartSteps checkOrderConfirmationCheckMethod(){
        cartPage.orderConfirmationCheckMethod().should(displayed());
        return this;
    }

    public OrderHistorySteps backToOrders(){
        cartPage.backToOrdersBtn().waitUntil(displayed()).click();
        return orderHistorySteps;
    }
}
