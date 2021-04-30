package by.epamtc.service;

import by.epamtc.entity.AbstractPlane;
import by.epamtc.entity.AircraftEngine;
import by.epamtc.entity.PassengerPlane;
import by.epamtc.service.PlaneFactory;

public class PassengerPlaneFactory extends PlaneFactory {

    @Override
    public AbstractPlane createPlane() {
        PassengerPlane plane = new PassengerPlane();
        AircraftEngine engine = createAircraftEngine();
        plane.setEngine(engine);
        return plane;
    }

}
