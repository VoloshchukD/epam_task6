package by.epamtc.util;

import by.epamtc.entity.plane.field.Goods;
import by.epamtc.entity.plane.field.Person;
import by.epamtc.exception.NoSuchValueException;

public class FillArrayAction {

    public static void addPerson(Person person, Person[] persons) throws NoSuchValueException {
        if (person == null) {
            throw new NoSuchValueException("Person is not present");
        }
        if (persons == null) {
            throw new NoSuchValueException("Persons are not present");
        }

        int i = 0;
        while (i < persons.length) {
            if (persons[i] == null) {
                persons[i] = person;
                break;
            }
            i++;
        }
    }

    public static void addAllPersons(Person[] fromPersons, Person[] toPersons) throws NoSuchValueException {
        if (fromPersons == null) {
            throw new NoSuchValueException("Persons to add are not present");
        }
        if (toPersons == null) {
            throw new NoSuchValueException("Persons where to add are not present");
        }

        for (int i = 0; i < fromPersons.length; i++) {
            addPerson(fromPersons[i], toPersons);
        }
    }

    public static void removeAllPersons(Person[] persons) throws NoSuchValueException {
        if (persons == null) {
            throw new NoSuchValueException("Persons are not present");
        }
        for (int i = 0; i < persons.length; i++) {
            persons[i] = null;
        }
    }

    public static Goods[] createArrayWithNewGoods(Goods newGoods, Goods[] goodsArray) throws NoSuchValueException {
        if (newGoods == null) {
            throw new NoSuchValueException("Goods is not present");
        }
        if (goodsArray == null) {
            throw new NoSuchValueException("Goods array where to add goods is not present");
        }

        Goods[] newGoodsArray = new Goods[goodsArray.length + 1];
        for (int i = 0; i < goodsArray.length; i++) {
            newGoodsArray[i] = goodsArray[i];
        }
        newGoodsArray[goodsArray.length] = newGoods;
        return newGoodsArray;
    }

}
