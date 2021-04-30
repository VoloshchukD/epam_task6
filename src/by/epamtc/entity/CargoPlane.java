package by.epamtc.entity;

public class CargoPlane extends AbstractPlane {

    public CargoPlane() {
    }

    public CargoPlane(AircraftEngine engine, String modelName, int crewCapacity) {
        super(engine, modelName, crewCapacity);
    }

    public void loadСargo() {

    }

    public void unloadСargo() {

    }

    @Override
    public void fly() {

    }

    @Override
    public String toString() {
        return "CargoPlane{}";
    }
}
