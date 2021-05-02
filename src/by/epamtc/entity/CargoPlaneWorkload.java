package by.epamtc.entity;

public enum CargoPlaneWorkload {

    EMPTY(2, true),
    LESS_THAN_HALF_FULL(4, true),
    HALF_FULL_OF_GOODS(8, true),
    MORE_THAN_HALF_FULL(12, true),
    FULL_OF_GOODS(15, true),
    OVERLOADED(20, false);

    private int fuelConsumptionFactor;

    private boolean flightable;

    CargoPlaneWorkload(int fuelConsumptionFactor, boolean flightable) {
        this.fuelConsumptionFactor = fuelConsumptionFactor;
        this.flightable = flightable;
    }

    public int getFuelConsumptionFactor() {
        return fuelConsumptionFactor;
    }

    public boolean getFlightable() {
        return flightable;
    }

}
