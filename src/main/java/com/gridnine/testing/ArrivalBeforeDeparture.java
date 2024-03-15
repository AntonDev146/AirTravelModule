package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class ArrivalBeforeDeparture implements FlightFilter {

    // Имеются сегменты с датой прилёта раньше даты вылета
    @Override
    public List<Flight> getFilteredFlights(List<Flight> noFiltering) {
        List<Flight> listFilteredFlights = noFiltering.stream()
                .filter(flights -> flights.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
        return listFilteredFlights;
    }
}
