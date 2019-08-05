package primephonic;

import org.apache.commons.lang.RandomStringUtils;
import org.kohsuke.randname.RandomNameGenerator;
import primephonic.data.BirthDate;
import primephonic.data.Gender;
import primephonic.data.User;

import java.util.Random;

public class TestUtil {

    public static final RandomNameGenerator RND = new RandomNameGenerator();

    public static String getRandomSimpleWord(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String getRandomWordWithNmb(){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = true;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String getRandomWordAnyLength(int lenght){
        int length = lenght;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    public static String getRandomWordWithSymbols(char[] symbols){
        int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, 1, 10, useLetters, useNumbers, symbols);
    }

    public static String getRandomEmail() { return getRandomSimpleWord() + "@gmail.com";}

    public static Integer getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static User generateUserWithAllFields(){
        return User.builder()
                .firstName(getRandomSimpleWord())
                .lastName(getRandomSimpleWord())
                .gender(Gender.FEMALE)
                .password(getRandomSimpleWord())
                .email(getRandomEmail())
                .birthDate(BirthDate.builder().day(getRandomNumber(1, 29)).month(getRandomNumber(1, 12)).year(getRandomNumber(1900, 2019)).build())
                .address(getRandomSimpleWord())
                .address2(getRandomSimpleWord())
                .company(getRandomSimpleWord())
                .state(Integer.toString(getRandomNumber(1, 50)))
                .city(getRandomSimpleWord())
                .zipCode(Integer.toString(getRandomNumber(0, 99999)))
                .mobileNumber(Integer.toString(getRandomNumber(0, 999999999)))
                .homeNumber(Integer.toString(getRandomNumber(0, 9999999)))
                .additionalInformation(getRandomSimpleWord())
                .addressAlias(getRandomSimpleWord()).build();
    }
}
