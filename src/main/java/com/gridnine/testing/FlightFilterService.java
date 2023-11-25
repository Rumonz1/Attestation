package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FlightFilterService {
    public static void allFlights(List<Flight> allAirFlights) {
        System.out.println("\n _______СПИСОК ВСЕХ ПЕРЕЛЁТОВ_______\n");
        allAirFlights.forEach(System.out::println);

    }

    public static List<Flight> flightDepartingInThePast(List<Flight> airFlights) {

        List<Flight> flights = new ArrayList<>();
        System.out.println("\n _______СПИСОК С ВЫЛЕТОМ В ПРОШЛОМ_______\n");
        for (Flight flight : airFlights){
            if (flight.getSegments()
                    .stream()
                    .allMatch(segment -> segment.getDepartureDate().isBefore(LocalDateTime.now()))){
                flights.add(flight);
            }
        }
        flights.forEach(System.out::println);
        return flights;
    }

//    public List<Flight> normalFlightWithTwoHourDuration(List<Flight> airFlights) {
//        System.out.println("\n _______СПИСОК ПЕРЕЛЁТОВ ПРОДОЛЖИТЕЛЬНОСТЬЮ 2 ЧАСА _______\n");
//        return null;
//    }

//    public List<Flight> normalMultiSegmentFlight(List<Flight> airFlights) {
//        System.out.println("\n _______СПИСОК ОБЫЧНИХ ПЕРЕЛЁТОВ_______\n");
//        return null;
//    }

    public static List<Flight> flightThatDepartsBeforeItArrives(List<Flight> airFlights) {

        List<Flight> flights = new ArrayList<>();
            System.out.println("\n _______СПИСОК ПЕРЕЛЁТОВ С ДАТОЙ ПРИЛЁТА РАНЬШЕ ДАТЫ ВЫЛЕТА_______\n");
        for (Flight flight : airFlights){
            if (flight.getSegments()
                    .stream()
                    .allMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate()))) {
                flights.add(flight);
            }
        }
        flights.forEach(System.out::println);
        return flights;
    }

    public  static List<Flight> flightWithMoreThanTwoHoursGroundTime(List<Flight> airFlights) {

        List<Flight> flights = new ArrayList<>();
        System.out.println("\n _______СПИСОК ПЕРЕЛЁТОВ, ГДЕ ВРЕМЯ НА ЗЕМЛЕ БОЛЬШЕ 2-Х ЧАСОВ_______\n");
        for (Flight flight : airFlights) {
            long sum = 0;
            for (int i = 0; i < flight.getSegments().size() - 1; i++) {
                long duration = Duration.between(flight.getSegments().get(i).getArrivalDate(), flight.getSegments().get(i + 1).getDepartureDate()).toHours();
                sum += duration;
            }
            if (sum < 2 && flight.getSegments().size() > 1) {
                flights.add(flight);
            }
        }
        flights.forEach(System.out::println);
        return flights;
    }

    
}
