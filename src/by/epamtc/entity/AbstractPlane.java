package by.epamtc.entity;

public abstract class AbstractPlane {

    private int maxSpeed;

    private int passengerCapacity;

    private int liftingCapacity;

    private int fuelConsumption;

    private int rangeOfFlight;

    private int maxFlightHeight;

    private Person[] crew;

    public abstract void takeOff();

    public abstract void land();

    public void addCrew() {

    }

    public void removeCrew() {

    }

}
