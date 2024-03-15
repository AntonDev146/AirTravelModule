package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flight = FlightBuilder.createFlights();
        System.out.println("Все вылеты:");
        System.out.println(flight);
        System.out.println("Вылет до текущего момента времени:");
        System.out.println(new DepartureBeforeCurrentTime().getFilteredFlights(flight));
        System.out.println("Имеются сегменты с датой прилёта раньше даты вылета:");
        System.out.println(new ArrivalBeforeDeparture().getFilteredFlights(flight));
        System.out.println("Общее время, проведённое на земле превышает два часа:");
        System.out.println(new TimeMoreThanTwoHours().getFilteredFlights(flight));
    }
}