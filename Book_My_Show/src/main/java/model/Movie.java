package model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private String id;
    private String name;
    private String language;
    private String genre;
    private Date releaseDate;
    private Map<String, List<Show>> cityShowMap;
}
