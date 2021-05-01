package by.epamtc.entity;

public enum CargoPlaneLoadDistribution {

    OPTIMAL_LOAD(4),
    HEAVIER_BACK_END(5),
    HEAVIER_FRONT_PART(6),
    HEAVIER_RIGHT_PART(12),
    HEAVIER_LEFT_PART(12);

    private int fuelConsumptionFactor;

    CargoPlaneLoadDistribution(int fuelConsumptionFactor) {
        this.fuelConsumptionFactor = fuelConsumptionFactor;
    }

    public int getFuelConsumptionFactor() {
        return fuelConsumptionFactor;
    }

}
