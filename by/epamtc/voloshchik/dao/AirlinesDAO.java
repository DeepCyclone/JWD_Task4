package by.epamtc.voloshchik.dao;

import by.epamtc.voloshchik.beans.airline.AirlinesCompany;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface AirlinesDAO {
    AirlinesCompany read() throws DAOException;
    void write(AirlinesCompany airlinesCompany) throws DAOException;
    void deleteAll();
}
