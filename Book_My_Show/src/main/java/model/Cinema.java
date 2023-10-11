package model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cinema {
    private String id;
    private String name;
    private String cityName;
    private List<Audi> audiList;
}
