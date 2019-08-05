package primephonic.blocks;

import io.qameta.htmlelements.annotation.Description;
import io.qameta.htmlelements.annotation.FindBy;
import primephonic.webelements.ExtendedMineWebElement;
import primephonic.webelements.MineWebElement;

public interface WithLogo extends ExtendedMineWebElement {
    @Description("WithLogo")
    @FindBy("//img[contains(@class, 'logo')]")
    MineWebElement logo();
}
