package com.gridnine.testing;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class TimeMoreThanTwoHours implements FlightFilter {

    // Общее время, проведённое на земле превышает два часа
    @Override
    public List<Flight> getFilteredFlights(List<Flight> noFiltering) {
        List<Flight> listFilteredFlights = noFiltering.stream()
                .filter(flights -> {
                    long time = 0;
                    for (int i = 0; i < flights.getSegments().size() - 1; i++) {
                        time = flights.getSegments().get(i).getArrivalDate().until(flights.getSegments().get(i + 1).getDepartureDate(), ChronoUnit.HOURS);
                    }
                    return time > 2;
                }).collect(Collectors.toList());
        return listFilteredFlights;
    }
}