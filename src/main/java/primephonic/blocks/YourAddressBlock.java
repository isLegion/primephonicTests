package primephonic.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import primephonic.webelements.ExtendedMineWebElement;
import primephonic.webelements.MineWebElement;

public interface YourAddressBlock extends ExtendedMineWebElement, WithNameBlock {

    @Description("Compamny")
    @FindBy(".//input[@name = 'company']")
    MineWebElement company();

    @Description("Address 1")
    @FindBy(".//input[@name = 'address1']")
    MineWebElement address1();

    @Description("Address 2")
    @FindBy(".//input[@name = 'address2']")
    MineWebElement address2();

    @Description("City")
    @FindBy(".//input[@name = 'city']")
    MineWebElement city();

    @Description("State")
    @FindBy(".//select[@name = 'id_state']")
    MineWebElement selectState();

    @Description("Postcode")
    @FindBy(".//input[@name = 'postcode']")
    MineWebElement postCode();

    @Description("Country")
    @FindBy(".//select[@name = 'id_country']")
    MineWebElement selectCountry();

    @Description("Home phone")
    @FindBy(".//input[@name = 'phone']")
    MineWebElement homePhone();

    @Description("Mobile phone")
    @FindBy(".//input[@name = 'phone_mobile']")
    MineWebElement mobilePhone();

    @Description("Additional information")
    @FindBy(".//textarea[@name = 'other']")
    MineWebElement additionalInformation();

    @Description("Alias address")
    @FindBy(".//input[@name = 'alias']")
    MineWebElement aliasAddress();

}
