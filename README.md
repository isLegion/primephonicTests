# PrimephonicTests

Using testing tools: **Selenium + htmlelemnts2 (https://github.com/eroshenkoam/htmlelements) + jUnit5 + hamcrest + maven.** 

### Project contains:
1. Five pages : MainPage, AuthenticationPage, CartPage, OrderHistoryPage, RegistrationPage
2. Five step classes where all necessary steps are used for actions in tests
3. Folder 'blocks' which contains blocks in pages
4. Instance of webdriver is in BaseTest

### Patterns in project: 
1. ***Page Object*** - htmlelements easily allows you to organize a structure page object. Pages is devided on blocks in which used relative xpath.
##### Example from project:
```
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
```
2. ***Steps*** - the entire business logic of the test is transferred to the folder of the step. All actions are taken in the methods

3. ***Page Factory*** - it was implemented as WebPageFactory() by htmlelements. It allows returning WebPage instances that are wrapped around the given driver.
##### Example from project:
```
public OrderHistorySteps(WebDriver webDriver){
        PageFactory pageFactory = new PageFactory(webDriver);
        orderHistoryPage =  pageFactory.on(OrderHistoryPage.class);
    }
```

4. ***Fluent*** - used in steps classes. methods return a reference to the step class for the ability to invoke methods sequentially in tests. 
##### Example from project:
```
  mainPageSteps
                 .goToShoppingCart()
                 .clickProceedToCheckout()
                 .checkDeliveryAddressDisplayed()
                 .clickProceedToCheckout()
                 .agreeTermsOfService()
```

### What else could I use to improve the project?

1. **WebDriverManager** (https://github.com/bonigarcia/webdrivermanager) - for more convenient work with the webdriver 
2. **Spring** (http://www.baeldung.com/spring-autowire) - for using @Autowired for inject WebDriverManage, steps classes in test classes
3. **Allure** (https://github.com/allure-framework/allure2) - for creating reports
6. **Add config file** - for setup different parameters for size of browser, environment
7. **Log4j** (https://github.com/apache/log4j) - for logging a steps

## How to run

` mvn clean test`

### Report - target/surefire-reports




