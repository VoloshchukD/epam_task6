package by.epamtc.dao;

import by.epamtc.entity.Airline;
import by.epamtc.exception.DAOException;

public interface EntityDAO {

    boolean save(Airline airline) throws DAOException;

    boolean saveAll(Airline[] airlines) throws DAOException;

    Airline load() throws DAOException;

    Airline[] loadAll(int quantity) throws DAOException;

}
