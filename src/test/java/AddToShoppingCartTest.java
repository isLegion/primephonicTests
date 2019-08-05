import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import primephonic.data.*;
import primephonic.steps.BaseTest;
import primephonic.steps.MainPageSteps;



@DisplayName("Adding product in shopping cart test")
public class AddToShoppingCartTest extends BaseTest {

    private MainPageSteps mainPageSteps;

    @BeforeEach
    void setupPages() {
        mainPageSteps = new MainPageSteps(getDriver());
    }

    @Test
    @DisplayName("First product successfully was added to the shopping cart")
    public void validateAddProductInCartTest() {
        Product product = mainPageSteps
                .openMainPage()
                .addProductToCartByNmb(1);
        mainPageSteps
                .goToShoppingCart()
                .checkProductInTheCart(product);
    }


}
