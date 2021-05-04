package by.epamtc.service.sort;

import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.exception.NoSuchParameterException;

import java.util.Comparator;

public class PlaneParametersSorting {

    public static AbstractPlane[] sort(AbstractPlane[] planes, Comparator<AbstractPlane> comparator) throws NoSuchParameterException {
        if (planes == null) {
            throw new NoSuchParameterException("Planes are not present");
        }
        if (comparator == null) {
            throw new NoSuchParameterException("Comparator is not present");
        }

        AbstractPlane[] sortedPlanes = planes.clone();  //shallow copy
        for (int i = 1; i < sortedPlanes.length; i++) {
            int j = i - 1;
            AbstractPlane currentValue = sortedPlanes[i];
            while (j >= 0) {
                if (comparator.compare(currentValue, sortedPlanes[j]) < 0) {
                    sortedPlanes[j + 1] = sortedPlanes[j];
                } else {
                    break;
                }
                j--;
            }
            sortedPlanes[j + 1] = currentValue;
        }
        return sortedPlanes;
    }

}
