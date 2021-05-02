package by.epamtc.service;

import by.epamtc.entity.plane.AbstractPlane;
import by.epamtc.entity.plane.additional.AircraftEngine;
import by.epamtc.entity.plane.CargoPlane;

public class CargoPlaneFactory extends PlaneFactory {

    @Override
    public AbstractPlane createPlane() {
        CargoPlane plane = new CargoPlane();
        AircraftEngine engine = createAircraftEngine();
        plane.setEngine(engine);
        return plane;
    }

}
