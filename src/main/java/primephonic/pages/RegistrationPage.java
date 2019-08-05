package primephonic.pages;

import io.qameta.htmlelements.WebPage;
import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.element.ExtendedList;
import primephonic.blocks.PersonalInformationBlock;
import primephonic.blocks.WithLogo;
import primephonic.blocks.YourAddressBlock;
import primephonic.webelements.MineWebElement;

public interface RegistrationPage extends WebPage, WithLogo {


    @Description("Personal Information block")
    @FindBy("//h3[contains(.,'Your personal information')]/ancestor::div[@class='account_creation']")
    PersonalInformationBlock personalInformationBlock();

    @Description("Personal Information block")
    @FindBy("//h3[contains(.,'Your address')]/ancestor::div[@class='account_creation']")
    YourAddressBlock yourAddressBlock();

    @Description("Register button")
    @FindBy("//button[@name='submitAccount']")
    MineWebElement registerButton();

    @Description("Welcome message")
    @FindBy("//p[@class = 'info-account' and contains(., 'Welcome to your account. Here you can manage all of your personal information and orders.')]")
    MineWebElement welcomeMessage();

    @Description("Error messages")
    @FindBy("//div[@class = 'alert alert-danger']//li")
    ExtendedList<MineWebElement> errorMessages();

}
