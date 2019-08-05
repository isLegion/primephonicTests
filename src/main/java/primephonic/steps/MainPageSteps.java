package primephonic.steps;

import org.openqa.selenium.WebDriver;
import primephonic.data.Product;
import primephonic.pages.CartPage;
import primephonic.pages.MainPage;
import primephonic.pages.PageFactory;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;

public class MainPageSteps {

    private MainPage mainPage;
    private RegisterAccountSteps registerAccountSteps;
    private ShoppingCartSteps shoppingCartSteps;



    public MainPageSteps(WebDriver webDriver){
        PageFactory pageFactory = new PageFactory(webDriver);
        mainPage =  pageFactory.on(MainPage.class);
        shoppingCartSteps = new ShoppingCartSteps(webDriver);
        registerAccountSteps = new RegisterAccountSteps(webDriver);

    }


    public MainPageSteps openMainPage(){
        mainPage.open("http://automationpractice.com");
        mainPage.shoppingCartButton().waitUntil(displayed());
        return this;
    }

    public RegisterAccountSteps openAuthenticationPage(){
        mainPage.signInButton().waitUntil(displayed()).click();
        return registerAccountSteps;
    }

    public Product addProductToCartByNmb(int nmb){
        primephonic.blocks.Product product = mainPage.products().get(nmb - 1);
        product.waitUntil(displayed());

        String name =product.productName().getText();
        String price = product.productPrice().getText();
        String img = product.productImg().getAttribute("src");

        product.hover();
        product.addToCartButton().waitUntil(displayed()).click();
        mainPage.closeLayerCartButton().waitUntil(displayed()).click();
        return Product.builder().avail("In stock").img(img).name(name).price(price).build();
    }

    public ShoppingCartSteps goToShoppingCart(){
        mainPage.shoppingCartButton().waitUntil(displayed()).click();
        return shoppingCartSteps;
    }

    public ShoppingCartSteps proceedToCheckout(){
        mainPage.proceedToCheckoutBtn().waitUntil(displayed()).click();
        return shoppingCartSteps;
    }

    public MainPageSteps goToMainPage() {
        mainPage.logo().waitUntil(displayed()).click();
        return this;
    }


}
