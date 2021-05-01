package by.epamtc.entity;

import java.io.Serializable;

public class CargoPlane extends AbstractPlane implements Serializable {

    private CargoPlaneWorkload workload;

    private CargoPlaneLoadDistribution loadDistribution;

    public CargoPlane() {
    }

    public CargoPlane(AircraftEngine engine, String modelName, int crewCapacity) {
        super(engine, modelName, crewCapacity);
    }

    public CargoPlaneWorkload getWorkload() {
        return workload;
    }

    public void setWorkload(CargoPlaneWorkload workload) {
        this.workload = workload;
    }

    public CargoPlaneLoadDistribution getLoadDistribution() {
        return loadDistribution;
    }

    public void setLoadDistribution(CargoPlaneLoadDistribution loadDistribution) {
        this.loadDistribution = loadDistribution;
    }

    @Override
    public void fly() {

    }

    public void loadСargo() {

    }

    public void unloadСargo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;
        return workload == that.workload && loadDistribution == that.loadDistribution;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + workload.hashCode();
        result = 37 * result + loadDistribution.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "workload=" + workload +
                ", loadDistribution=" + loadDistribution;
    }

}
