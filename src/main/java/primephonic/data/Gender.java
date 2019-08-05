package primephonic.data;

public enum Gender {
    FEMALE("id_gender2"),
    MALE("id_gender1");

    private String gender;

    Gender(String gender){
        this.gender = gender;
    }

    @Override
    public String toString() {
        return this.gender;
    }
}
