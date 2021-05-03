package by.epamtc.service.sort;

import by.epamtc.entity.plane.AbstractPlane;

import java.util.Comparator;

public class RangeOfFlightComparator implements Comparator<AbstractPlane> {

    @Override
    public int compare(AbstractPlane o1, AbstractPlane o2) {
        int rangeOfFlight1 = o1.getEngine().getRangeOfFlight();
        int rangeOfFlight2 = o2.getEngine().getRangeOfFlight();

        return rangeOfFlight1 - rangeOfFlight2;
    }

}
