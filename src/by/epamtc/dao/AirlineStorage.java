package by.epamtc.dao;

import by.epamtc.entity.Airline;

import java.io.*;

public class AirlineStorage {

    public static void saveAirline(Airline airline, String fileName) throws IOException {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(airline);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveAirlines(Airline[] airlines, String fileName) throws IOException {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (int i = 0; i < airlines.length; i++) {
                outputStream.writeObject(airlines[i]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Airline getAirline(String fileName) throws IOException {
        Airline airline = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            airline = (Airline) inputStream.readObject();
        } catch(FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return airline;
    }

    public static Airline[] getAirlines(int quantity, String fileName) throws IOException {
        Airline[] airlines = new Airline[quantity];
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            for (int i = 0; i < quantity; i++) {
                airlines[i] = (Airline) inputStream.readObject();
            }
        } catch(FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return airlines;
    }

}
