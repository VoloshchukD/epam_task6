package by.epamtc.entity;

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

    public int getCurrentLoadWeight() {
        return currentLoadWeight;
    }

    public void setCurrentLoadWeight(int currentLoadWeight) {
        this.currentLoadWeight = currentLoadWeight;
    }

    public CargoPlaneWorkload getWorkload() {
        return workload;
    }

    public void setWorkload(CargoPlaneWorkload workload) {
        this.workload = workload;
    }

    public Goods[] getLoadedGoods() {
        return loadedGoods;
    }

    public void setLoadedGoods(Goods[] loadedGoods) {
        this.loadedGoods = loadedGoods;
    }

    @Override
    public void fly() {
        if (workload.getFlightable()) {
            int consumptionPerKilometer = getEngine().getFuelConsumption();
            int fuelInTank = getEngine().getTankFuelAmount();

            int fuelInTankLeft = fuelInTank - getDestinationDistance() * consumptionPerKilometer *
                    workload.getFuelConsumptionFactor();
            getEngine().setTankFuelAmount(fuelInTankLeft);
        }
    }

    public void loadGoods(Goods goods) {
        //if (goods == null) throw new
        if (loadedGoods != null) {
            loadedGoods = FillArrayAction.createArrayWithNewGoods(goods, loadedGoods);

        } else {
            loadedGoods = new Goods[1];
            loadedGoods[0] = goods;
        }
        currentLoadWeight += goods.getWeight();
        recountWorkload();
    }

    public void loadAllGoods(Goods[] goods) {
        for (int i = 0; i < goods.length; i++) {
            loadGoods(goods[i]);
        }
    }

    public Goods[] unloadAllGoods() {
        Goods[] unloadedGoods = loadedGoods;
        loadedGoods = null;
        currentLoadWeight = 0;
        recountWorkload();
        return unloadedGoods;
    }

    private void recountWorkload() {
        if (currentLoadWeight == 0) {
            workload = CargoPlaneWorkload.EMPTY;
        } else if (getEngine().getLiftingCapacity() / 2 == currentLoadWeight) {
            workload = CargoPlaneWorkload.HALF_FULL_OF_GOODS;
        } else if (getEngine().getLiftingCapacity() / 2 < currentLoadWeight) {
            workload = CargoPlaneWorkload.MORE_THAN_HALF_FULL;
        } else if (getEngine().getLiftingCapacity() / 2 > currentLoadWeight) {
            workload = CargoPlaneWorkload.LESS_THAN_HALF_FULL;
        } else if (getEngine().getLiftingCapacity() == currentLoadWeight) {
            workload = CargoPlaneWorkload.FULL_OF_GOODS;
        } else if (getEngine().getLiftingCapacity() < currentLoadWeight) {
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
        result.append("@workload=");
        result.append(workload.toString());
        result.append(", currentLoadWeight=");
        result.append(currentLoadWeight);
        result.append(", loadedGoods=[");

        String separators = ", ";
        for (Goods goods : loadedGoods) {
            result.append(goods.toString());
            result.append(separators);
        }
        result.delete(result.length() - separators.length() - 1, result.length());
        result.append("]");

        return result.toString();
    }

}
