package by.epamtc.entity;

import java.util.Arrays;

public abstract class AbstractPlane {

    private AircraftEngine engine;

    private String modelName;

    private int crewCapacity;

    private Person[] crew;

    public AbstractPlane() {
    }

    public AbstractPlane(AircraftEngine engine, String modelName, int crewCapacity) {
        this.engine = engine;
        this.modelName = modelName;
        this.crewCapacity = crewCapacity;
        this.crew = new Person[crewCapacity];
    }

    public AircraftEngine getEngine() {
        return engine;
    }

    public void setEngine(AircraftEngine engine) {
        this.engine = engine;
    }

    public abstract void fly();

    public void refuel() {
        engine.setTankFuelAmount(engine.getMaxFuelTankCapacity());
    }

    public void boardCrewMember(Person crewMember) {
//        if (person == null) throw new
        boolean isFull = true;
        for (int i = 0; i < crew.length; i++) {
            if (crew[i] == null) {
                crew[i] = crewMember;
                isFull = false;
                break;
            }
        }
//        if (isFull) throw new

    }

    public void boardAllCrewMembers(Person[] crewMembers) {
//        if (persons == null) throw new NullBallsException("Balls in basket are not initialized");
        for (int i = 0; i < crewMembers.length; i++) {
            boardCrewMember(crewMembers[i]);
        }
    }

    public void boardOffCrew() {
        for (int i = 0; i < crew.length; i++) {
            crew[i] = null;
        }
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "engine=" + engine +
                ", modelName='" + modelName + '\'' +
                ", crewCapacity=" + crewCapacity +
                ", crew=" + Arrays.toString(crew);
    }
}
