package primephonic.data;

import java.util.Arrays;
import java.util.List;

public class Messages {

    public static final String FIRSTNAME_REQUIRED = "firstname is required.";
    public static final String EMAIL_REQUIRED = "email is required.";
    public static final String ALIAS_REQUIRED = "alias is required.";
    public static final String LASTNAME_REQUIRED = "lastname is required.";
    public static final String PASSWORD_REUIRED = "passwd is required.";
    public static final String ADDRESS1_REQUIRED = "address1 is required.";
    public static final String CITY_REQUIRED = "city is required.";
    public static final String PHONE_REQUIRED = "You must register at least one phone number.";
    public static final String STATE_REQUIRED = "This country requires you to choose a State.";
    public static final String ZIP_REQUIRED_REQUIRED = "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";


    public static final String FIRSTNAME_INVALID = "firstname is invalid.";
    public static final String PHONEMOBILE_INVALID = "phone_mobile is invalid.";
    public static final String PHONE_INVALID = "phone is invalid.";
    public static final String LASTNAME_INVALID = "lastname is invalid.";
    public static final String EMAIL_INVALID = "email is invalid.";
    public static final String ADDRESS1_INVALID = "address1 is invalid.";
    public static final String ADDRESS2_INVALID = "address2 is invalid.";
    public static final String PASSWORD_INVALID = "passwd is invalid.";
    public static final String CITY_INVALID = "city is invalid.";
    public static final String ZIP_REQUIRED_INVALID = "postcode is invalid.";


    public static final String FIRSTNAME_LONG = "firstname is too long. Maximum length: 32";
    public static final String LASTTNAME_LONG = "lastname is too long. Maximum length: 32";
    public static final String PASSWORD_LONG = "passwd is too long. Maximum length: 32";
    public static final String ALIAS_LONG = "alias is too long. Maximum length: 32";
    public static final String ZIP_REQUIRED_LONG = "postcode is too long. Maximum length: 12";
    public static final String PHONE_LONG = "phone is too long. Maximum length: 32";
    public static final String MOBILEPHONE_LONG = "phone_mobile is too long. Maximum length: 32";


    public static List<String> getAllRequiredMessages() {
        return Arrays.asList(FIRSTNAME_REQUIRED, EMAIL_REQUIRED, ALIAS_REQUIRED, LASTNAME_REQUIRED, PASSWORD_REUIRED,
                ADDRESS1_REQUIRED, CITY_REQUIRED, PHONE_REQUIRED, STATE_REQUIRED, ZIP_REQUIRED_REQUIRED);
    }

    public static List<String> getAllMessagesWithNmb() {
        return Arrays.asList(LASTNAME_INVALID, FIRSTNAME_INVALID, ZIP_REQUIRED_REQUIRED, EMAIL_INVALID, PHONE_INVALID, PHONEMOBILE_INVALID);
    }

    public static List<String> getAllLongMessages() {
        return Arrays.asList(FIRSTNAME_LONG, LASTTNAME_LONG, EMAIL_INVALID, PASSWORD_LONG, ALIAS_LONG, ZIP_REQUIRED_LONG,
                ZIP_REQUIRED_REQUIRED, PHONE_LONG, MOBILEPHONE_LONG);
    }

    public static List<String> getAllMessagesWithIncorrectSymbols() {
        return Arrays.asList(LASTNAME_INVALID, FIRSTNAME_INVALID, ZIP_REQUIRED_REQUIRED, EMAIL_INVALID,
                PHONEMOBILE_INVALID, PHONE_INVALID, ADDRESS1_INVALID, ADDRESS2_INVALID, CITY_INVALID, ZIP_REQUIRED_INVALID);
    }
}
