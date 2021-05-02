package by.epamtc.dao;

import by.epamtc.entity.Airline;

import java.io.*;

public class AirlineStorage {

    public static void saveAirline(Airline airline) throws FileNotFoundException {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            outputStream.writeObject(airline);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Airline getAirline() throws IOException {
        Airline airline = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("data.txt"))) {
            airline = (Airline) inputStream.readObject();
        } catch(FileNotFoundException | ClassNotFoundException ex){
            System.out.println(ex.getMessage());
        }
        return airline;
    }

}
