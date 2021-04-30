package by.epamtc.service;

import by.epamtc.entity.AbstractPlane;
import by.epamtc.entity.AircraftEngine;

public abstract class PlaneFactory {

    public abstract AbstractPlane createPlane();

    public AircraftEngine createAircraftEngine() {
        return new AircraftEngine();
    }

}
