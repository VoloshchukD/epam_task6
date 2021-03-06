package by.epamtc.entity.plane;

import by.epamtc.entity.plane.field.AircraftEngine;
import by.epamtc.entity.plane.field.Person;
import by.epamtc.exception.NoSuchValueException;
import by.epamtc.util.FillArrayAction;

import java.io.Serializable;
import java.util.Arrays;

public abstract class AbstractPlane implements Flyable, Serializable {

    private AircraftEngine engine;

    private String modelName;

    private int crewCapacity = 2;

    private Person[] crew;

    private int destinationDistance;

    public AbstractPlane() {
        this.crew = new Person[crewCapacity];
    }

    public AbstractPlane(AircraftEngine engine, String modelName, int crewCapacity, int destinationDistance) {
        this.engine = engine;
        this.modelName = modelName;
        this.crewCapacity = crewCapacity;
        this.crew = new Person[crewCapacity];
        this.destinationDistance = destinationDistance;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCrewCapacity() {
        return crewCapacity;
    }

    public AircraftEngine getEngine() {
        return engine;
    }

    public void setEngine(AircraftEngine engine) {
        this.engine = engine;
    }

    public int getDestinationDistance() {
        return destinationDistance;
    }

    public void setDestinationDistance(int destinationDistance) {
        this.destinationDistance = destinationDistance;
    }

    @Override
    public void refuel() throws NoSuchValueException {
        if (getEngine() == null) {
            throw new NoSuchValueException("Engine is not present");
        }
        engine.setTankFuelAmount(engine.getMaxFuelTankCapacity());
    }

    public void boardCrewMember(Person crewMember) throws NoSuchValueException {
        FillArrayAction.addPerson(crewMember, crew);
    }

    public void boardAllCrewMembers(Person[] crewMembers) throws NoSuchValueException {
        FillArrayAction.addAllPersons(crewMembers, crew);
    }

    public Person[] boardOffCrew() throws NoSuchValueException {
        Person[] boardedOffCrew = crew;
        FillArrayAction.removeAllPersons(crew);
        return boardedOffCrew;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;

        if (crewCapacity == that.crewCapacity && engine.equals(that.engine)
                && modelName.equals(that.modelName)
                && destinationDistance == that.destinationDistance) {
            if (crew == that.crew) return true;
            if (crew == null || that.crew == null) return false;

            if (crew.length != that.crew.length) return false;
            for (int i = 0; i < crew.length; i++) {
                if (!(crew[i] == null ? that.crew[i] == null : crew[i].equals(that.crew[i]))) return false;
            }
            return true;
        }

        return false;
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
            crewHashcode += (crewMember != null) ? crewMember.hashCode() : 0;
        }

        result = 37 * result + crewHashcode;
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
            result.append((crewMember != null) ? crewMember.toString() : crewMember);
            result.append(separators);
        }
        result.delete(result.length() - separators.length() - 1, result.length());
        result.append("]");

        result.append(", destinationDistance=");
        result.append(destinationDistance);

        return result.toString();
    }

}
