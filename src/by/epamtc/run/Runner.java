package by.epamtc.run;

import by.epamtc.dao.impl.AirlineDAO;

import by.epamtc.entity.Airline;
import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.exception.DAOException;
import by.epamtc.exception.NoSuchValueException;
import by.epamtc.service.sort.MaxSpeedComparator;
import by.epamtc.service.sort.RangeOfFlightComparator;

public class Runner {
    public static void main(String[] args) {
        AirlineDAO airlineDAO = new AirlineDAO("src/resource/data.txt");
        Airline airline = null;
        try {
            airline = airlineDAO.load();
        } catch (DAOException e) {
            e.printStackTrace();
        }
        System.out.println(airline);

        try {
            System.out.println("countTotalLiftingCapacity: " + airline.countTotalLiftingCapacity());
            System.out.println("countTotalCrewCapacity: " + airline.countTotalCrewCapacity());
        } catch (NoSuchValueException e) {
            e.printStackTrace();
        }

        AbstractPlane[] sorted = new AbstractPlane[0];
        try {
            sorted = airline.sort(new MaxSpeedComparator());
        } catch (NoSuchValueException e) {
            e.printStackTrace();
        }
        System.out.println("sort maxSpeed");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getMaxSpeed());
        }

        try {
            sorted = airline.sort(new RangeOfFlightComparator());
        } catch (NoSuchValueException e) {
            e.printStackTrace();
        }
        System.out.println("sort rangeOfFlight");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getRangeOfFlight());
        }

        System.out.println("findPlanesByFuelConsumption");
        AbstractPlane[] result = new AbstractPlane[0];
        try {
            result = airline.findPlanesByFuelConsumption(10, 100);
        } catch (NoSuchValueException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getEngine().getFuelConsumption());
        }
    }
}
