package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedWebElement;
import primephonic.webelements.MineWebElement;

public interface AuthenticationPage extends WebPage {

    @Description("Email in Create Account blocks")
    @FindBy("//form[@id='create-account_form']//input[@id='email_create']")
    MineWebElement emailCreateAccount();

    @Description("Create an account button")
    @FindBy("//form[@id='create-account_form']//button[@id='SubmitCreate']")
    MineWebElement createAnAccountButton();

    @Description("Create account alert")
    @FindBy("//form[@id='create-account_form']//div[@id='create_account_error']//li")
    MineWebElement createAccountAlert();
}

