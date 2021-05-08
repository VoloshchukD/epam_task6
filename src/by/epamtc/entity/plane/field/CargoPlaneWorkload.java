package by.epamtc.entity.plane.field;

public enum CargoPlaneWorkload {

    OPTIMAL(true),
    OVERLOADED(false);

    private boolean flightable;

    CargoPlaneWorkload(boolean flightable) {
        this.flightable = flightable;
    }

    public boolean isFlightable() {
        return flightable;
    }

}
