package by.epamtc.service;

import by.epamtc.entity.AbstractPlane;
import by.epamtc.entity.AircraftEngine;
import by.epamtc.entity.CargoPlane;
import by.epamtc.service.PlaneFactory;

public class CargoPlaneFactory extends PlaneFactory {

    @Override
    public AbstractPlane createPlane() {
        CargoPlane plane = new CargoPlane();
        AircraftEngine engine = createAircraftEngine();
        plane.setEngine(engine);
        return plane;
    }

}
