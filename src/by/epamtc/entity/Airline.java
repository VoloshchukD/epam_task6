package by.epamtc.entity;

import by.epamtc.service.sort.PlaneParametersSorting;
import by.epamtc.service.sort.ValueComparator;

public class Airline {

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

    public AbstractPlane[] sort() {
        return PlaneParametersSorting.sort(planes, new ValueComparator());
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

}
