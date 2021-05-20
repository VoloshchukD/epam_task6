package by.epamtc.dao.impl;

import by.epamtc.dao.EntityDAO;
import by.epamtc.entity.Airline;
import by.epamtc.exception.DAOException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;

public class AirlineDAO implements EntityDAO {

    private String sourceFileName;

    public AirlineDAO(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public String getSourceFileName() {
        return sourceFileName;
    }

    public void setSourceFileName(String sourceFileName) {
        this.sourceFileName = sourceFileName;
    }

    public boolean save(Airline airline) throws DAOException {
        if (airline == null) {
            throw new DAOException("Airline is not present");
        }
        if (sourceFileName == null) {
            throw new DAOException("FileName is not present");
        }

        boolean isSaved = false;
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(sourceFileName))) {
            outputStream.writeObject(airline);
            isSaved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public boolean saveAll(Airline[] airlines) throws DAOException {
        if (airlines == null) {
            throw new DAOException("Airlines are not present");
        }
        if (sourceFileName == null) {
            throw new DAOException("FileName is not present");
        }

        boolean isSaved = false;
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(sourceFileName))) {
            for (int i = 0; i < airlines.length; i++) {
                outputStream.writeObject(airlines[i]);
            }
            isSaved = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    public Airline load() throws DAOException {
        if (sourceFileName == null) {
            throw new DAOException("FileName is not present");
        }

        Airline airline = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(sourceFileName))) {
            airline = (Airline) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return airline;
    }

    public Airline[] loadAll(int quantity) throws DAOException {
        if (quantity < 0) {
            throw new DAOException("Quantity cant be negative");
        }
        if (sourceFileName == null) {
            throw new DAOException("FileName is not present");
        }

        Airline[] airlines = new Airline[quantity];
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(sourceFileName))) {
            for (int i = 0; i < quantity; i++) {
                airlines[i] = (Airline) inputStream.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return airlines;
    }

}
