package by.epamtc.entity.plane;

import by.epamtc.exception.NoSuchParameterException;

public interface Flyable {

    void fly() throws NoSuchParameterException;

    void refuel() throws NoSuchParameterException;

}
