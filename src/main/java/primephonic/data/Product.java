package primephonic.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Product {

    private String name;
    private String avail;
    private String price;
    private String img;

}
