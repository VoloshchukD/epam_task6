package by.epamtc.util;

import by.epamtc.entity.plane.additional.Goods;
import by.epamtc.entity.plane.additional.Person;

public class FillArrayAction {

    public static void addPerson(Person person, Person[] persons) {
//        if (person == null) throw new
//        if (persons == null) throw new
        boolean isFull = true;
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == null) {
                persons[i] = person;
                isFull = false;
                break;
            }
        }
//        if (isFull) throw new

    }

    public static void addAllPersons(Person[] fromPersons, Person[] toPersons) {
//        if (persons == null) throw new NullBallsException("Balls in basket are not initialized");
        for (int i = 0; i < fromPersons.length; i++) {
            addPerson(fromPersons[i], toPersons);
        }
    }

    public static void removeAllPersons(Person[] persons) {
//        if (persons == null) throw new NullBallsException("Balls in basket are not initialized");
        for (int i = 0; i < persons.length; i++) {
            persons[i] = null;
        }
    }

    public static Goods[] createArrayWithNewGoods(Goods goods, Goods[] goodsArray) {
        Goods[] newGoods = new Goods[goodsArray.length + 1];
        for (int i = 0; i < newGoods.length; i++) {
            newGoods[i] = goodsArray[i];
        }
        newGoods[goodsArray.length] = goods;
        return newGoods;
    }

}
