package by.epamtc.service.sort;

import by.epamtc.entity.plane.AbstractPlane;

import java.util.Comparator;

public class ValueComparator implements Comparator<AbstractPlane> {

    @Override
    public int compare(AbstractPlane o1, AbstractPlane o2) {
        int maxSpeed1 = o1.getEngine().getMaxSpeed();
        int maxSpeed2 = o2.getEngine().getMaxSpeed();

        return maxSpeed1 - maxSpeed2;
    }

}