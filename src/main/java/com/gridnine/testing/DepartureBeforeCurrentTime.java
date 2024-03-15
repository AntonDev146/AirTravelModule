package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTime implements FlightFilter {

    // Вылет до текущего момента времени
    @Override
    public List<Flight> getFilteredFlights(List<Flight> noFiltering) {
        List<Flight> listFilteredFlights = noFiltering.stream().filter(flights -> flights.getSegments().stream()
                .anyMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))).collect(Collectors.toList());
        return listFilteredFlights;
    }
}
