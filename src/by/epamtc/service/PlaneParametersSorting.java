package by.epamtc.service;

import by.epamtc.entity.AbstractPlane;

import java.util.Comparator;

public class PlaneParametersSorting {

    public static AbstractPlane[] sort(AbstractPlane[] planes, Comparator<AbstractPlane> comparator) {
        //copy array
        for (int i = 1; i < planes.length; i++) {
            int j = i - 1;
            AbstractPlane currentValue = planes[i];
            while (j >= 0) {
                if (comparator.compare(currentValue, planes[j]) < 0) {
                    planes[j + 1] = planes[j];
                } else {
                    break;
                }
                j--;
            }
            planes[j + 1] = currentValue;
        }
        return planes;
    }

}
