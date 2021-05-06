package by.epamtc.entity.plane.field;

import java.io.Serializable;

public class Goods implements Serializable {

    private String ownerInformation;

    private String destination;

    private int weight;

    private boolean fragile;

    public Goods() {
    }

    public Goods(String ownerInformation, String destination, int weight, boolean fragile) {
        this.ownerInformation = ownerInformation;
        this.destination = destination;
        this.weight = weight;
        this.fragile = fragile;
    }

    public String getOwnerInformation() {
        return ownerInformation;
    }

    public void setOwnerInformation(String ownerInformation) {
        this.ownerInformation = ownerInformation;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;

        boolean result = false;
        if (weight == goods.weight && fragile == goods.fragile
                && ownerInformation.equals(goods.ownerInformation)
                && destination.equals(goods.destination)) {
            result = true;
        }

        return result;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + ownerInformation.hashCode();
        result = 37 * result + destination.hashCode();
        result = 37 * result + weight;
        result = 37 * result + (fragile ? 0 : 1);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "@ownerInformation=" + ownerInformation +
                ", destination=" + destination +
                ", weight=" + weight +
                ", fragile=" + fragile;
    }

}
