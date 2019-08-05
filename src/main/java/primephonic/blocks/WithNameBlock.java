package primephonic.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import primephonic.webelements.ExtendedMineWebElement;
import primephonic.webelements.MineWebElement;

public interface WithNameBlock extends ExtendedMineWebElement {

    @Description("Customer first name")
    @FindBy(".//input[contains(@name,'firstname')]")
    MineWebElement inputFirstName();

    @Description("Customer last name")
    @FindBy(".//input[contains(@name, 'lastname')]")
    MineWebElement inputLastName();
}
