package by.epamtc.entity.plane;

import by.epamtc.entity.plane.field.AircraftEngine;
import by.epamtc.entity.plane.field.Person;
import by.epamtc.exception.NoSuchValueException;
import by.epamtc.util.FillArrayAction;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane implements Serializable {

    private int passengersCapacity = 10;

    private Person[] passengers;

    public PassengerPlane() {
        this.passengers = new Person[passengersCapacity];
    }

    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity,
                          int destinationDistance, int passengersCapacity) {
        super(engine, modelName, crewCapacity, destinationDistance);
        this.passengersCapacity = passengersCapacity;
        this.passengers = new Person[passengersCapacity];
    }

    @Override
    public void fly() throws NoSuchValueException {
        if (getEngine() == null) {
            throw new NoSuchValueException("Engine is not present");
        }
        int consumptionPerKilometer = getEngine().getFuelConsumption();
        int fuelInTank = getEngine().getTankFuelAmount();

        int fuelInTankLeft = fuelInTank - getDestinationDistance() * consumptionPerKilometer;
        getEngine().setTankFuelAmount(fuelInTankLeft);
    }

    public void boardPassenger(Person passenger) throws NoSuchValueException {
        FillArrayAction.addPerson(passenger, passengers);
    }

    public void boardAllPassengers(Person[] newPassengers) throws NoSuchValueException {
        FillArrayAction.addAllPersons(newPassengers, passengers);
    }

    public Person[] boardOffPassengers() throws NoSuchValueException {
        Person[] boardedOffPassengers = passengers;
        FillArrayAction.removeAllPersons(passengers);
        return boardedOffPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;

        if (passengers == plane.passengers) return true;
        if (passengers == null || plane.passengers == null) return false;

        if (passengers.length != plane.passengers.length) return false;
        for (int i = 0; i < passengers.length; i++) {
            if (!(passengers[i] == null ? plane.passengers[i] == null
                    : passengers[i].equals(plane.passengers[i]))) return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + passengersCapacity;

        int passengersHashcode = 0;
        for (Person passenger : passengers) {
            passengersHashcode += (passenger != null) ? passenger.hashCode() : 0;
        }

        result = 37 * result + passengersHashcode;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName());
        result.append(super.toString().replaceFirst(super.getClass().getName(), ""));
        result.append(", passengersCapacity=");
        result.append(passengersCapacity);
        result.append(", passengers=[");

        String separators = ", ";
        for (Person passenger : passengers) {
            result.append(passenger);
            result.append(separators);
        }
        result.delete(result.length() - separators.length(), result.length());
        result.append("]");
        return result.toString();
    }

}
