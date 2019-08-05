package primephonic.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import primephonic.blocks.PersonalInformationBlock;
import primephonic.blocks.YourAddressBlock;
import primephonic.data.User;
import primephonic.pages.AuthenticationPage;
import primephonic.pages.MainPage;
import primephonic.pages.PageFactory;
import primephonic.pages.RegistrationPage;

import java.util.List;

import static io.qameta.htmlelements.matcher.DisplayedMatcher.displayed;
import static io.qameta.htmlelements.matcher.HasTextMatcher.hasText;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

public class RegisterAccountSteps {

    private RegistrationPage registrationPage;
    private AuthenticationPage authenticationPage;

    public RegisterAccountSteps (WebDriver webDriver){

        PageFactory pageFactory = new PageFactory(webDriver);
        registrationPage =  pageFactory.on(RegistrationPage.class);
        authenticationPage = pageFactory.on(AuthenticationPage.class);
    }


    public RegisterAccountSteps fillEmailAndCreateAccount(String email){
        authenticationPage.emailCreateAccount().waitUntil(displayed()).clearAndSendKeys(email);
        authenticationPage.createAnAccountButton().waitUntil(displayed()).click();
        return this;
    }

    public RegisterAccountSteps checkErrorMessageForIncorrectEmail(){
        authenticationPage.createAccountAlert().waitUntil(displayed()).should(hasText("Invalid email address."));
        return this;
    }

    public RegisterAccountSteps checkNoErrorMessageForIncorrectEmail(){
        authenticationPage.createAccountAlert().should(not(displayed()));
        return this;
    }

    public RegisterAccountSteps checkRegistrationPageIsDisplayed(){
        registrationPage.personalInformationBlock().waitUntil(displayed());
        registrationPage.yourAddressBlock().waitUntil(displayed());
        return this;
    }

    public RegisterAccountSteps fillAllUsersFields(User user){
        PersonalInformationBlock personalInformationBlock = registrationPage.personalInformationBlock();
        personalInformationBlock.inputFirstName().waitUntil(displayed()).clearAndSendKeys(user.getFirstName());
        personalInformationBlock.inputLastName().waitUntil(displayed()).clearAndSendKeys(user.getLastName());
        personalInformationBlock.inputPassword().waitUntil(displayed()).clearAndSendKeys(user.getPassword());
        personalInformationBlock.inputEmail().waitUntil(displayed()).clearAndSendKeys(user.getEmail());
        personalInformationBlock.gender(user.getGender().toString()).waitUntil(displayed()).click();
        personalInformationBlock.selectDay().selectValue(Integer.toString(user.getBirthDate().getDay()));
        personalInformationBlock.selectMonth().selectValue(Integer.toString(user.getBirthDate().getMonth()));
        personalInformationBlock.selectYear().selectValue(Integer.toString(user.getBirthDate().getYear()));


        YourAddressBlock yourAddressBlock = registrationPage.yourAddressBlock();
        yourAddressBlock.address1().waitUntil(displayed()).clearAndSendKeys(user.getAddress());
        yourAddressBlock.address2().waitUntil(displayed()).clearAndSendKeys(user.getAddress2());
        yourAddressBlock.city().waitUntil(displayed()).clearAndSendKeys(user.getCity());
        yourAddressBlock.company().waitUntil(displayed()).clearAndSendKeys(user.getCompany());
        yourAddressBlock.selectState().selectValue(user.getState());
        yourAddressBlock.postCode().waitUntil(displayed()).clearAndSendKeys(user.getZipCode());
        yourAddressBlock.mobilePhone().waitUntil(displayed()).clearAndSendKeys(user.getMobileNumber());
        yourAddressBlock.homePhone().waitUntil(displayed()).clearAndSendKeys(user.getHomeNumber());
        yourAddressBlock.additionalInformation().waitUntil(displayed()).clearAndSendKeys(user.getAdditionalInformation());
        yourAddressBlock.aliasAddress().waitUntil(displayed()).clearAndSendKeys(user.getAddressAlias());

        return this;
    }

    public RegisterAccountSteps clickRegisterButton() {
        registrationPage.registerButton().waitUntil(displayed()).click();
        return this;
    }

    public RegisterAccountSteps clearEmailField(){
        registrationPage.personalInformationBlock().inputEmail().waitUntil(displayed()).clear();
        return this;
    }

    public RegisterAccountSteps clearAliasField(){
        registrationPage.yourAddressBlock().aliasAddress().waitUntil(displayed()).clear();
        return this;
    }

    public void checkAccountPageIsOpened(){
        registrationPage.welcomeMessage().should(displayed());
    }

    public RegisterAccountSteps checkRegistrationErrorMessages(List<String> expectedErrorMessages){
        registrationPage.errorMessages()
                .waitUntil(not(empty()))
                .convert(WebElement::getText)
                .should(containsInAnyOrder(expectedErrorMessages.toArray()));
        return this;
    }



}
