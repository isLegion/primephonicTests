package primephonic.webelements;

import io.qameta.htmlelements.element.ExtendedWebElement;

/**
 * Created by zsmirnova on 4/6/18.
 */
//It is used for adding new methods {is(), selectValue()} that are not available in the interface ExtendedWebElement
public interface ExtendedMineWebElement<FluentType>  extends ExtendedWebElement<FluentType> {

    @SelectValue
    void selectValue(String value);

    @SelectText
    void selectText(String value);

    @ClearAndSendKeys
    void clearAndSendKeys(String text);

}
