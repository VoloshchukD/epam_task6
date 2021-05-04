package by.epamtc.service;

import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.entity.plane.field.AircraftEngine;
import by.epamtc.entity.plane.PassengerPlane;

public class PassengerPlaneFactory extends PlaneFactory {

    @Override
    public AbstractPlane createPlane() {
        PassengerPlane plane = new PassengerPlane();
        AircraftEngine engine = createAircraftEngine();
        plane.setEngine(engine);
        return plane;
    }

}
