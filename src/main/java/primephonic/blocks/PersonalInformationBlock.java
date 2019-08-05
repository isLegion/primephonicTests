package primephonic.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import io.qameta.htmlelements.annotation.Param;
import primephonic.webelements.ExtendedMineWebElement;
import primephonic.webelements.MineWebElement;

public interface PersonalInformationBlock extends ExtendedMineWebElement, WithNameBlock {

    @Description("Gender {{ gender }}")
    @FindBy(".//div[@class= 'radio-inline']//label[@for='{{ gender }}']")
    MineWebElement gender(@Param("gender") String gender);

    @Description("Customer email")
    @FindBy(".//input[@name = 'email']")
    MineWebElement inputEmail();

    @Description("Customer password")
    @FindBy(".//input[@name = 'passwd']")
    MineWebElement inputPassword();

    @Description("Day of birth")
    @FindBy(".//select[@name = 'days']")
    MineWebElement selectDay();

    @Description("Month of birth")
    @FindBy(".//select[@name = 'months']")
    MineWebElement selectMonth();

    @Description("Year of birth")
    @FindBy(".//select[@name = 'years']")
    MineWebElement selectYear();
}
