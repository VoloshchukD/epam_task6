package by.epamtc.run;

import by.epamtc.dao.AirlineStorage;
import by.epamtc.entity.*;
import by.epamtc.entity.plane.additional.AircraftEngine;
import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.entity.plane.CargoPlane;
import by.epamtc.entity.plane.PassengerPlane;
import by.epamtc.entity.plane.additional.Goods;
import by.epamtc.entity.plane.additional.Person;

import java.io.*;

public class Runner {
    public static void main(String[] args) throws IOException {
        AircraftEngine engine2 = new AircraftEngine(1, 2, 3,
                4, 5, 6, 7);
        AircraftEngine engine3 = new AircraftEngine(10, 10, 10,
                10, 10, 10, 10);
        AircraftEngine engine = new AircraftEngine(100, 100,
                100, 100, 100, 100, 100);

        PassengerPlane p1 = new PassengerPlane(engine, "A1", 3, 100, 6);
        PassengerPlane p2 = new PassengerPlane(engine2, "A2", 7, 200, 20);

        Person person1 = new Person("a", 80);
        Person person2 = new Person("b", 70);
        Person person3 = new Person("c", 60);
        Person person4 = new Person("d", 50);
        Person person5 = new Person("e", 90);
        Person person6 = new Person("f", 80);
        Person person7 = new Person("g", 38);
        Person person8 = new Person("h", 53);

        Person[] persons = {person1, person2, person3, person4, person5, person6, person7, person8};


        Goods goods = new Goods("info", "adress", 21, false);
        Goods goods2 = new Goods("info", "adress", 19, false);
        Goods goods3 = new Goods("info", "adress", 29, true);
        Goods goods4 = new Goods("info", "adress", 83, false);
        Goods goods5 = new Goods("info", "adress", 2, true);
        Goods goods6 = new Goods("info", "adress", 93, false);

        Goods[] goodsToLoad = {goods, goods2, goods3, goods4, goods5, goods6};

        CargoPlane p3 = new CargoPlane(engine3, "A3", 3, 50);
        CargoPlane p4 = new CargoPlane(engine3, "A4", 4, 150);
        p3.loadAllGoods(goodsToLoad);
        p4.loadAllGoods(goodsToLoad);

        p1.boardAllCrewMembers(persons);
        p2.boardAllCrewMembers(persons);
        p3.boardAllCrewMembers(persons);
        p4.boardAllCrewMembers(persons);

        p1.boardAllPassengers(persons);
        p2.boardAllPassengers(persons);

        AbstractPlane[] planes = {p1, p2, p3, p4};
        Airline airline = new Airline("airline A1", planes);

//        AirlineStorage.saveAirline(airline);
//        System.out.println(AirlineStorage.getAirline());

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            outputStream.writeObject(airline);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.txt"))) {
//            personNew = (CargoPlane) inputStream.readObject();
//            personNew2 = (Airline) inputStream.readObject();
//        } catch (FileNotFoundException | ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println("read " + personNew);
//        System.out.println("read " + personNew2);

        AirlineStorage.saveAirline(airline);

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
