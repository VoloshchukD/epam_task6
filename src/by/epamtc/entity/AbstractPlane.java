package by.epamtc.entity;

import java.io.Serializable;

public abstract class AbstractPlane implements Serializable {

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractPlane that = (AbstractPlane) o;

        boolean result = true;
        if (crewCapacity != that.crewCapacity || !engine.equals(that.engine)
                || !modelName.equals(that.modelName)) {
            result = false;
        }

        if (crew.length == that.crew.length) {
            int i = 0;
            while (i < crew.length) {
                if (crew[i] != that.crew[i]) {
                    result = false;
                    break;
                }
                i++;
            }
        } else {
            result = false;
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + engine.hashCode();
        result = 37 * result + modelName.hashCode();
        result = 37 * result + crewCapacity;

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

        return result.toString();
    }

}
