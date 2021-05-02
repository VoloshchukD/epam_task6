package by.epamtc.entity;

import by.epamtc.util.FillArrayAction;

import java.io.Serializable;

public abstract class AbstractPlane implements Serializable {

    private AircraftEngine engine;

    private String modelName;

    private int crewCapacity;

    private Person[] crew;

    private int destinationDistance;

    public AbstractPlane() {
    }

    public AbstractPlane(AircraftEngine engine, String modelName, int crewCapacity, int destinationDistance) {
        this.engine = engine;
        this.modelName = modelName;
        this.crewCapacity = crewCapacity;
        this.destinationDistance = destinationDistance;
    }

    public AbstractPlane(AircraftEngine engine, String modelName,
                         int crewCapacity, Person[] crew, int destinationDistance) {
        this.engine = engine;
        this.modelName = modelName;
        this.crewCapacity = crewCapacity;
        this.crew = crew;
        this.destinationDistance = destinationDistance;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public void setCrewCapacity(int crewCapacity) {
        this.crewCapacity = crewCapacity;
    }

    public Person[] getCrew() {
        return crew;
    }

    public void setCrew(Person[] crew) {
        this.crew = crew;
    }

    public AircraftEngine getEngine() {
        return engine;
    }

    public void setEngine(AircraftEngine engine) {
        this.engine = engine;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public int getDestinationDistance() {
        return destinationDistance;
    }

    public void setDestinationDistance(int destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    public abstract void fly();

    public void refuel() {
        engine.setTankFuelAmount(engine.getMaxFuelTankCapacity());
    }

    public void boardCrewMember(Person crewMember) {
        FillArrayAction.addPerson(crewMember, crew);
    }

    public void boardAllCrewMembers(Person[] crewMembers) {
        FillArrayAction.addAllPersons(crewMembers, crew);
    }

    public void boardOffCrew() {
        FillArrayAction.removeAllPersons(crew);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;

        boolean result = false;
        if (crewCapacity == that.crewCapacity && engine.equals(that.engine)
                && modelName.equals(that.modelName)
                && destinationDistance == that.destinationDistance
                && crew.length == that.crew.length) {
            int i = 0;
            while (i < crew.length) {
                if (crew[i] != that.crew[i]) {
                    break;
                }
                i++;
            }
            result = true;
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + engine.hashCode();
        result = 37 * result + modelName.hashCode();
        result = 37 * result + crewCapacity;
        result = 37 * result + destinationDistance;

        int crewHashcode = 0;
        for (Person crewMember : crew) {
            crewHashcode += crewMember.hashCode();
        }

        result = 31 * result + crewHashcode;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName());
        result.append("@engine=");
        result.append(engine.toString());
        result.append(", modelName=");
        result.append(modelName);
        result.append(", crewCapacity=");
        result.append(crewCapacity);
        result.append(", crew=[");

        String separators = ", ";
        for (Person crewMember : crew) {
            result.append(crewMember.toString());
            result.append(separators);
        }
        result.delete(result.length() - separators.length() - 1, result.length());
        result.append("]");

        result.append(", destinationDistance=");
        result.append(destinationDistance);

        return result.toString();
    }

}
