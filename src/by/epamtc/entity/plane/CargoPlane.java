package by.epamtc.entity.plane;

import by.epamtc.entity.plane.field.AircraftEngine;
import by.epamtc.entity.plane.field.CargoPlaneWorkload;
import by.epamtc.entity.plane.field.Goods;
import by.epamtc.exception.NoSuchValueException;
import by.epamtc.util.FillArrayAction;

import java.io.Serializable;

public class CargoPlane extends AbstractPlane implements Serializable {

    private int currentLoadWeight;

    private Goods[] loadedGoods;

    private CargoPlaneWorkload workload;

    public CargoPlane() {
    }

    public CargoPlane(AircraftEngine engine, String modelName, int crewCapacity, int destinationDistance) {
        super(engine, modelName, crewCapacity, destinationDistance);
    }

    public CargoPlane(AircraftEngine engine, String modelName, int crewCapacity, int destinationDistance,
                      int currentLoadWeight, Goods[] loadedGoods, CargoPlaneWorkload workload) {
        super(engine, modelName, crewCapacity, destinationDistance);
        this.currentLoadWeight = currentLoadWeight;
        this.loadedGoods = loadedGoods;
        this.workload = workload;
    }

    @Override
    public void fly() throws NoSuchValueException {
        if (getEngine() == null) {
            throw new NoSuchValueException("Engine is not present");
        }
        if (workload.isFlightable()) {
            int consumptionPerKilometer = getEngine().getFuelConsumption();
            int fuelInTank = getEngine().getTankFuelAmount();

            int fuelInTankLeft = fuelInTank - getDestinationDistance() * consumptionPerKilometer;
            getEngine().setTankFuelAmount(fuelInTankLeft);
        }
    }

    public void loadGoods(Goods goods) throws NoSuchValueException {
        if (loadedGoods != null) {
            loadedGoods = FillArrayAction.createArrayWithNewGoods(goods, loadedGoods);
        } else {
            loadedGoods = new Goods[1];
            loadedGoods[0] = goods;
        }
        currentLoadWeight += goods.getWeight();
        recountWorkload();
    }

    public void loadAllGoods(Goods[] goods) throws NoSuchValueException {
        if (goods == null) {
            throw new NoSuchValueException("Goods is not present");
        }
        for (int i = 0; i < goods.length; i++) {
            loadGoods(goods[i]);
        }
    }

    public Goods[] unloadAllGoods() throws NoSuchValueException {
        Goods[] unloadedGoods = loadedGoods;
        loadedGoods = null;
        currentLoadWeight = 0;
        recountWorkload();
        return unloadedGoods;
    }

    private void recountWorkload() throws NoSuchValueException {
        if (getEngine() == null) {
            throw new NoSuchValueException("Engine is not present");
        }
        if (currentLoadWeight <= getEngine().getLiftingCapacity()) {
            workload = CargoPlaneWorkload.OPTIMAL;
        } else {
            workload = CargoPlaneWorkload.OVERLOADED;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CargoPlane that = (CargoPlane) o;

        if (workload == that.workload && currentLoadWeight == that.currentLoadWeight) {
            if (loadedGoods == that.loadedGoods) return true;
            if (loadedGoods == null || that.loadedGoods == null) return false;

            if (loadedGoods.length != that.loadedGoods.length) return false;
            for (int i = 0; i < loadedGoods.length; i++) {
                if (!(loadedGoods[i] == null ? that.loadedGoods[i] == null :
                        loadedGoods[i].equals(that.loadedGoods[i]))) return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + workload.hashCode();
        result = 37 * result + currentLoadWeight;

        int goodsHashcode = 0;
        for (Goods goods : loadedGoods) {
            goodsHashcode += (goods != null) ? goods.hashCode() : 0;
        }
        result = 37 * result + goodsHashcode;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder(getClass().getName());
        result.append(super.toString().replaceFirst(super.getClass().getName(), ""));
        result.append(", workload=");
        result.append(workload);
        result.append(", currentLoadWeight=");
        result.append(currentLoadWeight);
        result.append(", loadedGoods=[");

        String separators = ", ";
        if (loadedGoods != null) {
            for (Goods goods : loadedGoods) {
                result.append(goods);
                result.append(separators);
            }
            result.delete(result.length() - separators.length(), result.length());
        } else {
            result.append(loadedGoods);
        }
        result.append("]");

        return result.toString();
    }

}
