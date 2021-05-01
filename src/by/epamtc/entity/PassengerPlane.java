package by.epamtc.entity;

import java.io.Serializable;

public class PassengerPlane extends AbstractPlane implements Serializable {

    private int passengersCapacity;

    private Person[] passengers;

    private PassengerPlaneWorkload workload;

    public PassengerPlane() {
    }

    ///////////del
    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity) {
        super(engine, modelName, crewCapacity);
    }

    public PassengerPlane(AircraftEngine engine, String modelName, int crewCapacity,
                          int passengersCapacity, Person[] passengers, PassengerPlaneWorkload workload) {
        super(engine, modelName, crewCapacity);
        this.passengersCapacity = passengersCapacity;
        this.passengers = passengers;
        this.workload = workload;
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

    public PassengerPlaneWorkload getWorkload() {
        return workload;
    }

    public void setWorkload(PassengerPlaneWorkload workload) {
        this.workload = workload;
    }

    @Override
    public void fly() {

    }

    public void boardPassengers() {

    }

    public void boardOffPassengers() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerPlane plane = (PassengerPlane) o;

        boolean result = true;
        if (passengersCapacity == plane.passengersCapacity &&
                workload == plane.workload &&
                passengers.length == plane.passengers.length) {
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
        result = 37 * result + workload.hashCode();
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
        result.append(", workload=");
        result.append(workload);
        return result.toString();
    }

}
