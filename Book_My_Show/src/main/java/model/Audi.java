package model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Audi {
    private String id;
    private String name;
    private List<Show> showList;
}
