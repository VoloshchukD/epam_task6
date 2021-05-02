package by.epamtc.entity.plane;

import by.epamtc.entity.plane.additional.AircraftEngine;
import by.epamtc.entity.plane.additional.Person;
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
    public void fly() {
        int consumptionPerKilometer = getEngine().getFuelConsumption();
        int fuelInTank = getEngine().getTankFuelAmount();

        int fuelInTankLeft = fuelInTank - getDestinationDistance() * consumptionPerKilometer;
        getEngine().setTankFuelAmount(fuelInTankLeft);
    }

    public void boardPassenger(Person passenger) {
        FillArrayAction.addPerson(passenger, passengers);
    }

    public void boardAllPassengers(Person[] newPassengers) {
        FillArrayAction.addAllPersons(newPassengers, passengers);
    }

    public Person[] boardOffPassengers() {
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

        boolean result = false;
        if (passengersCapacity == plane.passengersCapacity
                && passengers.length == plane.passengers.length) {
            int i = 0;
            while (i < passengers.length) {
                if (passengers[i] != plane.passengers[i]) {
                    break;
                }
                i++;
            }
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + passengersCapacity;

        int passengersHashcode = 0;
        for (Person passenger : passengers) {
            passengersHashcode += passenger.hashCode();
        }

        result = 37 * result + passengersHashcode;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName());
        result.append("@passengersCapacity=");
        result.append(passengersCapacity);
        result.append(", passengers=[");

        String separators = ", ";
        for (Person passenger : passengers) {
            if (passenger != null) {
                result.append(passenger.toString());
            } else {
                result.append(passenger);
            }
            result.append(separators);
        }
        result.delete(result.length() - separators.length() - 1, result.length());
        result.append("]");
        return result.toString();
    }

}
