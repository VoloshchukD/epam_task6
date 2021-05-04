package by.epamtc.run;

import by.epamtc.dao.AirlineStorage;

import by.epamtc.entity.Airline;
import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.exception.NoSuchParameterException;
import by.epamtc.service.sort.MaxSpeedComparator;
import by.epamtc.service.sort.RangeOfFlightComparator;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException, NoSuchParameterException {
        Airline airline = AirlineStorage.getAirline("data.txt");
        System.out.println(airline);

        System.out.println("countTotalLiftingCapacity: " + airline.countTotalLiftingCapacity());
        System.out.println("countTotalCrewCapacity: " + airline.countTotalCrewCapacity());

        AbstractPlane[] sorted = airline.sort(new MaxSpeedComparator());
        System.out.println("sort maxSpeed");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getMaxSpeed());
        }

        sorted = airline.sort(new RangeOfFlightComparator());
        System.out.println("sort rangeOfFlight");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getRangeOfFlight());
        }

        System.out.println("findPlanesByFuelConsumption");
        AbstractPlane[] result = airline.findPlanesByFuelConsumption(10, 100);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getEngine().getFuelConsumption());
        }
    }
}
