package by.epamtc.entity;

public enum CargoPlaneWorkload {

    EMPTY(2),
    HALF_FULL_OF_GOODS(8),
    FULL_OF_GOODS(12);

    private int fuelConsumptionFactor;

    CargoPlaneWorkload(int fuelConsumptionFactor) {
        this.fuelConsumptionFactor = fuelConsumptionFactor;
    }

    public int getFuelConsumptionFactor() {
        return fuelConsumptionFactor;
    }

}
