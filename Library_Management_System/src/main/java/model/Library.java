package model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Library {
    private String name;
    private List<Book> books;
    private String address;
}
