package by.epamtc.dao;

import by.epamtc.entity.Airline;
import by.epamtc.exception.NoSuchValueException;
import by.epamtc.exception.ValueOutOfBoundsException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

public class AirlineStorage {

    public static void saveAirline(Airline airline, String fileName) throws NoSuchValueException {
        if (airline == null) {
            throw new NoSuchValueException("Airline is not present");
        }
        if (fileName == null) {
            throw new NoSuchValueException("FileName is not present");
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(airline);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAirlines(Airline[] airlines, String fileName) throws NoSuchValueException {
        if (airlines == null) {
            throw new NoSuchValueException("Airlines are not present");
        }
        if (fileName == null) {
            throw new NoSuchValueException("FileName is not present");
        }

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < airlines.length; i++) {
                outputStream.writeObject(airlines[i]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Airline getAirline(String fileName) throws NoSuchValueException {
        if (fileName == null) {
            throw new NoSuchValueException("FileName is not present");
        }

        Airline airline = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            airline = (Airline) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return airline;
    }

    public static Airline[] getAirlines(int quantity, String fileName) throws NoSuchValueException,
            ValueOutOfBoundsException {
        if (quantity < 0) {
            throw new ValueOutOfBoundsException("Quantity cant be negative");
        }
        if (fileName == null) {
            throw new NoSuchValueException("FileName is not present");
        }

        Airline[] airlines = new Airline[quantity];
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            for (int i = 0; i < quantity; i++) {
                airlines[i] = (Airline) inputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return airlines;
    }

}
