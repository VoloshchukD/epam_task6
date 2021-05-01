package by.epamtc.entity;

public enum PassengerPlaneWorkload {

    EMPTY(2),
    HALF_FULL_OF_PASSENGERS(4),
    FULL_OF_PASSENGERS(6);

    private int fuelConsumptionFactor;

    PassengerPlaneWorkload(int fuelConsumptionFactor) {
        this.fuelConsumptionFactor = fuelConsumptionFactor;
    }

    public int getFuelConsumptionFactor() {
        return fuelConsumptionFactor;
    }

}
