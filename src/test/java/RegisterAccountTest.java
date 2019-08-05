
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import primephonic.data.BirthDate;
import primephonic.data.Gender;
import primephonic.data.Messages;
import primephonic.data.User;
import primephonic.steps.BaseTest;
import primephonic.TestUtil;
import primephonic.steps.MainPageSteps;

import java.util.List;
import java.util.stream.Stream;

import static primephonic.TestUtil.*;
import static primephonic.TestUtil.getRandomWordWithNmb;

@DisplayName("Registration account tests")
public class RegisterAccountTest extends BaseTest {

    private MainPageSteps mainPageSteps;

    @BeforeEach
    void setupPages(){
        mainPageSteps = new MainPageSteps(getDriver());
    }

    @Test
    @DisplayName("Check email on authentication page test")
    public void validateEmailOnAuthenticationPageTest(){
        mainPageSteps
                .openMainPage()
                .openAuthenticationPage()
                .fillEmailAndCreateAccount("hhjh@mail")
                .checkErrorMessageForIncorrectEmail()
                .fillEmailAndCreateAccount("1232№mail.com")
                .checkErrorMessageForIncorrectEmail()
                .fillEmailAndCreateAccount("fgfgfgf@mail,com")
                .checkErrorMessageForIncorrectEmail()
                .fillEmailAndCreateAccount("@^*@£(£@")
                .checkErrorMessageForIncorrectEmail()
                .fillEmailAndCreateAccount(getRandomEmail())
                .checkNoErrorMessageForIncorrectEmail();
    }


    @DisplayName("Checking filling only required fields for account")
    @Test
    public void validateCorrectFillRequiredFields(){
        User user = TestUtil.generateUserWithAllFields();
        mainPageSteps
                .openMainPage()
                .openAuthenticationPage()
                .fillEmailAndCreateAccount(getRandomEmail())
                .fillAllUsersFields(user)
                .clickRegisterButton()
                .checkAccountPageIsOpened();
    }

    @Test
    @DisplayName("Checking error messages for creating account with empty fields")
    public void validateEmptyFieldsForRegistration(){
        mainPageSteps
                .openMainPage()
                .openAuthenticationPage()
                .fillEmailAndCreateAccount(getRandomEmail())
                .clearAliasField()
                .clearEmailField()
                .clickRegisterButton()
                .checkRegistrationErrorMessages(Messages.getAllRequiredMessages());
    }

    @Test
    @DisplayName("Checking error messages with incorrect filling fields for account")
    @ParameterizedTest()
    @MethodSource("userProvider")
    public void validateIncorrectFieldsForRegistration(User user, List<String> errorMessages){
        mainPageSteps
                .openMainPage()
                .openAuthenticationPage()
                .fillEmailAndCreateAccount(getRandomEmail())
                .fillAllUsersFields(user)
                .clickRegisterButton()
                .checkRegistrationErrorMessages(errorMessages);
    }

    private static Stream<Arguments> userProvider() {
        String randomNmb = getRandomWordWithNmb();
        User userWithNmbFields =  User.builder()
                .firstName(randomNmb)
                .lastName(randomNmb)
                .gender(Gender.FEMALE)
                .password(randomNmb)
                .email(randomNmb)
                .birthDate(BirthDate.builder().day(getRandomNumber(1, 29)).month(getRandomNumber(1, 12)).year(getRandomNumber(1900, 2019)).build())
                .address(randomNmb)
                .address2(randomNmb)
                .company(randomNmb)
                .state(Integer.toString(getRandomNumber(1, 50)))
                .city(randomNmb)
                .zipCode(randomNmb)
                .mobileNumber(randomNmb)
                .homeNumber(randomNmb)
                .additionalInformation(randomNmb)
                .addressAlias(randomNmb)
                .build();

        String randomLongWord = getRandomWordAnyLength(33);
        User userWithLongFields =  User.builder()
                .firstName(randomLongWord)
                .lastName(randomLongWord)
                .gender(Gender.FEMALE)
                .password(randomLongWord)
                .email(randomLongWord)
                .birthDate(BirthDate.builder().day(getRandomNumber(1, 29)).month(getRandomNumber(1, 12)).year(getRandomNumber(1900, 2019)).build())
                .address(randomLongWord)
                .address2(randomLongWord)
                .company(randomLongWord)
                .state(Integer.toString(getRandomNumber(1, 50)))
                .city(randomLongWord)
                .zipCode(getRandomWordAnyLength(13))
                .mobileNumber("111111111111111111111111111111111")
                .homeNumber("111111111111111111111111111111111")
                .additionalInformation(getRandomWordAnyLength(200))
                .addressAlias(randomLongWord)
                .build();


        String randomWordWithSymbols = getRandomSimpleWord() + "£^%^&*()_&^%";

        User userWithSymbolsFields =  User.builder()
                .firstName(randomWordWithSymbols)
                .lastName(randomWordWithSymbols)
                .gender(Gender.FEMALE)
                .password(randomWordWithSymbols)
                .email(randomWordWithSymbols)
                .birthDate(BirthDate.builder().day(getRandomNumber(1, 29)).month(getRandomNumber(1, 12)).year(getRandomNumber(1900, 2019)).build())
                .address(randomWordWithSymbols)
                .address2(randomWordWithSymbols)
                .company(randomWordWithSymbols)
                .state(Integer.toString(getRandomNumber(1, 50)))
                .city(randomWordWithSymbols)
                .zipCode(randomWordWithSymbols)
                .mobileNumber(randomWordWithSymbols)
                .homeNumber(randomWordWithSymbols)
                .additionalInformation(randomWordWithSymbols)
                .addressAlias(randomWordWithSymbols)
                .build();

        return Stream.of(
                Arguments.of(userWithNmbFields, Messages.getAllMessagesWithNmb()),
                Arguments.of(userWithLongFields, Messages.getAllLongMessages()),
                Arguments.of(userWithSymbolsFields, Messages.getAllMessagesWithIncorrectSymbols())

        );
    }

}
