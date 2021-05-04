package by.epamtc.entity.plane.field;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;

    private int weight;

    public Person() {
    }

    public Person(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return weight == person.weight && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 37 * result + name.hashCode();
        result = 37 * result + weight;
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "@name=" + name + ", weight=" + weight;
    }

}
