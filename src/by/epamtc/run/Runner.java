package by.epamtc.run;

import by.epamtc.entity.*;

public class Runner {
    public static void main(String[] args) {
        AircraftEngine engine2 = new AircraftEngine(1, 2, 3,
                4, 5, 6, 7);
        AircraftEngine engine3 = new AircraftEngine(10, 10, 10,
                10, 10, 10, 10);
        AircraftEngine engine = new AircraftEngine(100, 100,
                100, 100, 100, 100, 100);
        AbstractPlane p1 = new PassengerPlane(engine, "A1", 1);
        AbstractPlane p2 = new PassengerPlane(engine2, "A2", 2);
        AbstractPlane p3 = new CargoPlane(engine3, "A3", 3);

        Airline airline = new Airline();
        AbstractPlane[] planes = {p1, p2, p3};
        airline.setPlanes(planes);

        System.out.println(airline.countTotalLiftingCapacity());
        System.out.println(airline.countTotalCrewCapacity());

        AbstractPlane[] sorted = airline.sort();
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i].getEngine().getMaxSpeed());
        }

    }
}
