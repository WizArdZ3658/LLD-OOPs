package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import model.Cinema;

public class BookMyShowService {
    private List<Cinema> cinemaHalls = new ArrayList<>();

    // public List<Movie> searchMovies(String title, Date releaseDate) {
    //
    // }

    public List<Cinema> searchCinemaHalls(String city) {
        return cinemaHalls.stream().filter(cinema -> Objects.equals(cinema.getCityName(), city)).collect(Collectors.toList());
    }
}
