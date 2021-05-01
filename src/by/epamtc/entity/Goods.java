package by.epamtc.entity;

import java.io.Serializable;

public class Goods implements Serializable {

    private String ownerInformation;

    private String destination;

    private int weight;

    private boolean isFragile;

    public Goods() {
    }

    public Goods(String ownerInformation, String destination, int weight, boolean isFragile) {
        this.ownerInformation = ownerInformation;
        this.destination = destination;
        this.weight = weight;
        this.isFragile = isFragile;
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
        return isFragile;
    }

    public void setFragile(boolean fragile) {
        isFragile = fragile;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;

        boolean result = false;
        if (weight == goods.weight && isFragile == goods.isFragile
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
        result = 37 * result + (isFragile ? 0 : 1);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() + "@" +
                "ownerInformation=" + ownerInformation +
                ", destination=" + destination +
                ", weight=" + weight +
                ", isFragile=" + isFragile;
    }

}
