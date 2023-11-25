package com.gridnine.testing;

public class Main {
    public static void main(String[] args) {

        var airFlight = FlightBuilder.createFlights();

        FlightFilterService.allFlights(airFlight);

        FlightFilterService.flightThatDepartsBeforeItArrives(airFlight);

        FlightFilterService.flightWithMoreThanTwoHoursGroundTime(airFlight);

        FlightFilterService.flightDepartingInThePast(airFlight);

    }

}
