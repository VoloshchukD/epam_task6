package by.epamtc.entity;

import java.util.Arrays;

public class PassengerPlane extends AbstractPlane {

    private int passengersCapacity;

    private Person[] passengers;

    public PassengerPlane() {
    }

    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity) {
        super(engine, modelName, crewCapacity);
    }

    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity,
                          int passengersCapacity, Person[] passengers) {
        super(engine, modelName, crewCapacity);
        this.passengersCapacity = passengersCapacity;
        this.passengers = passengers;
    }

    public void boardPassengers() {

    }

    public void boardOffPassengers() {

    }

    @Override
    public void fly() {

    }

    @Override
    public String toString() {
        return "PassengerPlane{" +
                "passengersCapacity=" + passengersCapacity +
                ", passengers=" + Arrays.toString(passengers) +
                '}';
    }
}
