package models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Seller extends User {
    private Integer gstNumber;
    private String sellerAddress;

    public Seller(String name, Integer id) {
        super(name, id);
    }
}
