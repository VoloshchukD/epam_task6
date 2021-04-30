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

}
