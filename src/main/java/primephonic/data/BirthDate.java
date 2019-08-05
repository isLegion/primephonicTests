package primephonic.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class BirthDate {

    private int day;
    private int month;
    private int year;
}
