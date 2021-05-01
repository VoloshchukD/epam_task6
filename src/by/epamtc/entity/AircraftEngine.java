package by.epamtc.entity;

import java.io.Serializable;

public class AircraftEngine implements Serializable {

    private int maxSpeed;

    private int liftingCapacity;

    private int rangeOfFlight;

    private int maxFlightHeight;

    private int fuelConsumption;

    private int tankFuelAmount;

    private int maxFuelTankCapacity;

    public AircraftEngine() {
    }

    public AircraftEngine(int maxSpeed, int liftingCapacity, int rangeOfFlight,
                          int maxFlightHeight, int fuelConsumption, int tankFuelAmount, int maxFuelTankCapacity) {
        this.maxSpeed = maxSpeed;
        this.liftingCapacity = liftingCapacity;
        this.rangeOfFlight = rangeOfFlight;
        this.maxFlightHeight = maxFlightHeight;
        this.fuelConsumption = fuelConsumption;
        this.tankFuelAmount = tankFuelAmount;
        this.maxFuelTankCapacity = maxFuelTankCapacity;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getLiftingCapacity() {
        return liftingCapacity;
    }

    public void setLiftingCapacity(int liftingCapacity) {
        this.liftingCapacity = liftingCapacity;
    }

    public int getRangeOfFlight() {
        return rangeOfFlight;
    }

    public void setRangeOfFlight(int rangeOfFlight) {
        this.rangeOfFlight = rangeOfFlight;
    }

    public int getMaxFlightHeight() {
        return maxFlightHeight;
    }

    public void setMaxFlightHeight(int maxFlightHeight) {
        this.maxFlightHeight = maxFlightHeight;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getTankFuelAmount() {
        return tankFuelAmount;
    }

    public void setTankFuelAmount(int tankFuelAmount) {
        this.tankFuelAmount = tankFuelAmount;
    }

    public int getMaxFuelTankCapacity() {
        return maxFuelTankCapacity;
    }

    public void setMaxFuelTankCapacity(int maxFuelTankCapacity) {
        this.maxFuelTankCapacity = maxFuelTankCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AircraftEngine that = (AircraftEngine) o;
        return maxSpeed == that.maxSpeed && liftingCapacity == that.liftingCapacity
                && rangeOfFlight == that.rangeOfFlight && maxFlightHeight == that.maxFlightHeight
                && fuelConsumption == that.fuelConsumption && tankFuelAmount == that.tankFuelAmount
                && maxFuelTankCapacity == that.maxFuelTankCapacity;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + maxSpeed;
        result = 37 * result + liftingCapacity;
        result = 37 * result + rangeOfFlight;
        result = 37 * result + maxFlightHeight;
        result = 37 * result + fuelConsumption;
        result = 37 * result + tankFuelAmount;
        result = 37 * result + maxFuelTankCapacity;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "maxSpeed=" + maxSpeed +
                ", liftingCapacity=" + liftingCapacity +
                ", rangeOfFlight=" + rangeOfFlight +
                ", maxFlightHeight=" + maxFlightHeight +
                ", fuelConsumption=" + fuelConsumption +
                ", tankFuelAmount=" + tankFuelAmount +
                ", maxFuelTankCapacity=" + maxFuelTankCapacity;
    }

}
