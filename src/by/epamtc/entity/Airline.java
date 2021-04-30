package by.epamtc.entity;

import by.epamtc.service.PlaneParametersSorting;
import by.epamtc.service.ValueComparator;

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

    public AbstractPlane[] sort () {
        return PlaneParametersSorting.sort(planes, new ValueComparator());
    }


}
