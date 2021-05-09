package by.epamtc.entity.plane;

import by.epamtc.exception.NoSuchValueException;

public interface Flyable {

    void fly() throws NoSuchValueException;

    void refuel() throws NoSuchValueException;

}
