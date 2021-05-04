package by.epamtc.entity;

import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.service.sort.PlaneParametersSorting;

import java.io.Serializable;
import java.util.Comparator;

public class Airline implements Serializable {

    private String name;

    private AbstractPlane[] planes;

    public Airline() {
    }

    public Airline(String name, AbstractPlane[] planes) {
        this.name = name;
        this.planes = planes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AbstractPlane[] getPlanes() {
        return planes;
    }

    public void setPlanes(AbstractPlane[] planes) {
        this.planes = planes;
    }

    public AbstractPlane[] sort(Comparator<AbstractPlane> comparator) {
        return PlaneParametersSorting.sort(planes, comparator);
    }

    public int countTotalLiftingCapacity() {
        int totalLiftingCapacity = 0;

        for (int i = 0; i < planes.length; i++) {
            totalLiftingCapacity += planes[i].getEngine().getLiftingCapacity();
        }

        return totalLiftingCapacity;
    }

    public int countTotalCrewCapacity() {
        int totalCrewCapacity = 0;

        for (int i = 0; i < planes.length; i++) {
            totalCrewCapacity += planes[i].getCrewCapacity();
        }

        return totalCrewCapacity;
    }

    public AbstractPlane[] findPlanesByFuelConsumption(int minFuelConsumption, int maxFuelConsumption) {
        AbstractPlane[] planesCopy = new AbstractPlane[planes.length];

        int j = 0;
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].getEngine().getFuelConsumption() <= maxFuelConsumption
                    && planes[i].getEngine().getFuelConsumption() >= minFuelConsumption) {
                planesCopy[j] = planes[i];
                j++;
            }
        }

        return removeNullPlanes(planesCopy, j);
    }

    private AbstractPlane[] removeNullPlanes(AbstractPlane[] array, int newLength) {
        AbstractPlane[] resultPlanes = new AbstractPlane[newLength];
        int i = 0;
        int j = 0;
        while (i < array.length) {
            if (j >= newLength) {
                break;
            }
            if (array[i] != null) {
                resultPlanes[j] = array[i];
                j++;
            }
            i++;
        }
        return resultPlanes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;

        boolean result = false;
        if (name == airline.name
                && planes.length == airline.planes.length) {
            int i = 0;
            while (i < planes.length) {
                if (planes[i] != airline.planes[i]) {
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
        result = 37 * result + name.hashCode();

        int planesHashcode = 0;
        for (AbstractPlane plane : planes) {
            planesHashcode += plane.hashCode();
        }

        result = 37 * result + planesHashcode;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName());
        result.append("@name=");
        result.append(name);
        result.append(", planes=[");

        if (planes != null) {
            String separators = ", ";
            for (AbstractPlane plane : planes) {
                if (plane != null) {
                    result.append(plane.toString());
                } else {
                    result.append(plane);
                }
                result.append(separators);
            }
            result.delete(result.length() - separators.length(), result.length());
        }
        result.append("]");
        return result.toString();
    }

}
