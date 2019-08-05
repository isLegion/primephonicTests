package primephonic.webelements;

import io.qameta.htmlelements.context.Context;
import io.qameta.htmlelements.extension.HandleWith;
import io.qameta.htmlelements.extension.MethodHandler;
import org.codehaus.plexus.util.StringUtils;
import org.openqa.selenium.support.ui.Select;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@HandleWith(ClearAndSendKeys.Extension.class)
public @interface ClearAndSendKeys {

    class Extension implements MethodHandler{

        public Object handle(Context context, Object proxy, Method method, Object[] args) {
            String text = (String) args[0];
            MineWebElement webElement = (MineWebElement) proxy;
            webElement.clear();
            webElement.click();
            webElement.sendKeys(text);
            return proxy;
        }
    }
}
