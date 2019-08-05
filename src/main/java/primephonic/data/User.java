package primephonic.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class User {

    private Gender gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private BirthDate birthDate;
    private String company;
    private String address;
    private String address2;
    private String zipCode;
    private String city;
    private String state;
    private String mobileNumber;
    private String homeNumber;
    private String additionalInformation;
    private String addressAlias;

}
