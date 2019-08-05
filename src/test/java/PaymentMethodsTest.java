import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import primephonic.TestUtil;
import primephonic.data.User;
import primephonic.steps.BaseTest;
import primephonic.steps.MainPageSteps;

import static primephonic.TestUtil.getRandomEmail;

@DisplayName("Payment methods and order history tests")
public class PaymentMethodsTest extends BaseTest {

    private MainPageSteps mainPageSteps;

    @BeforeEach
    void setupPages() {
        mainPageSteps = new MainPageSteps(getDriver());
        User user = TestUtil.generateUserWithAllFields();
        mainPageSteps
                .openMainPage()
                .openAuthenticationPage()
                .fillEmailAndCreateAccount(getRandomEmail())
                .fillAllUsersFields(user)
                .clickRegisterButton()
                .checkAccountPageIsOpened();
        mainPageSteps
                .openMainPage()
                .addProductToCartByNmb(2);

    }

    @Test
    @DisplayName("Checking correct working of bank wire method and order appearance in 'Order History' page")
    public void checkoutProductWithWireBankMethodTest(){

        mainPageSteps
                .goToShoppingCart()
                .clickProceedToCheckout()
                .checkDeliveryAddressDisplayed()
                .clickProceedToCheckout()
                .agreeTermsOfService()
                .goToPaymentOptions()
                .chooseBankWireMethod()
                .confirmMyOrder()
                .checkOrderConfirmationBankWire()
                .backToOrders()
                .checkFirstItemDisplayed("Bank wire");
    }

    @Test
    @DisplayName("Checking correct working of check method and order appearance in 'Order History' page")
    public void checkoutProductWithCheckMethodTest(){

        mainPageSteps
                .goToShoppingCart()
                .clickProceedToCheckout()
                .checkDeliveryAddressDisplayed()
                .clickProceedToCheckout()
                .agreeTermsOfService()
                .goToPaymentOptions()
                .chooseCheckMethod()
                .confirmMyOrder()
                .checkOrderConfirmationCheckMethod()
                .backToOrders()
                .checkFirstItemDisplayed("Payment by check");
    }


}
