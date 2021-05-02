package by.epamtc.entity;

import by.epamtc.util.FillArrayAction;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane implements Serializable {

    private int passengersCapacity;

    private Person[] passengers;

    public PassengerPlane() {
    }

    ///////////del
    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity, int destinationDistance) {
        super(engine, modelName, crewCapacity, destinationDistance);
    }

    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity, int passengersCapacity,
                          Person[] passengers, int destinationDistance) {
        super(engine, modelName, crewCapacity, destinationDistance);
        this.passengersCapacity = passengersCapacity;
        this.passengers = passengers;
    }

    public int getPassengersCapacity() {
        return passengersCapacity;
    }

    public void setPassengersCapacity(int passengersCapacity) {
        this.passengersCapacity = passengersCapacity;
    }

    public Person[] getPassengers() {
        return passengers;
    }

    public void setPassengers(Person[] passengers) {
        this.passengers = passengers;
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

    public void boardOffPassengers() {
        FillArrayAction.removeAllPersons(passengers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;

        boolean result = true;
        if (passengersCapacity == plane.passengersCapacity
                && passengers.length == plane.passengers.length) {
            int i = 0;
            while (i < passengers.length) {
                if (passengers[i] != plane.passengers[i]) {
                    result = false;
                    break;
                }
                i++;
            }
        } else {
            result = false;
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
            result.append(passenger.toString());
            result.append(separators);
        }
        result.delete(result.length() - separators.length() - 1, result.length());
        result.append("]");
        return result.toString();
    }

}
