package primephonic.webelements;

import io.qameta.htmlelements.context.Context;
import io.qameta.htmlelements.extension.HandleWith;
import io.qameta.htmlelements.extension.MethodHandler;
import org.hamcrest.Matcher;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@HandleWith(IsMethod.Extension.class)
public @interface IsMethod {

    class Extension implements MethodHandler<Boolean> {

        public Boolean handle(final Context context, final Object proxy, final Method method, final Object[] args)
                throws Throwable {
            final Matcher matcher = (Matcher) args[0];
            return matcher.matches(proxy);
        }
    }
}
