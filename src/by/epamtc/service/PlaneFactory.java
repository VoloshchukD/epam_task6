package by.epamtc.service;

import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.entity.plane.additional.AircraftEngine;

public abstract class PlaneFactory {

    public abstract AbstractPlane createPlane();

    public AircraftEngine createAircraftEngine() {
        return new AircraftEngine();
    }

}
