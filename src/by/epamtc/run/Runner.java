package by.epamtc.run;

import by.epamtc.dao.AirlineStorage;
import by.epamtc.entity.*;
import by.epamtc.entity.plane.additional.AircraftEngine;
import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.entity.plane.CargoPlane;
import by.epamtc.entity.plane.PassengerPlane;
import by.epamtc.entity.plane.additional.Person;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        AircraftEngine engine2 = new AircraftEngine(1, 2, 3,
                4, 5, 6, 7);
        AircraftEngine engine3 = new AircraftEngine(10, 10, 10,
                10, 10, 10, 10);
        AircraftEngine engine = new AircraftEngine(100, 100,
                100, 100, 100, 100, 100);

        PassengerPlane p1 = new PassengerPlane(engine, "A1", 3, 100, 10);
        PassengerPlane p2 = new PassengerPlane(engine2, "A2", 7,  200, 20);
        CargoPlane p3 = new CargoPlane(engine3, "A3", 3, 50);
        CargoPlane p4 = new CargoPlane(engine3, "A4", 4, 150);

        Person person1 = new Person("a", 80);
        Person person2 = new Person("b", 70);
        Person person3 = new Person("c", 60);
        Person person4 = new Person("d", 50);
        Person person5 = new Person("e", 90);
        Person person6 = new Person("f", 80);
        Person person7 = new Person("g", 38);
        Person person8 = new Person("h", 53);

        Person[] persons = {person1, person2, person3, person4, person5, person6, person7, person8};

        p1.boardAllCrewMembers(persons);
        p2.boardAllCrewMembers(persons);
        p3.boardAllCrewMembers(persons);
        p4.boardAllCrewMembers(persons);

        p1.boardAllPassengers(persons);
        p2.boardAllPassengers(persons);
        System.out.println(p1);

        Airline airline = new Airline();
        AbstractPlane[] planes = {p1, p2, p3, p4};
        airline.setPlanes(planes);

//        AirlineStorage.saveAirline(airline);
        System.out.println(AirlineStorage.getAirline());

        System.out.println("countTotalLiftingCapacity: " + airline.countTotalLiftingCapacity());
        System.out.println("countTotalCrewCapacity: " + airline.countTotalCrewCapacity());

        AbstractPlane[] sorted = airline.sort();
        System.out.println("sort");
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getMaxSpeed());
        }

        System.out.println("findPlanesByFuelConsumption");
        AbstractPlane[] result = airline.findPlanesByFuelConsumption(10, 100);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getEngine().getFuelConsumption());
        }
    }

}
