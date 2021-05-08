package by.epamtc.entity.plane;

import by.epamtc.entity.plane.field.AircraftEngine;
import by.epamtc.entity.plane.field.CargoPlaneWorkload;
import by.epamtc.entity.plane.field.Goods;
import by.epamtc.exception.NoSuchParameterException;
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
    public void fly() throws NoSuchParameterException {
        if (getEngine() == null) {
            throw new NoSuchParameterException("Engine is not present");
        }
        if (workload.isFlightable()) {
            int consumptionPerKilometer = getEngine().getFuelConsumption();
            int fuelInTank = getEngine().getTankFuelAmount();

            int fuelInTankLeft = fuelInTank - getDestinationDistance() * consumptionPerKilometer;
            getEngine().setTankFuelAmount(fuelInTankLeft);
        }
    }

    public void loadGoods(Goods goods) throws NoSuchParameterException {
        if (loadedGoods != null) {
            loadedGoods = FillArrayAction.createArrayWithNewGoods(goods, loadedGoods);
        } else {
            loadedGoods = new Goods[1];
            loadedGoods[0] = goods;
        }
        currentLoadWeight += goods.getWeight();
        recountWorkload();
    }

    public void loadAllGoods(Goods[] goods) throws NoSuchParameterException {
        if (goods == null) {
            throw new NoSuchParameterException("Goods is not present");
        }
        for (int i = 0; i < goods.length; i++) {
            loadGoods(goods[i]);
        }
    }

    public Goods[] unloadAllGoods() throws NoSuchParameterException {
        Goods[] unloadedGoods = loadedGoods;
        loadedGoods = null;
        currentLoadWeight = 0;
        recountWorkload();
        return unloadedGoods;
    }

    private void recountWorkload() throws NoSuchParameterException {
        if (getEngine() == null) {
            throw new NoSuchParameterException("Engine is not present");
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

        boolean result = false;
        if (workload == that.workload && currentLoadWeight == that.currentLoadWeight
                && loadedGoods.length == that.loadedGoods.length) {
            int i = 0;
            while (i < loadedGoods.length) {
                if (loadedGoods[i] == that.loadedGoods[i]) {
                    break;
                }
                i++;
            }
            result = true;
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 37 * result + workload.hashCode();
        result = 37 * result + currentLoadWeight;

        int goodsHashcode = 0;
        for (Goods goods : loadedGoods) {
            goodsHashcode += goods.hashCode();
        }
        result = 31 * result + goodsHashcode;
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
                if (goods != null) {
                    result.append(goods.toString());
                } else {
                    result.append(goods);
                }

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
