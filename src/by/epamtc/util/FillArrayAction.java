package by.epamtc.util;

import by.epamtc.entity.plane.field.Goods;
import by.epamtc.entity.plane.field.Person;
import by.epamtc.exception.NoSuchParameterException;

public class FillArrayAction {

    public static void addPerson(Person person, Person[] persons) throws NoSuchParameterException {
        if (person == null) {
            throw new NoSuchParameterException("Person is not present");
        }
        if (persons == null) {
            throw new NoSuchParameterException("Persons are not present");
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

    public static void addAllPersons(Person[] fromPersons, Person[] toPersons) throws NoSuchParameterException {
        if (fromPersons == null) {
            throw new NoSuchParameterException("Persons to add are not present");
        }
        if (toPersons == null) {
            throw new NoSuchParameterException("Persons where to add are not present");
        }

        for (int i = 0; i < fromPersons.length; i++) {
            addPerson(fromPersons[i], toPersons);
        }
    }

    public static void removeAllPersons(Person[] persons) throws NoSuchParameterException {
        if (persons == null) {
            throw new NoSuchParameterException("Persons are not present");
        }
        for (int i = 0; i < persons.length; i++) {
            persons[i] = null;
        }
    }

    public static Goods[] createArrayWithNewGoods(Goods goods, Goods[] goodsArray) throws NoSuchParameterException {
        if (goods == null) {
            throw new NoSuchParameterException("Goods is not present");
        }
        if (goodsArray == null) {
            throw new NoSuchParameterException("Goods array where to add goods is not present");
        }

        Goods[] newGoods = new Goods[goodsArray.length + 1];
        for (int i = 0; i < goodsArray.length; i++) {
            newGoods[i] = goodsArray[i];
        }
        newGoods[goodsArray.length] = goods;
        return newGoods;
    }

}
