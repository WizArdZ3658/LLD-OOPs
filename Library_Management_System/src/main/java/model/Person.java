package model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person {
    private String name;
    private String barCode;
    private String phoneNo;
    private String address;
    private List<Book> booksCheckedOut;
}
