package com.gridnine.testing;

import java.util.List;

public interface FlightFilter {
    List<Flight> getFilteredFlights(List<Flight> noFiltering);
}
