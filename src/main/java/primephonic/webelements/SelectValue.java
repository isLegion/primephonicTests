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
@HandleWith(SelectValue.Extension.class)
public @interface SelectValue {

    class Extension implements MethodHandler{

        @Override
        public Object handle(Context context, Object proxy, Method method, Object[] args) throws Throwable {
            String selectedValue = (String) args[0];
            MineWebElement webElement = (MineWebElement) proxy;
            Select sel = new Select(webElement);
            if (StringUtils.isNotEmpty(selectedValue)) {
                sel.selectByValue(selectedValue);
            } else {
                sel.selectByIndex(0);
            }
            return proxy;
        }
    }
}
