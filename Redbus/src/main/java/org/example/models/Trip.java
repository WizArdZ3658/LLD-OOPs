package org.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.enums.SeatStatus;

import java.util.*;

@Getter
@Setter
public class Trip {
    private Integer id;
    private List<City> cities;
    private Map<City, Set<City>> cityToCityMap;
    private Date startTime;
    private Bus bus;
    private List<Segment> segments;

    private static int instanceCount = 0;

    public Trip(Bus bus, List<City> cities, Date startTime) {
        this.id = instanceCount++;
        this.bus = bus;
        this.cities = cities;
        this.startTime = startTime;
        this.cityToCityMap = new HashMap<>();
        this.generateCityToCityMap();
        this.generateTripSegments();
    }

    private void generateCityToCityMap() {
        int n = this.cities.size();
        for (int i = 0; i < n; i++) {
            Set<City> setOfCities = new HashSet<>();
            for (int j = i+1; j < n; j++) {
                setOfCities.add(this.cities.get(j));
            }
            this.cityToCityMap.put(this.cities.get(i), setOfCities);
        }
    }

    private void generateTripSegments() {
        List<Segment> segmentList = new ArrayList<>();
        for (int i = 1; i < this.cities.size(); i++) {
            City from = this.cities.get(i-1);
            City to = this.cities.get(i);
            Segment segment = new Segment(from, to, getTripSegmentSeats());
            segmentList.add(segment);
        }
        this.segments = segmentList;
    }

    private List<TripSegmentSeat> getTripSegmentSeats() {
        List<TripSegmentSeat> tripSegmentSeats = new ArrayList<>();
        for (Seat seat : this.bus.getSeats()) {
            tripSegmentSeats.add(new TripSegmentSeat(seat, SeatStatus.VACANT));
        }
        return tripSegmentSeats;
    }

    @Override
    public String toString() {
        return "Trip {" +
                "\n\tid=" + id +
                ", \n\tcities=" + cities +
                ", \n\tcityToCityMap=" + cityToCityMap +
                ", \n\tstartTime=" + startTime +
                ", \n\tbus=" + bus +
                ", \n\tsegments=" + segments +
                "\n}";
    }
}
